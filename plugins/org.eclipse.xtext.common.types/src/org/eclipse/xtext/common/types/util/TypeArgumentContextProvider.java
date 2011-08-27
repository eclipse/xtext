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
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
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
	
	@Inject
	private SuperTypeCollector superTypeCollector;
	
	public static class ResolveInfo {
		public JvmTypeReference reference;
		protected boolean exactMatch;
		protected boolean preferSubtypes;
		protected boolean superTypeAllowed;
		
		public ResolveInfo(JvmTypeReference reference) {
			this.reference = reference;
		}

		protected ResolveInfo copyIfDifferent(JvmTypeReference reference) {
			if (reference == this.reference)
				return this;
			ResolveInfo result = new ResolveInfo(reference);
			result.exactMatch = exactMatch;
			result.preferSubtypes = preferSubtypes;
			result.superTypeAllowed = superTypeAllowed;
			return result;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (exactMatch ? 1231 : 1237);
			result = prime * result + (preferSubtypes ? 1231 : 1237);
			result = prime * result + ((reference == null) ? 0 : reference.hashCode());
			result = prime * result + (superTypeAllowed ? 1231 : 1237);
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
			ResolveInfo other = (ResolveInfo) obj;
			if (exactMatch != other.exactMatch)
				return false;
			if (preferSubtypes != other.preferSubtypes)
				return false;
			if (reference == null) {
				if (other.reference != null)
					return false;
			} else if (!reference.equals(other.reference))
				return false;
			if (superTypeAllowed != other.superTypeAllowed)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return reference.toString();
		}
		
	}
	
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
		return get(Collections.<JvmTypeParameter,ResolveInfo>emptyMap());
	}
	
	public TypeArgumentContext get(Map<JvmTypeParameter, ResolveInfo> context) {
		final Map<JvmTypeParameter, ResolveInfo> resolved = resolveTypeParametersReferencedInTypeParameters(context, false);
		return new TypeArgumentContext(resolved, typeProviderFactory, typeReferences);
	}
	
	public TypeArgumentContext getReceiverContext(JvmTypeReference receiver) {
		Map<JvmTypeParameter, ResolveInfo> map = resolveReceiver(receiver);
		return get(map);
	}
	
	public TypeArgumentContext getReceiverContext(JvmTypeReference receiverType, JvmTypeReference featureType, JvmTypeReference expectedType) {
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		if (receiverType!=null) {
			map.putAll(Multimaps.forMap(resolveReceiver(receiverType)));
		}
		map.putAll(Multimaps.forMap(resolveInferredTypeArgContext(featureType, expectedType, false)));
		Map<JvmTypeParameter, ResolveInfo> result = internalFindBestMatches(map);
		return get(result);
	}
	
	protected Map<JvmTypeParameter,ResolveInfo> resolveInferredTypeArgContext(JvmTypeReference featureType, JvmTypeReference expectation, 
			boolean ignoreOperationTypeParameters) {
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		if (expectation != null) {
			ResolveInfo info = new ResolveInfo(expectation);
			info.preferSubtypes = true;
			resolve(featureType, info, map, ignoreOperationTypeParameters);
		}
		return internalFindBestMatches(map);
	}
	
	/**
	 * <p>Creates a type argument context explicitly declared type arguments.</p>
	 * 
	 * @param parameterDeclarator the declarator whose parameters should be matched with the arguments
	 * @param receiverType the resolved type of the message receiver
	 * @param typeArguments the explicit type arguments of the sent message
	 * @return the type argument context. Is never <code>null</code>.
	 */
	public TypeArgumentContext getExplicitMethodInvocationContext(JvmTypeParameterDeclarator parameterDeclarator, JvmTypeReference receiverType,
			List<JvmTypeReference> typeArguments) {
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		if (receiverType!=null) {
			map.putAll(Multimaps.forMap(resolveReceiver(receiverType)));
		}
		Map<JvmTypeParameter, ResolveInfo> explicitArguments = Maps.newHashMap();
		List<JvmTypeParameter> typeParameters = parameterDeclarator.getTypeParameters();
		int max = Math.min(typeParameters.size(), typeArguments.size());
		for(int i = 0; i < max; i++) {
			ResolveInfo info = new ResolveInfo(typeArguments.get(i));
			info.exactMatch = true;
			explicitArguments.put(typeParameters.get(i), info);
		}
		map.putAll(Multimaps.forMap(resolveTypeParametersReferencedInTypeParameters(explicitArguments, false)));
		Map<JvmTypeParameter, ResolveInfo> result = internalFindBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext injectReceiverContext(TypeArgumentContext context, JvmTypeReference receiverType) {
		if (receiverType == null)
			return context;
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		map.putAll(Multimaps.forMap(context.getContextMap()));
		map.putAll(Multimaps.forMap(resolveReceiver(receiverType)));
		Map<JvmTypeParameter, ResolveInfo> result = internalFindBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext injectArgumentTypeContext(TypeArgumentContext context, JvmOperation operation, boolean ignoreEmptyVarArgs, JvmTypeReference ... actualArgumentTypes) {
		if (actualArgumentTypes.length == 0 && (!operation.isVarArgs() || ignoreEmptyVarArgs))
			return context;
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		map.putAll(Multimaps.forMap(context.getContextMap()));
		map.putAll(Multimaps.forMap(resolveInferredMethodTypeArgContext(operation, operation.getReturnType(), null, ignoreEmptyVarArgs, actualArgumentTypes)));
		Map<JvmTypeParameter, ResolveInfo> result = internalFindBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext injectArgumentTypeContext(TypeArgumentContext context, JvmConstructor operation, JvmTypeReference createdResult, boolean ignoreEmptyVarArgs, JvmTypeReference ... actualArgumentTypes) {
		if (actualArgumentTypes.length == 0 && (!operation.isVarArgs() || ignoreEmptyVarArgs))
			return context;
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		map.putAll(Multimaps.forMap(context.getContextMap()));
		map.putAll(Multimaps.forMap(resolveInferredMethodTypeArgContext(operation, createdResult, null, ignoreEmptyVarArgs, actualArgumentTypes)));
		Map<JvmTypeParameter, ResolveInfo> result = internalFindBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext injectExpectedTypeContext(TypeArgumentContext context, JvmOperation operation, JvmTypeReference expectedType) {
		if (expectedType == null)
			return context;
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		map.putAll(Multimaps.forMap(context.getContextMap()));
		map.putAll(Multimaps.forMap(resolveInferredMethodTypeArgContext(operation, operation.getReturnType(), expectedType, (JvmTypeReference[]) null)));
		Map<JvmTypeParameter, ResolveInfo> result = internalFindBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext injectExpectedTypeContext(TypeArgumentContext context, JvmConstructor constructor, JvmTypeReference createdResult, JvmTypeReference expectedType) {
		if (expectedType == null)
			return context;
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		map.putAll(Multimaps.forMap(context.getContextMap()));
		map.putAll(Multimaps.forMap(resolveInferredMethodTypeArgContext(constructor, createdResult, expectedType, (JvmTypeReference[]) null)));
		Map<JvmTypeParameter, ResolveInfo> result = internalFindBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext getInferredMethodInvocationContext(JvmOperation op, JvmTypeReference receiverType, JvmTypeReference expectedReturnType, JvmTypeReference ... actualArgumentTypes) {
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		if (receiverType!=null) {
			map.putAll(Multimaps.forMap(resolveReceiver(receiverType)));
		}
		if (!op.getTypeParameters().isEmpty() || map.isEmpty())
			map.putAll(Multimaps.forMap(resolveInferredMethodTypeArgContext(op, op.getReturnType(), expectedReturnType, actualArgumentTypes)));
		
		Map<JvmTypeParameter, ResolveInfo> result = internalFindBestMatches(map);
		return get(result);
	}
	
	protected Map<JvmTypeParameter, ResolveInfo> resolveTypeParametersReferencedInTypeParameters(Map<JvmTypeParameter, ResolveInfo> context, boolean ignoreOperationArguments) {
		Multimap<JvmTypeParameter, ResolveInfo> result = LinkedHashMultimap.create(Multimaps.forMap(context));
		for (Entry<JvmTypeParameter, ResolveInfo> entry : context.entrySet()) {
			List<JvmTypeConstraint> constraints = entry.getKey().getConstraints();
			if (!constraints.isEmpty()) {
				resolve(entry.getKey(), entry.getValue(), result, ignoreOperationArguments);
			}
		}
		return internalFindBestMatches(result);
	}
	
	protected Map<JvmTypeParameter, ResolveInfo> resolveReceiver(JvmTypeReference contextRef) {
		if (contextRef==null || contextRef.getType() instanceof JvmPrimitiveType) {
			return emptyMap();
		}
		Multimap<JvmTypeParameter, ResolveInfo> context = LinkedHashMultimap.create();
		internalComputeContext(contextRef, context, Sets.<JvmType>newHashSet(contextRef.getType()));
		return internalFindBestMatches(context);
	}
	
	public Map<JvmTypeParameter, ResolveInfo> resolveInferredMethodTypeArgContext(JvmFeature feature, JvmTypeReference returnType, JvmTypeReference expectation, JvmTypeReference... argumentTypes) {
		return resolveInferredMethodTypeArgContext(feature, returnType, expectation, false, argumentTypes);
	}
	
	public Map<JvmTypeParameter, ResolveInfo> resolveInferredMethodTypeArgContext(JvmFeature feature, JvmTypeReference returnType, JvmTypeReference expectation, boolean ignoreEmptyVarArgs, JvmTypeReference... argumentTypes) {
		Multimap<JvmTypeParameter, ResolveInfo> map = LinkedHashMultimap.create();
		if (feature instanceof JvmExecutable) {
			JvmExecutable op = (JvmExecutable) feature;
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
						ResolveInfo info = new ResolveInfo(actualArgumentType);
						info.superTypeAllowed = true;
						resolve(declaredParameterType, info, map, false);
					}
				}
				if (op.isVarArgs()) {
					JvmTypeReference parameterType = op.getParameters().get(paramCount).getParameterType();
					if (!(parameterType instanceof JvmGenericArrayTypeReference)) {
						throw new IllegalStateException("VarArg methods expect last paramter to be an array type");
					}
					JvmTypeReference componentType = ((JvmGenericArrayTypeReference) parameterType).getComponentType();
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
						ResolveInfo info = new ResolveInfo(commonVarArgType);
						info.superTypeAllowed = true;
						resolve(componentType, info, map, false);
					} else if (!ignoreEmptyVarArgs) {
						JvmTypeReference information = computeVarArgTypeInformation(feature, componentType.getType());
						ResolveInfo info = new ResolveInfo(information);
						info.superTypeAllowed = true;
						info.preferSubtypes = true;
						resolve(componentType, info, map, false);
					}
				}
			}
			//try infer from the context type
			if (expectation != null && returnType != null) {
				ResolveInfo info = new ResolveInfo(expectation);
				info.preferSubtypes = true;
				resolve(returnType, info, map, true);
			}
		}
		return internalFindBestMatches(map);
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

	protected Map<JvmTypeParameter, ResolveInfo> internalFindBestMatches(Multimap<JvmTypeParameter, ResolveInfo> map) {
		Map<JvmTypeParameter, ResolveInfo> result = newHashMap();
		for (JvmTypeParameter param : map.keySet()) {
			Collection<ResolveInfo> infos = map.get(param);
			for (ResolveInfo info : infos) {
				if (result.containsKey(param)) {
					ResolveInfo currentBestMatch = result.get(param);
					ResolveInfo better = getBetterMatch(currentBestMatch, info);
					result.put(param, better);
				} else {
					result.put(param, info);
				}
			}
		}
		return result;
	}

	protected ResolveInfo getBetterMatch(ResolveInfo current, ResolveInfo isBetter) {
		if (!isResolved(current.reference)) {
			if (isResolved(isBetter.reference))
				return isBetter;
			return current;
		}
		if (current.reference instanceof JvmAnyTypeReference) {
			if (isBetter.reference instanceof JvmAnyTypeReference)
				return current;
			return isBetter;
		}
		if (isBetter.reference instanceof JvmAnyTypeReference)
			return current;
		if (isResolved(isBetter.reference) && !EcoreUtil.equals(current.reference, isBetter.reference)) {
			if (current.exactMatch && !(current.reference instanceof JvmWildcardTypeReference))
				return current;
			if (isBetter.exactMatch && !(isBetter.reference instanceof JvmWildcardTypeReference))
				return isBetter;
			if (current.preferSubtypes && this.conformanceComputer.isConformant(current.reference, isBetter.reference))
				return isBetter;
			if (isBetter.preferSubtypes && this.conformanceComputer.isConformant(isBetter.reference, current.reference) && !(current.reference instanceof JvmWildcardTypeReference))
				return current;
			if (current.superTypeAllowed && isBetter.superTypeAllowed)
				return current.copyIfDifferent(conformanceComputer.getCommonSuperType(Lists.newArrayList(current.reference, isBetter.reference)));
			if (current.superTypeAllowed && this.conformanceComputer.isConformant(isBetter.reference, current.reference))
				return isBetter;
		}
		return current;
	}
	
	//TODO improve
	protected boolean isResolved(JvmTypeReference type) {
		if (type.getType() instanceof JvmTypeParameter || type.getType() instanceof JvmVoid) {
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

	protected void internalComputeContext(JvmTypeReference contextRef, Multimap<JvmTypeParameter, ResolveInfo> context, Set<JvmType> computing) {
		if (contextRef instanceof JvmMultiTypeReference) {
			JvmMultiTypeReference multiType = (JvmMultiTypeReference) contextRef;
			for(JvmTypeReference typeReference: multiType.getReferences()) {
				internalComputeContext(typeReference, context, computing);
			}
			return;
		}
		if (contextRef instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference typeRef = (JvmParameterizedTypeReference) contextRef;
			if (typeRef.getType() instanceof JvmTypeParameterDeclarator) {
				List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) typeRef.getType()).getTypeParameters();
				List<JvmTypeReference> typeArguments = typeRef.getArguments();
				if (!typeArguments.isEmpty()) {
					// parameterized type reference
					for (int i = 0; i < typeArguments.size() && i < typeParameters.size(); i++) {
						JvmTypeReference argument = typeArguments.get(i);
						if (argument != null) {
							JvmTypeParameter param = typeParameters.get(i);
							if (context.containsKey(argument.getType())) {
								context.putAll(param, context.get((JvmTypeParameter) argument.getType()));
							} else {
								ResolveInfo info = new ResolveInfo(argument);
								info.exactMatch = !(argument instanceof JvmWildcardTypeReference);
								if (!info.exactMatch) {
									info.preferSubtypes = true;
								}
								context.put(param, info);
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
			for (JvmTypeReference superType : superTypes) {
				if (computing.add(superType.getType()))
					internalComputeContext(superType, context, computing);
			}
		} else if (type instanceof JvmTypeParameter) {
			for(JvmTypeConstraint constraint: ((JvmTypeParameter) type).getConstraints()) {
				if (constraint instanceof JvmUpperBound) {
					JvmTypeReference upperBound = constraint.getTypeReference();
					if (computing.add(upperBound.getType())) {
						internalComputeContext(upperBound, context, computing);
					}
				}
			}
		}
	}
	
	protected void resolve(JvmTypeReference declaration, ResolveInfo information, Multimap<JvmTypeParameter, ResolveInfo> existing, boolean returnTypeContext) {
		JvmTypeParameter typeParameter = getReferenceTypeParameter(declaration);
		if (information != null)
			information = information.copyIfDifferent(primitives.asWrapperTypeIfPrimitive(information.reference));
		else
			information = new ResolveInfo(null);
		if (typeParameter != null && information.reference != null) {
			if (isValidParameter(typeParameter, information.reference, returnTypeContext)) {
				if (!containsEntry(existing, typeParameter, information)) {
					existing.put(typeParameter, information);
					Collection<ResolveInfo> resolveData = existing.get(typeParameter);
					List<JvmTypeParameter> transitiveParameters = Lists.newArrayListWithExpectedSize(2);
					for(ResolveInfo resolveDataItem: resolveData) {
						if (resolveDataItem.reference.getType() instanceof JvmTypeParameter) {
							if (resolveDataItem.reference != information.reference)
								transitiveParameters.add((JvmTypeParameter) resolveDataItem.reference.getType());
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
		if (declaration instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference parameterizedDeclaration = (JvmParameterizedTypeReference) declaration;
			EList<JvmTypeReference> declArgs = parameterizedDeclaration.getArguments();
			if (information.reference instanceof JvmParameterizedTypeReference) {
				/*
				 * We need to walk the inheritance hierarchy up to resolve all type parameters,
				 * e.g. the declared type may be Comparable<? super C> and the information
				 * may be java.lang.String. String itself does not define type arguments
				 * but it implements java.lang.Comparable<String> thus the type argument
				 * C can be resolved to java.lang.String
				 */
				Iterable<JvmTypeReference> allTypes = Iterables.concat(
						Collections.singleton(information.reference), 
						superTypeCollector.collectSuperTypes(information.reference));
				Set<JvmType> rawSuperTypes = superTypeCollector.collectSuperTypesAsRawTypes(information.reference);
				rawSuperTypes.add(information.reference.getType());
				for(JvmTypeReference localInformation: allTypes) {
					JvmParameterizedTypeReference parameterizedInformation = (JvmParameterizedTypeReference) localInformation;
					EList<JvmTypeReference> infoArgs = parameterizedInformation.getArguments();
					for (int i = 0; i < declArgs.size() && i < infoArgs.size(); i++) {
						JvmTypeReference infoArg = infoArgs.get(i);
						JvmTypeReference declArg = declArgs.get(i);
						boolean recurse = true;
						if (infoArg.getType() instanceof JvmTypeParameter && declArg.getType() instanceof JvmTypeParameter) {
							JvmTypeParameter infoParam = (JvmTypeParameter) infoArg.getType();
							if (rawSuperTypes.contains(infoParam.getDeclarator()))
								recurse = false;
						}
						if (recurse) {
							ResolveInfo info = new ResolveInfo(infoArgs.get(i));
							info.superTypeAllowed = infoArg instanceof JvmWildcardTypeReference;
							info.preferSubtypes = information.preferSubtypes || 
									(declArg instanceof JvmWildcardTypeReference 
											&& getSingleUpperBoundOrNull((JvmWildcardTypeReference) declArg) == null);
							resolve(declArg, info, existing, returnTypeContext);
						}
					}
				}
			} else if (information.reference instanceof JvmWildcardTypeReference) {
				JvmWildcardTypeReference wildcardInformation = (JvmWildcardTypeReference) information.reference;
				JvmTypeReference informationUpperBound = getSingleUpperBoundOrNull(wildcardInformation);
				ResolveInfo info = new ResolveInfo(informationUpperBound);
				info.exactMatch = !information.preferSubtypes;
				info.preferSubtypes = information.preferSubtypes;
				resolve(parameterizedDeclaration, info, existing, returnTypeContext);
			} else if (information.reference instanceof JvmGenericArrayTypeReference) {
				// TODO only for declaration == Iterable?
				// or should we use synonym types for the information instead?
				if (declArgs.size() >= 1) {
					JvmGenericArrayTypeReference arrayInformation = (JvmGenericArrayTypeReference)information.reference;
					ResolveInfo info = new ResolveInfo(arrayInformation.getComponentType());
					info.preferSubtypes = true;
					resolve(declArgs.get(0), info, existing, returnTypeContext);
				}
			}
		} else if (declaration instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wildcardDeclaration = (JvmWildcardTypeReference) declaration;
			JvmTypeReference wildcardUpperBound = getSingleUpperBoundOrNull(wildcardDeclaration);
			if (information.reference instanceof JvmParameterizedTypeReference) {
				resolve(wildcardUpperBound, information, existing, returnTypeContext);
			} else if (information.reference instanceof JvmWildcardTypeReference) {
				JvmWildcardTypeReference wildcardInformation = (JvmWildcardTypeReference) information.reference;
				JvmTypeReference informationUpperBound = getSingleUpperBoundOrNull(wildcardInformation);
				ResolveInfo info = new ResolveInfo(informationUpperBound);
				info.preferSubtypes = true;
				resolve(wildcardUpperBound, info, existing, returnTypeContext);
			}
		} else if (declaration instanceof JvmGenericArrayTypeReference) {
			JvmTypeReference componentType = ((JvmGenericArrayTypeReference) declaration).getComponentType();
			if (information.reference instanceof JvmGenericArrayTypeReference) {
				ResolveInfo componentInfo = information.copyIfDifferent(((JvmGenericArrayTypeReference) information.reference).getComponentType());
				resolve(componentType, componentInfo, existing, returnTypeContext);
			}
		}
	}
	
	private JvmTypeReference getSingleUpperBoundOrNull(JvmConstraintOwner constraintOwner) {
		JvmUpperBound result = null;
		for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
			if (constraint instanceof JvmUpperBound) {
				if (result == null)
					result = (JvmUpperBound) constraint;
				else
					return null;
			}
		}
		if (result != null)
			return result.getTypeReference();
		return null;
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

	protected boolean containsEntry(Multimap<JvmTypeParameter, ResolveInfo> existing,
			JvmTypeParameter typeParameter, ResolveInfo information) {
		if (information.reference instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wildcard = (JvmWildcardTypeReference) information.reference;
			boolean otherConstraintSeen = false;
			boolean constraintIsTypeParam = false;
			for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
				if (constraint instanceof JvmUpperBound && typeParameter == constraint.getTypeReference().getType()) {
					constraintIsTypeParam = true;
				} else {
					otherConstraintSeen = true;
				}
			}
			if (constraintIsTypeParam && !otherConstraintSeen)
				return true;
		}
		if (existing.containsKey(typeParameter)) {
			Collection<ResolveInfo> collection = existing.get(typeParameter);
			for (ResolveInfo info : collection) {
				if (EcoreUtil.equals(info.reference, information.reference)) {
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
	
	protected void resolve(JvmTypeParameter key, ResolveInfo info, Multimap<JvmTypeParameter, ResolveInfo> existing, boolean ignoreOperationArguments) {
		for (JvmTypeConstraint constrain : key.getConstraints()) {
			JvmTypeReference reference = constrain.getTypeReference();
			resolve(reference, info, existing, ignoreOperationArguments);
		}
	}

}