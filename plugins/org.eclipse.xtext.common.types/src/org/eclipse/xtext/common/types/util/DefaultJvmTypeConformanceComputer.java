/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.SuperTypeCollector.SuperTypeAcceptor;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.Multiset.Entry;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class DefaultJvmTypeConformanceComputer implements IJvmTypeConformanceComputer{

	private PolymorphicDispatcher<Boolean> isConformantDispatcher = 
		PolymorphicDispatcher.createForSingleTarget("_isConformant", 2, 4, this);
	
	private SuperTypeCollector superTypeCollector;
	
	private TypesFactory factory;

	private final TypeArgumentContext.Provider typeArgumentContextProvider;

	@Inject
	public DefaultJvmTypeConformanceComputer(
			SuperTypeCollector superTypeCollector,
			TypeArgumentContext.Provider typeArgumentContextProvider,
			TypesFactory factory) {
		this.superTypeCollector = superTypeCollector;
		this.typeArgumentContextProvider = typeArgumentContextProvider;
		this.factory = factory;
	}

	public boolean isConformant(JvmTypeReference left, JvmTypeReference right) {
		if (left == right)
			return left != null;
		Boolean result = isConformantDispatcher.invoke(left, right);
		return result.booleanValue();
	}
	
	protected Boolean _isConformant(JvmTypeReference left, JvmTypeReference right) {
		Boolean result = isConformantDispatcher.invoke(left.getType(), right.getType(), left, right);
		return result;
	}
	
	protected Boolean _isConformant(JvmWildcardTypeReference left, JvmParameterizedTypeReference right) {
		for (JvmTypeConstraint constraint: left.getConstraints()) {
			if (constraint instanceof JvmUpperBound) {
				JvmTypeReference upperBound = constraint.getTypeReference();
				if (upperBound != null) { // not a wildcard
					Boolean result = isConformant(upperBound, right);
					if (!result)
						return Boolean.FALSE;
				}
			} else if (constraint instanceof JvmLowerBound) {
				JvmTypeReference lowerBound = constraint.getTypeReference();
				Boolean result = isConformant(right, lowerBound);
				if (!result)
					return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
	
	protected Boolean _isConformant(JvmParameterizedTypeReference left, JvmWildcardTypeReference right) {
		return Boolean.FALSE;
	}
	
	protected Boolean _isConformant(JvmWildcardTypeReference left, JvmWildcardTypeReference right) {
		List<JvmTypeConstraint> leftConstraints = left.getConstraints();
		List<JvmTypeConstraint> rightConstraints = right.getConstraints();
		if (leftConstraints.size() != rightConstraints.size())
			return Boolean.FALSE;
		int constraintCount = leftConstraints.size();
		for(int i = 0; i < constraintCount; i++) {
			JvmTypeConstraint leftConstraint = leftConstraints.get(i);
			JvmTypeConstraint rightConstraint = rightConstraints.get(i);
			if (leftConstraint.eClass() != rightConstraint.eClass())
				return Boolean.FALSE;
			if (leftConstraint instanceof JvmUpperBound) {
				if (leftConstraint.getTypeReference() != null) { // not a wildcard
					if (!isConformant(leftConstraint.getTypeReference(), rightConstraint.getTypeReference()))
						return Boolean.FALSE;
				}
			} else {
				if (!isConformant(rightConstraint.getTypeReference(), leftConstraint.getTypeReference()))
					return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
	
	protected Boolean _isConformant(JvmPrimitiveType leftType, JvmPrimitiveType rightType, JvmParameterizedTypeReference left, JvmParameterizedTypeReference right) {
		return leftType == rightType;
	}
	
	protected Boolean _isConformant(JvmPrimitiveType leftType, JvmType rightType, JvmParameterizedTypeReference left, JvmParameterizedTypeReference right) {
		return isUnBoxing(leftType, rightType);
	}
	
	protected Boolean _isConformant(JvmDeclaredType leftType, JvmPrimitiveType rightType, JvmParameterizedTypeReference left, JvmParameterizedTypeReference right) {
		return isBoxing(leftType, rightType);
	}
	
	protected Boolean _isConformant(JvmDeclaredType leftType, JvmDeclaredType rightType, JvmParameterizedTypeReference left, JvmParameterizedTypeReference right) {
		if (leftType == rightType || superTypeCollector.collectSuperTypesAsRawTypes(right).contains(leftType)) {
			return areArgumentsAssignableFrom(left, right);
		}
		return Boolean.FALSE;
	}
	
	protected Boolean _isConformant(JvmDeclaredType leftType, JvmType rightType, JvmTypeReference left, JvmTypeReference right) {
		return Boolean.FALSE;
	}
	
	protected Boolean _isConformant(JvmTypeParameter leftType, JvmTypeParameter rightType, JvmParameterizedTypeReference left, JvmParameterizedTypeReference right) {
		return leftType == rightType;
	}
	
	protected Boolean _isConformant(JvmTypeParameter leftType, JvmType rightType, JvmParameterizedTypeReference left, JvmParameterizedTypeReference right) {
		List<JvmTypeConstraint> list = leftType.getConstraints();
		for (JvmTypeConstraint jvmTypeConstraint : list) {
			if (jvmTypeConstraint instanceof JvmUpperBound) {
				JvmTypeReference typeReference = jvmTypeConstraint.getTypeReference();
				if (isConformant(typeReference, right))
					return true;
			}
		}
		return list.isEmpty();
	}
	
	protected Boolean _isConformant(JvmArrayType leftType, JvmArrayType rightType, JvmTypeReference left, JvmTypeReference right) {
		JvmTypeReference leftComponentType = leftType.getComponentType();
		JvmTypeReference rightComponentType = rightType.getComponentType();
		return isConformant(leftComponentType, rightComponentType);
	}
	
	protected Boolean _isConformant(JvmArrayType leftType, JvmType rightType, JvmTypeReference left, JvmTypeReference right) {
		return Boolean.FALSE;
	}

	protected boolean areArgumentsAssignableFrom(JvmParameterizedTypeReference left, JvmParameterizedTypeReference right) {
		// raw type
		if (left.getArguments().size() == 0 || right.getArguments().size() == 0) {
			return true;
		}
		if (left.getArguments().size() != right.getArguments().size()) {
			return false;
		}

		for (int i = 0; i < left.getArguments().size(); i++) {
			JvmTypeReference argumentA = left.getArguments().get(i);
			JvmTypeReference argumentB = right.getArguments().get(i);
			if (!isArgumentAssignable(argumentA, argumentB))
				return false;
		}
		return true;
	}

	protected boolean isArgumentAssignable(JvmTypeReference refA, JvmTypeReference refB) {
		JvmTypeReference upperA = getUpper(refA);
		JvmTypeReference upperB = getUpper(refB);
		JvmTypeReference lowerA = getLower(refA);
		JvmTypeReference lowerB = getLower(refB);
		if (isUnconstrainedWildcard(refA)) {
			return true;
		}
		if (upperA != null) {
			if (upperB != null) {
				return isConformant(upperA, upperB);
			} else if (!(refB instanceof JvmWildcardTypeReference)) {
				return isConformant(upperA, refB);
			}
		} else if (!(refA instanceof JvmWildcardTypeReference)) {
			if (!(refB instanceof JvmWildcardTypeReference)) {
				if (refA.getType() == refB.getType())
					return areArgumentsAssignableFrom((JvmParameterizedTypeReference)refA, (JvmParameterizedTypeReference)refB);
			}
		} else if (lowerA != null) {
			if (lowerB != null && isConformant(lowerB, lowerA)) {
				return true;
			}
		}
		return false;
	}

	protected boolean isUnconstrainedWildcard(JvmTypeReference argumentA) {
		return argumentA instanceof JvmWildcardTypeReference
				&& ((JvmWildcardTypeReference) argumentA).getConstraints().isEmpty();
	}

	protected JvmTypeReference getLower(JvmTypeReference argumentA) {
		if (argumentA instanceof JvmWildcardTypeReference) {
			EList<JvmTypeConstraint> list = ((JvmWildcardTypeReference) argumentA).getConstraints();
			for (JvmTypeConstraint constraint : list) {
				if (constraint instanceof JvmLowerBound) {
					return constraint.getTypeReference();
				}
			}
		}
		return null;
	}

	protected JvmTypeReference getUpper(JvmTypeReference argumentA) {
		if (argumentA instanceof JvmWildcardTypeReference) {
			EList<JvmTypeConstraint> list = ((JvmWildcardTypeReference) argumentA).getConstraints();
			for (JvmTypeConstraint constraint : list) {
				if (constraint instanceof JvmUpperBound) {
					return constraint.getTypeReference();
				}
			}
		}
		return null;
	}

	protected boolean isBoxing(JvmType typeA, JvmType typeB) {
		return is(typeA, Integer.class) && is(typeB, Integer.TYPE) 
			|| is(typeA, Boolean.class) && is(typeB, Boolean.TYPE) 
			|| is(typeA, Long.class) && is(typeB, Long.TYPE) 
			|| is(typeA, Float.class) && is(typeB, Float.TYPE) 
			|| is(typeA, Double.class) && is(typeB, Double.TYPE) 
			|| is(typeA, Byte.class) && is(typeB, Byte.TYPE) 
			|| is(typeA, Character.class) && is(typeB,Character.TYPE);
	}

	protected boolean isUnBoxing(JvmType typeA, JvmType typeB) {
		return is(typeB, Integer.class) && is(typeA, Integer.TYPE) 
			|| is(typeB, Boolean.class) && is(typeA, Boolean.TYPE) 
			|| is(typeB, Long.class) && is(typeA, Long.TYPE) 
			|| is(typeB, Float.class) && is(typeA, Float.TYPE) 
			|| is(typeB, Double.class) && is(typeA, Double.TYPE) 
			|| is(typeB, Byte.class) && is(typeA, Byte.TYPE) 
			|| is(typeB, Character.class) && is(typeA,Character.TYPE);
	}

	protected boolean is(JvmType typeA, Class<?> class1) {
		return typeA.getCanonicalName().equals(class1.getCanonicalName());
	}

	public String getName(JvmTypeReference actual) {
		return actual.getCanonicalName();
	}
	
	/**
	 * Populates a {@link Multiset} with the maximum number of necessary steps
	 * from a given type to its super types. Sorting the set by the steps creates 
	 * a stable order on from the direct super class, the most specialized implemented 
	 * interfaces up to object.
	 * E.g. although {@link StringBuilder} implements {@link java.io.Serializable} and 
	 * {@link CharSequence}, serializable is treated as more special by this algorithm
	 * since the super class AbstractStringBuilder implements {@link CharSequence}, too.
	 * Thus the number of steps to {@link java.io.Serializable} is <code>1</code> while 
	 * {@link CharSequence} requires <code>2</code> hops. 
	 */
	protected static class MaxDistanceRawTypeAcceptor implements SuperTypeAcceptor {

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
			JvmType type = superType.getType();
			rawTypeToReference.put(type, resolver.apply(superType));
			if (distances.contains(type)) {
				int currentCount = distances.count(type);
				if (currentCount < distance) {
					distances.setCount(type, distance);
				}
			} else {
				distances.add(type, distance);
			}
			return true;
		}
		
	}
	
	protected static class ArgumentResolver implements Function<JvmTypeReference, JvmTypeReference> {

		private final TypeArgumentContext context;

		protected ArgumentResolver(TypeArgumentContext context) {
			this.context = context;
		}
		
		public JvmTypeReference apply(JvmTypeReference from) {
			JvmTypeReference result = context.resolve(from);
			return result;
		}
		
	}
	
	public JvmTypeReference getCommonSuperType(final List<JvmTypeReference> types) {
		if (types==null || types.isEmpty())
			throw new IllegalArgumentException("Types can't be null or empty "+types);
		if (types.size()==1)
			return types.get(0);

		// Check the straight forward case - one of the types is a supertype of all the others.
		for(JvmTypeReference type: types) {
			if (conformsToAll(type, types))
				return type;
		}
		
		JvmTypeReference firstType = types.get(0);
		final List<JvmTypeReference> tail = types.subList(1, types.size());
		// mapping from rawtype to resolved parameterized types
		// used to determine the correct type arguments
		Multimap<JvmType, JvmTypeReference> all = HashMultimap.create();
		// cumulated rawtype to max distance (used for sorting)
		Multiset<JvmType> cumulatedDistance = HashMultiset.create();
		
		initializeDistance(firstType, all, cumulatedDistance);
		cumulateDistance(tail, all, cumulatedDistance);
		
		List<Entry<JvmType>> candidates = Lists.newArrayList(cumulatedDistance.entrySet());
		if (candidates.size() == 1) { // only one super type -> should be java.lang.Object
			JvmType firstRawType = candidates.get(0).getElement();
			return getFirstForRawType(all, firstRawType);
		}
		inplaceSortByDistanceAndName(candidates);
		// try to find a matching parameterized type for the raw types in ascending order
		for(Entry<JvmType> rawTypeCandidate: candidates) {
			JvmType rawType = rawTypeCandidate.getElement();
			JvmTypeReference result = getTypeParametersForSupertype(all, rawType);
			if (result != null)
				return result;
		}
		throw new IllegalStateException("java.lang.Object does not have type parameters and should be contained in list");
	}

	protected JvmTypeReference getTypeParametersForSupertype(Multimap<JvmType, JvmTypeReference> all, JvmType rawType) {
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
				JvmTypeReference parameterSuperType = getCommonParameterSuperType(parameterReferences);
				if (parameterSuperType == null) {
					return null;
				} else {
					parameterSuperTypes.add(parameterSuperType);
				}
			}
			JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
			result.setType(rawType);
			for(JvmTypeReference parameterSuperType: parameterSuperTypes) {
				result.getArguments().add((JvmTypeReference) EcoreUtil.copy(parameterSuperType));
			}
			return result;
		}
		return null;
	}

	protected JvmTypeReference getFirstForRawType(Multimap<JvmType, JvmTypeReference> all, JvmType rawType) {
		JvmTypeReference result = all.get(rawType).iterator().next();
		return result;
	}

	protected void initializeDistance(JvmTypeReference firstType, Multimap<JvmType, JvmTypeReference> all,
			Multiset<JvmType> cumulatedDistance) {
		TypeArgumentContext firstContext = typeArgumentContextProvider.get(firstType);
		superTypeCollector.collectSuperTypes(firstType, new MaxDistanceRawTypeAcceptor(
				cumulatedDistance, all, new ArgumentResolver(firstContext)));
	}

	/**
	 * Keeps the cumulated distance for all the common raw super types of the given references.
	 * Interfaces that are more directly implemented will get a lower total count than more general
	 * interfaces.
	 */
	protected void cumulateDistance(final List<JvmTypeReference> references, Multimap<JvmType, JvmTypeReference> all,
			Multiset<JvmType> cumulatedDistance) {
		for(JvmTypeReference other: references) {
			Multiset<JvmType> otherDistance = HashMultiset.create();
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
				if (o1.getCount() == o2.getCount())
					return o1.getElement().getCanonicalName().compareTo(o2.getElement().getCanonicalName());
				if (o1.getCount() < o2.getCount())
					return -1;
				return 1;
			}
		});
	}
	
	public JvmTypeReference getCommonParameterSuperType(final List<JvmTypeReference> types) {
		Set<String> allNames = Sets.newHashSet(Iterables.transform(types, new Function<JvmTypeReference, String>() {
			public String apply(JvmTypeReference from) {
				return from.getCanonicalName();
			}
		}));
		if (allNames.size() == 1)
			return types.get(0);
		JvmTypeReference superType = getCommonSuperType(types);
		if (superType instanceof JvmWildcardTypeReference)
			return superType;
		JvmWildcardTypeReference wildcardTypeReference = factory.createJvmWildcardTypeReference();
		JvmUpperBound upperBound = factory.createJvmUpperBound();
		upperBound.setTypeReference((JvmTypeReference) EcoreUtil.copy(superType));
		wildcardTypeReference.getConstraints().add(upperBound);
		return wildcardTypeReference;
	}

	protected boolean conformsToAll(JvmTypeReference type, final List<JvmTypeReference> types) {
		boolean conform = true;
		for (int i = 0; conform && i < types.size(); i++) {
			conform = isConformant(type, types.get(i));
		}
		return conform;
	}

}