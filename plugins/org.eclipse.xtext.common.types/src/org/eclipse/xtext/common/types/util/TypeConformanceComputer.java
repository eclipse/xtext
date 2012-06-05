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
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Sets;
import com.google.common.primitives.Booleans;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Singleton
public class TypeConformanceComputer {

	protected AbstractConformanceVisitor<JvmTypeReference> leftDispatcher = createStrategySelector();
	
	@Inject
	protected SuperTypeCollector superTypeCollector;
	
	@Inject
	protected TypesFactory factory = TypesFactory.eINSTANCE;

	@Inject
	protected TypeArgumentContextProvider typeArgumentContextProvider;
	
	@Inject 
	protected Primitives primitives;
	
	@Inject
	protected TypeReferences typeReferences;
	
	public void setSuperTypeCollector(SuperTypeCollector superTypeCollector) {
		this.superTypeCollector = superTypeCollector;
	}

	protected TypeConformanceStrategySelector createStrategySelector() {
		return new TypeConformanceStrategySelector(this);
	}

	public void setPrimitives(Primitives primitives) {
		this.primitives = primitives;
	}
	
	public void setFactory(TypesFactory factory) {
		this.factory = factory;
	}
	
	public void setTypeArgumentContextProvider(TypeArgumentContextProvider typeArgumentContextProvider) {
		this.typeArgumentContextProvider = typeArgumentContextProvider;
	}
	
	public void setTypeReferences(TypeReferences typeReferences) {
		this.typeReferences = typeReferences;
	}

	public boolean isConformant(JvmTypeReference left, JvmTypeReference right) {
		return isConformant(left, right, false);
	}
	
	public boolean isConformant(JvmTypeReference left, JvmTypeReference right, boolean ignoreGenerics) {
		if (left == right && left != null)
			return true;
		TypeConformanceResult result = isConformant(left, right, new TypeConformanceComputationArgument(ignoreGenerics, false, true));
		return result.isConformant();
	}
	
	public TypeConformanceResult isConformant(JvmTypeReference left, JvmTypeReference right, TypeConformanceComputationArgument flags) {
		if (left == right && left != null)
			return TypeConformanceResult.SUCCESS;
		return leftDispatcher.visit(left, TypeConformanceComputationArgument.Internal.create(right, flags.rawType, flags.asTypeArgument, flags.allowPrimitiveConversion));
	}
	
	/**
	 * Populates a {@link Multiset} with the maximum number of necessary steps
	 * from a given type to its super types. Sorting the set by the steps creates 
	 * a stable order on from the direct super class, the most specialized implemented 
	 * interfaces up to object.
	 * E.g. although {@link StringBuilder} implements {@link java.io.Serializable} and 
	 * {@link CharSequence}, serializable is treated as more specific by this algorithm
	 * since the super class AbstractStringBuilder implements {@link CharSequence}, too.
	 * Thus the number of steps to {@link java.io.Serializable} is <code>1</code> while 
	 * {@link CharSequence} requires <code>2</code> hops. 
	 */
	protected static class MaxDistanceRawTypeAcceptor implements SuperTypeCollector.SuperTypeAcceptor {

		/**
		 * The set with with the distance information.
		 */
		private final Multiset<JvmType> distances;
		
		/**
		 * All seen raw types mapped to their resolved parameterized references.
		 */
		private final Multimap<JvmType, JvmTypeReference> rawTypeToReference;
		
		private final Function<JvmTypeReference, JvmTypeReference> resolver;

		protected MaxDistanceRawTypeAcceptor(
				Multiset<JvmType> result, 
				Multimap<JvmType, JvmTypeReference> all,
				Function<JvmTypeReference, JvmTypeReference> resolver) {
			this.distances = result;
			this.rawTypeToReference = all;
			this.resolver = resolver;
		}
		
		public boolean accept(JvmTypeReference superType, int distance) {
			if (superType == null)
				return false;
			JvmType type = superType.getType();
			rawTypeToReference.put(type, resolver.apply(superType));
			if (distances.contains(type)) {
				int currentCount = distances.count(type);
				if (currentCount < distance + 1) {
					distances.setCount(type, distance + 1);
				}
			} else {
				distances.add(type, distance + 1);
			}
			return true;
		}
		
	}
	
	protected static class ArgumentResolver implements Function<JvmTypeReference, JvmTypeReference> {

		private final ITypeArgumentContext context;

		protected ArgumentResolver(ITypeArgumentContext context) {
			this.context = context;
		}
		
		public JvmTypeReference apply(JvmTypeReference from) {
			JvmTypeReference result = context.resolve(from);
			return result;
		}
		
	}
	
	protected boolean isPrimitiveVoid(JvmTypeReference reference) {
		return reference.getType() instanceof JvmVoid;
	}
	
	/**
	 * Compute the common super type for the given types.
	 * 
	 * May return <code>null</code> in case one of the types is primitive void but not all 
	 * of them are.
	 */
	public JvmTypeReference getCommonSuperType(final List<JvmTypeReference> types) {
		if (types==null || types.isEmpty())
			throw new IllegalArgumentException("Types can't be null or empty "+types);
		if (types.size()==1)
			return types.get(0);
		
		// Check the straight forward case - one of the types is a supertype of all the others.
		// Further more check if any of the types is Void.TYPE -> all have to be Void.TYPE
		for(JvmTypeReference type: types) {
			if (conformsToAll(type, types))
				return type;
			if (isPrimitiveVoid(type)) {
				// we saw void but was not conformant to all other
				return null;
			}
		}
//		if (allTypesAreArrays(types)) {
//			List<JvmTypeReference> componentTypes = getComponentTypes(types);
//			JvmTypeReference resultComponent = doGetCommonSuperType(componentTypes, new TypeConformanceComputationArgument(false, false, false));
//			if (resultComponent != null) {
//				JvmGenericArrayTypeReference result = factory.createJvmGenericArrayTypeReference();
//				result.setComponentType(resultComponent);
//				return result;
//			}
//		}
		// TODO handle all primitives
		// TODO handle arrays
		if (containsPrimitiveOrAnyReferences(types)) {
			List<JvmTypeReference> withoutPrimitives = replacePrimitivesAndRemoveAnyReferences(types);
			if (withoutPrimitives.equals(types))
				return null;
			return getCommonSuperType(withoutPrimitives);
		}
		JvmTypeReference firstType = types.get(0);
		final List<JvmTypeReference> tail = types.subList(1, types.size());
		// mapping from rawtype to resolved parameterized types
		// used to determine the correct type arguments
		Multimap<JvmType, JvmTypeReference> all = LinkedHashMultimap.create();
		// cumulated rawtype to max distance (used for sorting)
		Multiset<JvmType> cumulatedDistance = LinkedHashMultiset.create();
		
		initializeDistance(firstType, all, cumulatedDistance);
		cumulateDistance(tail, all, cumulatedDistance);
		
		List<Entry<JvmType>> candidates = Lists.newArrayList(cumulatedDistance.entrySet());
		if (candidates.size() == 1) { // only one super type -> should be java.lang.Object
			JvmType firstRawType = candidates.get(0).getElement();
			return getFirstForRawType(all, firstRawType);
		}
		inplaceSortByDistanceAndName(candidates);
		// try to find a matching parameterized type for the raw types in ascending order
		List<JvmTypeReference> referencesWithSameDistance = Lists.newArrayListWithExpectedSize(2);
		int wasDistance = -1;
		boolean classSeen = false;
		outer: for(Entry<JvmType> rawTypeCandidate: candidates) {
			JvmType rawType = rawTypeCandidate.getElement();
			JvmTypeReference result = null;
			if (wasDistance == -1) {
				wasDistance = rawTypeCandidate.getCount();
			} else {
				if (wasDistance != rawTypeCandidate.getCount()) {
					if (classSeen)
						break;
					result = getTypeParametersForSupertype(all, rawType, types);
					for(JvmTypeReference alreadyCollected: referencesWithSameDistance) {
						if (isConformant(result, alreadyCollected, true)) {
							classSeen = classSeen || isClass(rawType);
							continue outer;
						}
					}
					wasDistance = rawTypeCandidate.getCount(); 
				}
			}
			if (result == null)
				result = getTypeParametersForSupertype(all, rawType, types);
			if (result != null) {
				boolean isClass = isClass(rawType);
				classSeen = classSeen || isClass;
				if (isClass)
					referencesWithSameDistance.add(0, result);
				else
					referencesWithSameDistance.add(result);
			}
		}
		if (referencesWithSameDistance.size() == 1) {
			return referencesWithSameDistance.get(0);
		} else if (referencesWithSameDistance.size() > 1) {
			JvmMultiTypeReference result = typeReferences.createMultiTypeReference(referencesWithSameDistance.get(0).getType());
			if (result == null)
				return result;
			for(JvmTypeReference reference: referencesWithSameDistance) {
				result.getReferences().add(EcoreUtil2.cloneIfContained(reference));
			}
			return result;
		}
		return null;
	}

	protected boolean isClass(JvmType type) {
		if (type instanceof JvmArrayType)
			return isClass(((JvmArrayType) type).getComponentType());
		return type instanceof JvmGenericType && !((JvmGenericType) type).isInterface();
	}

	protected JvmType findContext(JvmTypeReference firstType) {
		if (firstType instanceof JvmGenericArrayTypeReference) {
			return findContext(((JvmGenericArrayTypeReference) firstType).getComponentType());
		}
		return firstType.getType();
	}

	protected List<JvmTypeReference> replacePrimitivesAndRemoveAnyReferences(List<JvmTypeReference> types) {
		List<JvmTypeReference> result = Lists.newArrayList();
		for(JvmTypeReference type: types) {
			if (!(type instanceof JvmAnyTypeReference))
				result.add(primitives.asWrapperTypeIfPrimitive(type));
		}
		return result;
	}

	protected boolean containsPrimitiveOrAnyReferences(List<JvmTypeReference> types) {
		for(JvmTypeReference type: types) {
			if (isPrimitiveType(type))
				return true;
			if (type instanceof JvmAnyTypeReference)
				return true;
		}
		return false;
	}
	
	protected List<JvmTypeReference> getComponentTypes(List<JvmTypeReference> types) {
		ITypeReferenceVisitor<JvmTypeReference> componentTypeComputer = new AbstractTypeReferenceVisitor.InheritanceAware<JvmTypeReference>() {
			@Override
			public JvmTypeReference doVisitTypeReference(JvmTypeReference reference) {
				return null;
			}
			@Override
			protected JvmTypeReference handleNullReference() {
				return null;
			}
			@Override
			public JvmTypeReference doVisitMultiTypeReference(JvmMultiTypeReference multi) {
				JvmMultiTypeReference result = factory.createJvmMultiTypeReference();
				for(JvmTypeReference reference: multi.getReferences()) {
					JvmTypeReference component = visit(reference);
					if (component != null) {
						if (component.eContainer() == null) {
							result.getReferences().add(component);
						} else {
							JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
							delegate.setDelegate(component);
							result.getReferences().add(delegate);
						}
					}
				}
				return result;
			}
			@Override
			public JvmTypeReference doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
				return reference.getComponentType();
			}
			@Override
			public JvmTypeReference doVisitSynonymTypeReference(JvmSynonymTypeReference synonym) {
				JvmTypeReference result = null;
				for(JvmTypeReference reference: synonym.getReferences()) {
					JvmTypeReference component = visit(reference);
					if (component != null) {
						if (result == null) {
							result = component;
						} else {
							if (!(result instanceof JvmSynonymTypeReference)) {
								JvmSynonymTypeReference newResult = factory.createJvmSynonymTypeReference();
								if (result.eContainer() == null) {
									newResult.getReferences().add(result);
								} else {
									JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
									delegate.setDelegate(component);
									newResult.getReferences().add(delegate);
								}
								result = newResult;
							}
							if (component.eContainer() == null) {
								((JvmSynonymTypeReference) result).getReferences().add(result);
							} else {
								JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
								delegate.setDelegate(component);
								((JvmSynonymTypeReference) result).getReferences().add(delegate);
							}
						}
					}
				}
				return result;
			}
		};
		List<JvmTypeReference> result = Lists.newArrayList();
		for(JvmTypeReference reference: types) {
			JvmTypeReference componentType = componentTypeComputer.visit(reference);
			result.add(componentType);
		}
		return result;
	}
	
	protected boolean allTypesAreArrays(List<JvmTypeReference> types) {
		ITypeReferenceVisitor<Boolean> isArrayVisitor = new AbstractTypeReferenceVisitor.InheritanceAware<Boolean>() {
			@Override
			protected Boolean handleNullReference() {
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitTypeReference(JvmTypeReference reference) {
				return Boolean.FALSE;
			}
			@Override
			public Boolean doVisitMultiTypeReference(JvmMultiTypeReference multi) {
				for(JvmTypeReference reference: multi.getReferences()) {
					if (!visit(reference))
						return Boolean.FALSE;
				}
				return !multi.getReferences().isEmpty();
			}
			@Override
			public Boolean doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
				return reference.getComponentType() != null;
			}
			@Override
			public Boolean doVisitSynonymTypeReference(JvmSynonymTypeReference synonym) {
				for(JvmTypeReference reference: synonym.getReferences()) {
					if (visit(reference))
						return Boolean.TRUE;
				}
				return Boolean.FALSE;
			}
		};
		for(JvmTypeReference reference: types) {
			if (!isArrayVisitor.visit(reference)) {
				return false;
			}
		}
		return true;
	}
	
	protected boolean isPrimitiveType(JvmTypeReference reference) {
		return reference.getType() instanceof JvmPrimitiveType;
	}
	
	protected JvmTypeReference getTypeParametersForSupertype(final Multimap<JvmType, JvmTypeReference> all, final JvmType rawType, List<JvmTypeReference> initiallyRequested) {
		if (rawType instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) rawType).getTypeParameters();
			// if we do not declare any parameters it is safe to return the first candidate
			if (typeParameters.isEmpty()) {
				return getFirstForRawType(all, rawType); 
			}
			List<JvmTypeReference> parameterSuperTypes = Lists.newArrayList();
			for(int i = 0; i < typeParameters.size(); i++) {
				List<JvmTypeReference> parameterReferences = Lists.newArrayList();
				for(JvmTypeReference reference: all.get(rawType)) {
					if (reference instanceof JvmParameterizedTypeReference) {
						JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) reference;
						if (parameterized.getArguments().isEmpty()) { // raw type candidate - best result
							JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
							result.setType(rawType);
							return result;
						}
						JvmTypeReference parameterReference = parameterized.getArguments().get(i);
						parameterReferences.add(parameterReference);
					} else {
						return null;
					}
				}
				JvmTypeReference parameterSuperType = getCommonParameterSuperType(parameterReferences, initiallyRequested);
				if (parameterSuperType == null) {
					return null;
				} else {
					parameterSuperTypes.add(parameterSuperType);
				}
			}
			JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
			result.setType(rawType);
			for(JvmTypeReference parameterSuperType: parameterSuperTypes) {
				result.getArguments().add(EcoreUtil2.clone(parameterSuperType));
			}
			return result;
		} else if (rawType instanceof JvmArrayType) {
			final JvmComponentType componentType = ((JvmArrayType) rawType).getComponentType();
			final Function<JvmTypeReference, JvmTypeReference> getComponentType = new Function<JvmTypeReference, JvmTypeReference>() {
				public JvmTypeReference apply(JvmTypeReference from) {
					if (from instanceof JvmGenericArrayTypeReference)
						return ((JvmGenericArrayTypeReference) from).getComponentType();
					return from;
				}
			};
			Multimap<JvmType, JvmTypeReference> decorated = new ForwardingMultimap<JvmType, JvmTypeReference>() {
				@Override
				protected Multimap<JvmType, JvmTypeReference> delegate() {
					return all;
				}
				@Override
				public Collection<JvmTypeReference> get(JvmType key) {
					if (key == componentType) {
						Collection<JvmTypeReference> result = all.get(rawType);
						return Collections2.transform(result, getComponentType);
					}
					return super.get(key);
				}
			};
			JvmTypeReference componentTypeReference = getTypeParametersForSupertype(
					decorated, 
					componentType, 
					Lists.transform(initiallyRequested, getComponentType));
			if (componentTypeReference != null) {
				if (componentTypeReference.eContainer() instanceof JvmGenericArrayTypeReference) {
					return (JvmTypeReference) componentTypeReference.eContainer();
				}
				JvmGenericArrayTypeReference result = factory.createJvmGenericArrayTypeReference();
				result.setComponentType(componentTypeReference);
				return result;
			}
		}
		return null;
	}

	protected JvmTypeReference getFirstForRawType(Multimap<JvmType, JvmTypeReference> all, JvmType rawType) {
		Iterator<JvmTypeReference> iterator = all.get(rawType).iterator();
		while(iterator.hasNext()) {
			JvmTypeReference result = iterator.next();
			if (result instanceof JvmParameterizedTypeReference || result instanceof JvmGenericArrayTypeReference) {
				return result;
			}
		}
		throw new IllegalStateException(all.toString() + " does not contain a useful type reference for rawtype " + rawType.getQualifiedName());
	}

	protected void initializeDistance(final JvmTypeReference firstType, Multimap<JvmType, JvmTypeReference> all,
			Multiset<JvmType> cumulatedDistance) {
		ITypeArgumentContext firstContext = typeArgumentContextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(firstType));
		MaxDistanceRawTypeAcceptor acceptor = new MaxDistanceRawTypeAcceptor(
				cumulatedDistance, all, new ArgumentResolver(firstContext));
		acceptor.accept(firstType, 0);
		superTypeCollector.collectSuperTypes(firstType, acceptor);
	}

	/**
	 * Keeps the cumulated distance for all the common raw super types of the given references.
	 * Interfaces that are more directly implemented will get a lower total count than more general
	 * interfaces.
	 */
	protected void cumulateDistance(final List<JvmTypeReference> references, Multimap<JvmType, JvmTypeReference> all,
			Multiset<JvmType> cumulatedDistance) {
		for(JvmTypeReference other: references) {
			Multiset<JvmType> otherDistance = LinkedHashMultiset.create();
			initializeDistance(other, all, otherDistance);
			cumulatedDistance.retainAll(otherDistance);
			for(Multiset.Entry<JvmType> typeToDistance: otherDistance.entrySet()) {
				if (cumulatedDistance.contains(typeToDistance.getElement()))
					cumulatedDistance.add(typeToDistance.getElement(), typeToDistance.getCount());
			}
		}
	}

	protected void inplaceSortByDistanceAndName(List<Entry<JvmType>> candidates) {
		Collections.sort(candidates,new Comparator<Entry<JvmType>>() {
			public int compare(Entry<JvmType> o1, Entry<JvmType> o2) {
				if (o1.getCount() == o2.getCount()) {
					JvmType element1 = o1.getElement();
					JvmType element2 = o2.getElement();
					return compare(element1, element2);
				}
				if (o1.getCount() < o2.getCount())
					return -1;
				return 1;
			}

			protected int compare(JvmType element1, JvmType element2) {
				if (element1 instanceof JvmArrayType && element2 instanceof JvmArrayType) {
					return compare(((JvmArrayType) element1).getComponentType(), ((JvmArrayType) element2).getComponentType());
				}
				if (element1 instanceof JvmGenericType && element2 instanceof JvmGenericType) {
					int result = Booleans.compare(((JvmGenericType) element1).isInterface(), ((JvmGenericType) element2).isInterface());
					if (result != 0) {
						return result;
					}
				}
				return element1.getIdentifier().compareTo(element2.getIdentifier());
			}
		});
	}
	
	public JvmTypeReference getCommonParameterSuperType(final List<JvmTypeReference> types, List<JvmTypeReference> initiallyRequested) {
		Function<JvmTypeReference, String> getCanonicalName = new Function<JvmTypeReference, String>() {
			public String apply(JvmTypeReference from) {
				
				return from.getIdentifier();
			}
		};
		Set<String> allNames = Sets.newHashSet(Iterables.transform(types, getCanonicalName));
		if (allNames.size() == 1)
			return types.get(0);
		if (types.size() == initiallyRequested.size()) {
			Set<String> initiallyRequestedNames = Sets.newHashSet(Iterables.transform(initiallyRequested, getCanonicalName));
			if (initiallyRequestedNames.equals(allNames)) {
				// recursion - return object wildcard
				JvmTypeReference objectTypeReference = typeReferences.getTypeForName(Object.class, types.get(0).getType());
				return typeReferences.wildCardExtends(objectTypeReference);
			}
		}
		JvmTypeReference superType = getCommonSuperType(types);
		if (superType instanceof JvmWildcardTypeReference)
			return superType;
		JvmWildcardTypeReference wildcardTypeReference = factory.createJvmWildcardTypeReference();
		if (superType != null) {
			JvmUpperBound upperBound = factory.createJvmUpperBound();
			upperBound.setTypeReference(EcoreUtil2.clone(superType));
			wildcardTypeReference.getConstraints().add(upperBound);
		}
		return wildcardTypeReference;
	}

	protected boolean conformsToAll(JvmTypeReference type, final List<JvmTypeReference> types) {
		boolean conform = true;
		for (int i = 0; conform && i < types.size(); i++) {
			conform = isConformant(type, types.get(i));
		}
		return conform;
	}
	
	protected TypeReferences getTypeReferences() {
		return typeReferences;
	}
	
	protected SuperTypeCollector getSuperTypeCollector() {
		return superTypeCollector;
	}
	
	protected Primitives getPrimitives() {
		return primitives;
	}
	
	protected TypeArgumentContextProvider getTypeArgumentContextProvider() {
		return typeArgumentContextProvider;
	}

}