/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;

import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
@Singleton
public class TypeArgumentContextProvider {

	@Inject
	private Provider<LazyTypeArgumentContext> lazyTypeArgumentContextProvider;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private TypesFactory typesFactory;
	
	@Inject
	private IRawTypeHelper rawTypeHelper;
	
	@Inject
	private TypeConformanceComputer conformanceComputer;
	
	@Inject
	private Primitives primitives;
	
	protected class PrimitiveAwareMap extends ForwardingMap<JvmTypeParameter, JvmTypeReference> {
		private final Map<JvmTypeParameter, JvmTypeReference> delegate = Maps.newLinkedHashMap();
		private final Joiner.MapJoiner toStringHelper = Joiner.on("\n\t").withKeyValueSeparator("=");

		@Override
		protected Map<JvmTypeParameter, JvmTypeReference> delegate() {
			return delegate;
		}
		
		@Override
		public JvmTypeReference put(JvmTypeParameter key, JvmTypeReference value) {
			return super.put(key, primitives.asWrapperTypeIfPrimitive(value));
		}

		@Override
		public String toString() {
			if (isEmpty())
				return super.toString();
			return "(" + size() + " elements: {\n\t" + toStringHelper.join(delegate) + "\n}";
		}
	}

	public interface Request {
		
		/**
		 * @return the receiver type or null.
		 */
		JvmTypeReference getReceiverType();
		
		/**
		 * @return the feature or null.
		 */
		JvmFeature getFeature();
		
		/**
		 * @return the nearest type parameter declarator
		 */
		JvmTypeParameterDeclarator getNearestDeclarator();
		
		/**
		 * @return the arguments for the executable or null iff no executable context. May be empty.
		 */
		List<JvmTypeReference> getArgumentTypes();
		
		/**
		 * @return the explicit type arguments or null iff no declarator is available.
		 */
		List<JvmTypeReference> getExplicitTypeArgument();
		
		/**
		 * @return the expected type or null.
		 */
		JvmTypeReference getExpectedType();

		/**
		 * @return the expected type or null.
		 */
		JvmTypeReference getDeclaredType();
		
		/**
		 * Implementors are encouraged to override {@link #toString()} and provide a meaningful
		 * description for the request.
		 */
		@Override
		String toString();
		
	}
	
	public interface IInitializableTypeArgumentContext extends ITypeArgumentContext{

		void initialize(TypeArgumentContextProvider.Request request, TypeArgumentContextProvider contextProvider);
		
	}
	
	public static abstract class AbstractRequest implements Request {

		public JvmTypeReference getReceiverType() {
			return null;
		}

		public JvmFeature getFeature() {
			return null;
		}

		public JvmTypeParameterDeclarator getNearestDeclarator() {
			return null;
		}
		
		public List<JvmTypeReference> getArgumentTypes() {
			return null;
		}

		public List<JvmTypeReference> getExplicitTypeArgument() {
			return null;
		}

		public JvmTypeReference getExpectedType() {
			return null;
		}
		
		public JvmTypeReference getDeclaredType() {
			return null;
		}
		
	}
	
	public static class ReceiverRequest extends AbstractRequest {
		
		private final JvmTypeReference receiver;

		public ReceiverRequest(JvmTypeReference receiver) {
			this.receiver = receiver;
		}
		@Override
		public JvmTypeReference getReceiverType() {
			return receiver;
		}
		@Override
		public String toString() {
			return "ReceiverRequest [receiver=" + receiver + "]";
		}
		
	}
	
	public ITypeArgumentContext getTypeArgumentContext(Request request) {
		IInitializableTypeArgumentContext result = lazyTypeArgumentContextProvider.get();
		result.initialize(request, this);
		return result;
	}
	
	protected TypeArgumentContext getReceiverContext(JvmTypeReference receiverType) {
		final Map<JvmTypeParameter, JvmTypeReference> result = createTemporaryMap();
		final Set<JvmType> visited = Sets.newHashSet();
		boolean rawType = new AbstractTypeReferenceVisitor.InheritanceAware<Boolean>() {
			@Override
			protected Boolean handleNullReference() {
				return Boolean.TRUE;
			}
			@Override
			public Boolean doVisitTypeReference(JvmTypeReference reference) {
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
				for(JvmTypeReference component: reference.getReferences()) {
					if (visit(component))
						return Boolean.TRUE;
				}
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
				JvmType type = reference.getType();
				if (visited.add(type)) {
					if (type instanceof JvmTypeParameterDeclarator) {
						List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
						List<JvmTypeReference> typeArguments = reference.getArguments();
						if (!typeArguments.isEmpty()) {
							for (int i = 0; i < typeArguments.size() && i < typeParameters.size(); i++) {
								JvmTypeReference argument = typeArguments.get(i);
								if (argument != null) {
									JvmTypeParameter param = typeParameters.get(i);
									boolean self = false;
									if (argument instanceof JvmParameterizedTypeReference) {
										self = param == argument.getType();
									}
									if (!self) {
										if (result.put(param, argument) != null)
											throw new IllegalStateException();
									}
								}
							}
						} else {
							if (!typeParameters.isEmpty()) { // rawType
								return Boolean.TRUE;
							}
						}
					}
					if (type instanceof JvmTypeParameter) {
						List<JvmTypeConstraint> constraints = ((JvmTypeParameter) type).getConstraints();
						boolean upperBoundSeen = false;
						for(JvmTypeConstraint constraint: constraints) {
							if (constraint instanceof JvmUpperBound) {
								upperBoundSeen = true;
								if (visit(constraint.getTypeReference())) {
									return Boolean.TRUE;
								}
							}
						}
						if (!upperBoundSeen) {
							if (visit(typeReferences.getTypeForName(Object.class, type))) {
								return Boolean.TRUE;
							}
						}
					} else if (type instanceof JvmDeclaredType) {
						List<JvmTypeReference> superTypes = ((JvmDeclaredType) type).getSuperTypes();
						for(JvmTypeReference superType: superTypes) {
							if (visit(superType)) {
								return Boolean.TRUE;
							}
						}
					}
				}
				return Boolean.FALSE;
			}
		}.visit(primitives.asWrapperTypeIfPrimitive(receiverType));
		if (rawType)
			return new TypeArgumentContext(null, typeReferences, typesFactory, rawTypeHelper, primitives);
		Map<JvmTypeParameter, JvmTypeReference> normalized = normalizedCopy(result);
		if (normalized.isEmpty())
			return null;
		return new TypeArgumentContext(normalized, typeReferences, typesFactory, rawTypeHelper, primitives);
	}
	
	protected Map<JvmTypeParameter, JvmTypeReference> normalizedCopy(Multimap<JvmTypeParameter, ResolveInfo> map) {
		if (map.isEmpty())
			return Collections.emptyMap();
		if (map.size() == 1) {
			Map.Entry<JvmTypeParameter, ResolveInfo> singleElement = Iterables.getOnlyElement(map.entries());
			ResolveInfo singleResolveInfo = singleElement.getValue();
			JvmTypeReference reference = wildcardAwareGetReference(singleResolveInfo);
			return Collections.singletonMap(singleElement.getKey(), reference);
		}
		Map<JvmTypeParameter, JvmTypeReference> result = createMapWithTweakedToString();
		for(JvmTypeParameter boundParameter: map.keySet()) {
			Collection<ResolveInfo> boundTo = map.get(boundParameter);
			if (boundTo.size() == 1) {
				ResolveInfo singleResolveInfo = Iterables.getOnlyElement(boundTo);
				JvmTypeReference reference = wildcardAwareGetReference(singleResolveInfo);
				result.put(boundParameter, reference);
			} else {
				List<ResolveInfo> boundToList = Lists.newArrayList(boundTo);
				List<JvmTypeReference> uppers = Lists.newArrayListWithCapacity(boundToList.size());
				List<ResolveInfo> lowers = Lists.newArrayListWithCapacity(boundToList.size());
				boolean done = false;
				int lowerIndex = Integer.MAX_VALUE;
				int upperIndex = Integer.MAX_VALUE;
				for(int i = 0; i < boundToList.size(); i++) {
					ResolveInfo info = boundToList.get(i);
					if (info.kind == ResolveInfoKind.EXACT) {
						result.put(boundParameter, info.reference);
						done = true;
						break;
					} else if (info.kind == ResolveInfoKind.UPPER || info.kind == ResolveInfoKind.WC_UPPER) {
						if (upperIndex == Integer.MAX_VALUE)
							upperIndex = i;
						if (!lowers.isEmpty() && upperIndex < lowerIndex) {
							boolean conformant = true;
							for(ResolveInfo lower: lowers) {
								if (!getConformanceComputer().isConformant(info.reference, lower.reference)) {
									conformant = false;
									break;
								}
							}
							if (conformant) {
								uppers.add(info.reference);
							}
						} else {
							uppers.add(info.reference);
						}
					} else if (info.kind == ResolveInfoKind.LOWER || info.kind == ResolveInfoKind.WC_LOWER) {
						if (lowerIndex == Integer.MAX_VALUE)
							lowerIndex = i;
						lowers.add(info);
					}
				}
				if (!done) {
					JvmTypeReference reference = null;
					if (!uppers.isEmpty() && upperIndex < lowerIndex) {
						reference = conformanceComputer.getCommonSuperType(uppers);
						if (uppers.size() == 1 && boundToList.get(upperIndex).kind == ResolveInfoKind.WC_UPPER) {
							boolean useWildcard = true;
							for(ResolveInfo lowerResolve: lowers) {
								if (!conformanceComputer.isConformant(lowerResolve.reference, reference)) {
									useWildcard = false;
									break;
								}
							}
							if (useWildcard) {
								if (reference.eContainer() != null) {
									JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
									delegate.setDelegate(reference);
									reference = delegate;
								}
								JvmWildcardTypeReference wildCard = typeReferences.wildCard();
								JvmUpperBound upperBound = typesFactory.createJvmUpperBound();
								wildCard.getConstraints().add(upperBound);
								upperBound.setTypeReference(reference);
								reference = wildCard;
							}
						}
					} else if (!lowers.isEmpty()) {
						boolean lowerWithWildcard = false; 
						ResolveInfo bestResolvedLower = null;
						for(ResolveInfo resolvedLower: lowers) {
							lowerWithWildcard |= resolvedLower.kind == ResolveInfoKind.WC_LOWER;
							if (bestResolvedLower == null) {
								bestResolvedLower = resolvedLower;
							} else {
								TypeConformanceResult conformanceResult = conformanceComputer.isConformant(bestResolvedLower.reference, resolvedLower.reference, new TypeConformanceComputationArgument(false, false, true));
								if (conformanceResult.isConformant() && conformanceResult.getKinds().contains(TypeConformanceResult.Kind.SUBTYPE))
									bestResolvedLower = resolvedLower;
							}
						}
						if (bestResolvedLower != null) {
							if (lowers.size() == 1 || lowerWithWildcard) {
								if (bestResolvedLower.kind != ResolveInfoKind.WC_LOWER) {
									if (!uppers.isEmpty()) {
										JvmTypeReference upper = conformanceComputer.getCommonSuperType(uppers);
										if (conformanceComputer.isConformant(bestResolvedLower.reference, upper))
											reference = upper;
										else
											reference = wildcardAwareGetReference(bestResolvedLower);
									} else {
										reference = wildcardAwareGetReference(bestResolvedLower);
									}
								} else {
									reference = wildcardAwareGetReference(bestResolvedLower);
								}
							} else {
								reference = bestResolvedLower.reference;
								if (!uppers.isEmpty()) {
									JvmTypeReference upper = conformanceComputer.getCommonSuperType(uppers);
									if (conformanceComputer.isConformant(reference, upper))
										reference = upper;
								}
							}
						}
					}
					if (reference != null)
						result.put(boundParameter, reference);
				}
			}
		}
		Map<JvmTypeParameter, JvmTypeReference> normalizedCopy = normalizedCopy(result);
		return normalizedCopy;
	}

	protected Map<JvmTypeParameter, JvmTypeReference> createMapWithTweakedToString() {
		return new PrimitiveAwareMap();
	}

	protected JvmTypeReference wildcardAwareGetReference(ResolveInfo resolveInfo) {
		JvmTypeReference reference = resolveInfo.reference;
		ResolveInfoKind kind = resolveInfo.kind;
		if (kind == ResolveInfoKind.WC_UPPER) {
			if (reference.eContainer() instanceof JvmUpperBound && reference.eContainer().eContainer() instanceof JvmWildcardTypeReference) {
				reference = (JvmTypeReference) reference.eContainer().eContainer();
			} else {
				if (reference.eContainer() != null) {
					JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
					delegate.setDelegate(reference);
					reference = delegate;
				}
				JvmWildcardTypeReference wildCard = typeReferences.wildCard();
				JvmUpperBound upperBound = typesFactory.createJvmUpperBound();
				wildCard.getConstraints().add(upperBound);
				upperBound.setTypeReference(reference);
				reference = wildCard;
			}
		} else if (kind == ResolveInfoKind.WC_LOWER) {
			if (reference.eContainer() instanceof JvmLowerBound && reference.eContainer().eContainer() instanceof JvmWildcardTypeReference) {
				reference = (JvmTypeReference) reference.eContainer().eContainer();
			} else {
				if (reference.eContainer() != null) {
					JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
					delegate.setDelegate(reference);
					reference = delegate;
				}
				JvmWildcardTypeReference wildCard = typeReferences.wildCard();
				JvmLowerBound lowerBound = typesFactory.createJvmLowerBound();
				wildCard.getConstraints().add(lowerBound);
				lowerBound.setTypeReference(reference);
				reference = wildCard;
			}
		}
		return reference;
	}

	protected Map<JvmTypeParameter, JvmTypeReference> normalizedCopy(final Map<JvmTypeParameter, JvmTypeReference> map) {
		if (map.isEmpty())
			return Collections.emptyMap();
		if (map.size() == 1) {
			Map.Entry<JvmTypeParameter, JvmTypeReference> singleElement = Iterables.getOnlyElement(map.entrySet());
			return Collections.singletonMap(singleElement.getKey(), singleElement.getValue());
		}
		Map<JvmTypeParameter, JvmTypeReference> result = createMapWithTweakedToString();
		for(Map.Entry<JvmTypeParameter, JvmTypeReference> entry: map.entrySet()) {
			final JvmTypeParameter parameter = entry.getKey();
			JvmTypeReference boundReference = entry.getValue();
			final Set<JvmTypeReference> seen = Sets.newHashSet();
			JvmTypeReference normalized = new AbstractTypeReferenceVisitor.InheritanceAware<JvmTypeReference>() {
				@Override
				public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
					JvmType type = reference.getType();
					if (type instanceof JvmTypeParameter) {
						if (type != parameter) {
							JvmTypeReference transitive = map.get(type);
							if (transitive != null) {
								if (seen.add(transitive)) {
									try {
										return visit(transitive);
									} finally {
										seen.remove(transitive);
									}
								} else {
									// TODO find the reason for this recursion
//									System.out.println("Recursion");
								}
							}
						}
					}
					return reference;
				}
				@Override
				public JvmTypeReference doVisitTypeReference(JvmTypeReference reference) {
					return reference;
				}
			}.visit(boundReference);
			if (normalized != null)
				result.put(parameter, normalized);
		}
		return result;
	}

	protected ITypeArgumentContext getExplicitArgumentContext(
			JvmExecutable executable,
			List<JvmTypeReference> explicitTypeArguments) {
		Map<JvmTypeParameter, JvmTypeReference> result = createTemporaryMap();
		List<JvmTypeParameter> typeParameters = executable.getTypeParameters();
		if (typeParameters.isEmpty() && executable instanceof JvmConstructor) {
			JvmDeclaredType declaringType = executable.getDeclaringType();
			if (declaringType instanceof JvmTypeParameterDeclarator) {
				typeParameters = ((JvmTypeParameterDeclarator) declaringType).getTypeParameters();
			}
		}
		for(int i = 0; i < typeParameters.size() && i < explicitTypeArguments.size(); i++) {
			JvmTypeParameter typeParameter = typeParameters.get(i);
			JvmTypeReference typeArgument = explicitTypeArguments.get(i);
			if (typeParameter != null && typeArgument != null)
				result.put(typeParameters.get(i), explicitTypeArguments.get(i));
		}
		if (result.isEmpty())
			return null;
		return new TypeArgumentContext(result, typeReferences, typesFactory, rawTypeHelper, primitives);
	}

	protected enum ResolveInfoKind {
		EXACT, UPPER, WC_UPPER, LOWER, WC_LOWER
	}
	
	protected static class ResolveInfo {
		protected final ResolveInfoKind kind;
		protected final JvmTypeReference reference;
		protected final int hint;
		
		protected ResolveInfo(JvmTypeReference reference, ResolveInfoKind kind, int hint) {
			this.reference = reference;
			this.kind = kind;
			this.hint = hint;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + hint;
			result = prime * result + ((kind == null) ? 0 : kind.hashCode());
			result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
			if (hint != other.hint)
				return false;
			if (kind != other.kind)
				return false;
			if (reference == null) {
				if (other.reference != null)
					return false;
			} else if (!reference.equals(other.reference))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "ResolveInfo [kind=" + kind + ", reference=" + reference + ", hint=" + hint + "]";
		}
	}
	
	protected ITypeArgumentContext getExpectedTypeContext(JvmTypeReference declaredType, JvmTypeReference expectedType) {
		final Multimap<JvmTypeParameter, ResolveInfo> result = createTemporaryMultimap();
		resolveAgainstActualType(declaredType, expectedType, result, false, -1);
		Map<JvmTypeParameter, JvmTypeReference> normalized = normalizedCopy(result);
		if (normalized.isEmpty())
			return null;
		return new TypeArgumentContext(normalized, typeReferences, typesFactory, rawTypeHelper, primitives);
	}

	protected Multimap<JvmTypeParameter, ResolveInfo> createTemporaryMultimap() {
		return new ForwardingMultimap<JvmTypeParameter, ResolveInfo>() {
			final Multimap<JvmTypeParameter, ResolveInfo> delegate = LinkedHashMultimap.create(2, 1);
			@Override
			protected Multimap<JvmTypeParameter, ResolveInfo> delegate() {
				return delegate;
			}
			@Override
			public boolean put(JvmTypeParameter key, ResolveInfo value) {
				if (value != null) {
					if (isRecursive(key, value.reference)) {
						return false;
					}
					// 	TODO improve
					if (value.reference instanceof JvmParameterizedTypeReference) {
						value = new ResolveInfo(primitives.asWrapperTypeIfPrimitive(value.reference), value.kind, value.hint);
					}
				}
				return super.put(key, value);
			}
			// TODO provide a better toString, too
		};
	}
	
	protected boolean isRecursive(final JvmTypeParameter param, JvmTypeReference reference) {
		boolean result = new AbstractTypeReferenceVisitor.InheritanceAware<Boolean>() {
			@Override
			protected Boolean handleNullReference() {
				return true;
			}
			@Override
			public Boolean doVisitTypeReference(JvmTypeReference reference) {
				return false;
			}
			@Override
			public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
				for(JvmTypeConstraint constraint: reference.getConstraints()) {
					if (visit(constraint.getTypeReference()))
						return true;
				}
				return false;
			}
			@Override
			public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
				return param == reference.getType();
			}
		}.visit(reference);
		return result;
	}
	
	protected Map<JvmTypeParameter, JvmTypeReference> createTemporaryMap() {
		return new PrimitiveAwareMap() {
			@Override
			public JvmTypeReference put(JvmTypeParameter key, JvmTypeReference value) {
				if (isRecursive(key, value)) {
					// this return value is actually incorrect but there is no other channel
					// to refuse a certain key-value-pair
					return null;
				}
				return super.put(key, getWithObjectUpperBoundIfNecessary(value));
			}
		};
	}
	
	protected JvmTypeReference getWithObjectUpperBoundIfNecessary(JvmTypeReference reference) {
		return reference;
	}
	
	protected ITypeArgumentContext getDeclaredBoundsContext(JvmExecutable executable) {
		JvmTypeParameterDeclarator declarator = executable;
		Map<JvmTypeParameter, JvmTypeReference> result = createTemporaryMap();
		while(declarator != null) {
			List<JvmTypeParameter> typeParameters = declarator.getTypeParameters();
			for(JvmTypeParameter typeParameter: typeParameters) {
				List<JvmTypeReference> allUppers = Lists.newArrayList();
				for(JvmTypeConstraint constraint: typeParameter.getConstraints()) {
					if (constraint instanceof JvmUpperBound) {
						allUppers.add(constraint.getTypeReference());
					}
				}
				if (allUppers.isEmpty()) {
					result.put(typeParameter, typeReferences.getTypeForName(Object.class, declarator));
				} else if (allUppers.size() == 1) {
					result.put(typeParameter, allUppers.get(0));
				} else {
					JvmMultiTypeReference bound = typesFactory.createJvmMultiTypeReference();
					for(JvmTypeReference upper: allUppers) {
						if (upper.eContainer() == null) {
							bound.getReferences().add(upper);
						} else {
							JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
							delegate.setDelegate(upper);
							bound.getReferences().add(delegate);
						}
					}
					result.put(typeParameter, bound);
				}
			}
			if (declarator.eContainer() != null)
				declarator = EcoreUtil2.getContainerOfType(declarator.eContainer(), JvmTypeParameterDeclarator.class);
			else
				break;
		}
		if (result.isEmpty())
			return null;
		return new TypeArgumentContext(result, typeReferences, typesFactory, rawTypeHelper, primitives);
	}

	protected ITypeArgumentContext getParameterContext(
			JvmExecutable executable,
			List<JvmTypeReference> argumentTypes) {
		final Multimap<JvmTypeParameter, ResolveInfo> result = createTemporaryMultimap();
		List<JvmFormalParameter> parameters = executable.getParameters();
		int paramCount = parameters.size();
		if (executable.isVarArgs()) {
			paramCount--;
		}
		for (int i = 0; i < paramCount && i < argumentTypes.size(); i++) {
			JvmTypeReference parameterType = parameters.get(i).getParameterType();
			JvmTypeReference argumentType = argumentTypes.get(i);
			if (argumentType != null && parameterType != null && !typeReferences.is(argumentType, Void.TYPE)) {
				resolveAgainstActualType(parameterType, argumentType, result, true, i);
			}
		}
		for (int i = argumentTypes.size(); i < paramCount; i++) {
			JvmTypeReference parameterType = parameters.get(i).getParameterType();
			if (parameterType != null) {
				resolveAgainstActualType(parameterType, null, result, true, i);
			}
		}
		if (executable.isVarArgs() && argumentTypes.size() > paramCount) {
			JvmTypeReference varArgParameterType = parameters.get(paramCount).getParameterType();
			if (!(varArgParameterType instanceof JvmGenericArrayTypeReference)) {
				throw new IllegalStateException("VarArg methods expect last paramter to be an array type");
			}
			JvmTypeReference varArgComponentType = ((JvmGenericArrayTypeReference) varArgParameterType).getComponentType();
			// TODO use visitor to determine exact array dimension etc - extract ArrayReferences utility
			// probably an array
			if (argumentTypes.size() == paramCount + 1) {
				JvmTypeReference lastArgumentType = argumentTypes.get(paramCount);
				if (lastArgumentType != null) {
					if (lastArgumentType instanceof JvmGenericArrayTypeReference) {
						if (((JvmGenericArrayTypeReference) lastArgumentType).getDimensions() == ((JvmGenericArrayTypeReference) varArgParameterType).getDimensions()) {
							resolveAgainstActualType(varArgParameterType, lastArgumentType, result, true, paramCount);		
							Map<JvmTypeParameter, JvmTypeReference> normalized = normalizedCopy(result);
							return new TypeArgumentContext(normalized, typeReferences, typesFactory, rawTypeHelper, primitives);
						}
					} 
					resolveAgainstActualType(varArgComponentType, lastArgumentType, result, true, paramCount);
				}
			} else {
				List<JvmTypeReference> actualVarArgTypes = Lists.newArrayList(Iterables.filter(
					argumentTypes.subList(paramCount, argumentTypes.size()), Predicates.notNull()));
				if (!actualVarArgTypes.isEmpty()) {
					if (!primitives.isPrimitive(varArgComponentType)) {
						List<JvmTypeReference> wrappedVarArgTypes = Lists.newArrayListWithCapacity(actualVarArgTypes.size());
						for(JvmTypeReference varArgType: actualVarArgTypes) {
							wrappedVarArgTypes.add(primitives.asWrapperTypeIfPrimitive(varArgType));
						}
						actualVarArgTypes = wrappedVarArgTypes;
					}
					JvmTypeReference commonVarArgType = getConformanceComputer().getCommonSuperType(actualVarArgTypes);
					resolveAgainstActualType(varArgComponentType, commonVarArgType, result, true, paramCount);
				}
			}
		}
		Map<JvmTypeParameter, JvmTypeReference> normalized = normalizedCopy(result);
		if (normalized.isEmpty())
			return null;
		return new TypeArgumentContext(normalized, typeReferences, typesFactory, rawTypeHelper, primitives);
	}
	
	protected TypeConformanceComputer getConformanceComputer() {
		return conformanceComputer;
	}

	protected void resolveAgainstActualType(JvmTypeReference declaredType, JvmTypeReference actualType,
			final Multimap<JvmTypeParameter, ResolveInfo> result, final boolean allowWildcardResolutions, final int hint) {
		ITypeReferenceVisitorWithParameter<ResolveInfo, Void> implementation = new AbstractTypeReferenceVisitorWithParameter.InheritanceAware<ResolveInfo, Void>() {
			@Override
			public Void doVisitCompoundTypeReference(JvmCompoundTypeReference reference, ResolveInfo param) {
				for(JvmTypeReference component: reference.getReferences())
					visit(component, param);
				return null;
			}
			@Override
			protected Void handleNullReference(ResolveInfo parameter) {
				return null;
			}
			@Override
			public Void doVisitTypeReference(JvmTypeReference reference, ResolveInfo param) {
				return null;
			}
			@Override
			public Void doVisitParameterizedTypeReference(final JvmParameterizedTypeReference declaredReference, final ResolveInfo param) {
				return new AbstractTypeReferenceVisitor.InheritanceAware<Void>() {
					@Override
					public Void doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
						for(JvmTypeReference component: reference.getReferences())
							visit(component);
								return null;
					}
					@Override
					protected Void handleNullReference() {
						final JvmType type = declaredReference.getType();
						if (type instanceof JvmTypeParameter) {
							for(JvmTypeConstraint constraint: ((JvmTypeParameter) type).getConstraints()) {
								if (constraint instanceof JvmUpperBound && constraint.getTypeReference() != null) {
									result.put((JvmTypeParameter) type, new ResolveInfo(constraint.getTypeReference(), param.kind, param.hint));
								}
							}
						}
						return null;
					}
					@Override
					public Void doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
						final JvmType type = declaredReference.getType();
						if (type instanceof JvmTypeParameter) {
							result.put((JvmTypeParameter) type, param);
						} else if (type instanceof JvmTypeParameterDeclarator && !((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty()) {
							TypeArgumentContext actualContext = getReceiverContext(reference);
							if (actualContext != null) {
								TypeArgumentContext declaredContext = getReceiverContext(declaredReference);
								if (declaredContext == null) {
									declaredContext = new TypeArgumentContext(Collections.<JvmTypeParameter, JvmTypeReference>emptyMap(), 
											typeReferences, typesFactory, rawTypeHelper, primitives);
								}
								Collection<JvmTypeParameter> receiverBoundParameters = actualContext.getBoundParameters();
								for(JvmTypeParameter receiverBound: receiverBoundParameters) {
									JvmTypeReference declared = declaredContext.getBoundArgument(receiverBound);
									JvmTypeReference actual = actualContext.getBoundArgument(receiverBound);
									outerVisit(declared, new ResolveInfo(actual, ResolveInfoKind.EXACT, param.hint));
								}
								for(JvmTypeParameter declaredBoundParameter: declaredContext.getBoundParameters()) {
									if (!result.containsKey(declaredBoundParameter)) {
										result.put(declaredBoundParameter, new ResolveInfo(declaredContext.internalGetBoundArgument(declaredBoundParameter), param.kind, param.hint));
									}
								}
							}
						}
						return null;
					}
					@Override
					public Void doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
						boolean lowerBoundFound = false;
						for (JvmTypeConstraint constraint : reference.getConstraints()) {
							if (constraint instanceof JvmLowerBound) {
								lowerBoundFound = true;
//								if (param.kind != ResolveInfoKind.EXACT) {
									outerVisit(declaredReference, new ResolveInfo(constraint.getTypeReference(),
											allowWildcardResolutions ? ResolveInfoKind.WC_LOWER	: ResolveInfoKind.LOWER, param.hint));
//								}
							}
						}
						if (!lowerBoundFound /* || param.kind == ResolveInfoKind.EXACT */) {
							for(JvmTypeConstraint constraint: reference.getConstraints()) {
								if (constraint instanceof JvmUpperBound) {
//									if (param.kind != ResolveInfoKind.EXACT) {
										outerVisit(declaredReference, new ResolveInfo(constraint.getTypeReference(), 
												allowWildcardResolutions ? ResolveInfoKind.WC_UPPER : ResolveInfoKind.UPPER, param.hint));
//									} else {
//										outerVisit(declaredReference, new ResolveInfo(constraint.getTypeReference(), 
//												lowerBoundFound ? ResolveInfoKind.EXACT : ResolveInfoKind.UPPER, param.hint));
//									}
								}
							}
						}
						return null;
					}
					@Override
					public Void doVisitTypeReference(JvmTypeReference reference) {
						return null;
					}
				}.visit(param.reference);
			}
			@Override
			public Void doVisitWildcardTypeReference(final JvmWildcardTypeReference declaredReference, final ResolveInfo param) {
				return new AbstractTypeReferenceVisitor.InheritanceAware<Void>() {
					@Override
					protected Void handleNullReference() {
						return null;
					}
					@Override
					public Void doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
						return doVisitTypeReference(reference);
					}
					@Override
					public Void doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
						for(JvmTypeConstraint declaredConstraint: declaredReference.getConstraints()) {
							if (declaredConstraint instanceof JvmUpperBound) {
								for(JvmTypeConstraint actualConstraint: reference.getConstraints()) {
									if (actualConstraint instanceof JvmUpperBound) {
										outerVisit(declaredConstraint.getTypeReference(), new ResolveInfo(actualConstraint.getTypeReference(), allowWildcardResolutions ? ResolveInfoKind.WC_UPPER : ResolveInfoKind.UPPER, param.hint));
									}
								}
							} else {
								for(JvmTypeConstraint actualConstraint: reference.getConstraints()) {
									if (actualConstraint instanceof JvmLowerBound) {
										outerVisit(declaredConstraint.getTypeReference(), new ResolveInfo(actualConstraint.getTypeReference(), ResolveInfoKind.LOWER, param.hint));
									}
								}
							}
						}
						return null;
					}
					@Override
					public Void doVisitTypeReference(JvmTypeReference reference) {
						boolean lowerBoundFound = false;
						for(JvmTypeConstraint declaredConstraint: declaredReference.getConstraints()) {
							if (declaredConstraint instanceof JvmLowerBound) {
								lowerBoundFound = true;
								outerVisit(declaredConstraint.getTypeReference(), 
										new ResolveInfo(reference, ResolveInfoKind.LOWER, param.hint));
							}
						}
						if (!lowerBoundFound) {
							for(JvmTypeConstraint declaredConstraint: declaredReference.getConstraints()) {
								if (declaredConstraint instanceof JvmUpperBound) {
									outerVisit(declaredConstraint.getTypeReference(), 
											new ResolveInfo(reference, ResolveInfoKind.UPPER, param.hint));
								}
							}
						}
						return null;
					}
				}.visit(param.reference);
			}
			@Override
			public Void doVisitGenericArrayTypeReference(final JvmGenericArrayTypeReference declaredReference, final ResolveInfo param) {
				return new AbstractTypeReferenceVisitor.InheritanceAware<Void>() {
					@Override
					public Void doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
						for(JvmTypeReference component: reference.getReferences())
							visit(component);
						return null;
					}
					@Override
					public Void doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
						return outerVisit(declaredReference.getComponentType(), new ResolveInfo(reference.getComponentType(), param.kind, param.hint));
					}
					@Override
					public Void doVisitTypeReference(JvmTypeReference reference) {
						return null;
					}
					@Override
					protected Void handleNullReference() {
						return null;
					}
				}.visit(param.reference);
			}
			
			public Void outerVisit(JvmTypeReference reference, ResolveInfo parameter) {
				return visit(reference, parameter);
			}
		};
		implementation.visit(declaredType, new ResolveInfo(actualType, ResolveInfoKind.UPPER, hint));
	}

}
