/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.Serializable;
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
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.util.SuperTypeCollector.SuperTypeAcceptor;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class TypeConformanceComputer {

	private PolymorphicDispatcher<Boolean> isConformantDispatcher = 
		PolymorphicDispatcher.createForSingleTarget("_isConformant", 2, 4, this);
	
	@Inject
	protected SuperTypeCollector superTypeCollector;
	
	@Inject
	protected TypesFactory factory = TypesFactory.eINSTANCE;

	@Inject
	protected TypeArgumentContextProvider typeArgumentContextProvider;
	
	@Inject 
	protected Primitives primitives;
	
	public void setSuperTypeCollector(SuperTypeCollector superTypeCollector) {
		this.superTypeCollector = superTypeCollector;
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

	public boolean isConformant(JvmTypeReference left, JvmTypeReference right) {
		if (left == right)
			return left != null;
		if (isObject(left))
			return true;
		if (isPrimitiveVoid(left) || left!=null && left.getType()!=null && left.getType().eIsProxy())
			return false;
		Boolean result = isConformantDispatcher.invoke(left, right);
		return result.booleanValue();
	}

	protected boolean isPrimitiveVoid(JvmTypeReference left) {
		return left!=null && left.getType()!=null && !left.getType().eIsProxy() && left.getType() instanceof JvmVoid;
	}

	protected boolean isObject(JvmTypeReference left) {
		return left!=null && left.getType()!=null && left.getType().getCanonicalName().equals(Object.class.getCanonicalName());
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
		if (leftType == rightType)
			return true;
		return isWideningConversion(leftType, rightType);
	}
	
	/**
	 * See Java Language Specification <a href="http://java.sun.com/docs/books/jls/third_edition/html/conversions.html#5.1.2">§{5.1.2} Widening Primitive Conversion</a>
	 */
	protected Boolean isWideningConversion(JvmPrimitiveType leftType, JvmPrimitiveType rightType) {
		Primitive right = primitiveKind(rightType);
		final Primitive left = primitiveKind(leftType);
		switch (left) {
			case Byte :
				return right == Primitive.Short 
					|| right == Primitive.Char // listed in section 5.1.4
					|| right == Primitive.Int
					|| right == Primitive.Long
					|| right == Primitive.Float
					|| right == Primitive.Double;
			case Short :
				return right == Primitive.Int
				|| right == Primitive.Long
				|| right == Primitive.Float
				|| right == Primitive.Double;
			case Char :
				return right == Primitive.Int
				|| right == Primitive.Long
				|| right == Primitive.Float
				|| right == Primitive.Double;
			case Int :
				return right == Primitive.Long
				|| right == Primitive.Float
				|| right == Primitive.Double;
			case Long :
				return right == Primitive.Float
				|| right == Primitive.Double;
			case Float :
				return right == Primitive.Double;
			default :
				return false;
		}
	}
	
	protected Primitive primitiveKind(JvmPrimitiveType primitiveType) {
		return primitives.primitiveKind(primitiveType);
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

	/**
	 * see <a href="http://java.sun.com/docs/books/jls/third_edition/html/conversions.html#5.1.7">§ 5.1.7</a>
	 */
	protected boolean isBoxing(JvmType typeA, JvmPrimitiveType typeB) {
		Primitive primitive = primitiveKind(typeB);
		switch (primitive) {
			case Byte :
				return is(typeA, Byte.class, Serializable.class, Comparable.class, Number.class, Object.class);
			case Short :
				return is(typeA, Short.class, Serializable.class, Comparable.class, Number.class, Object.class);
			case Char :
				return is(typeA, Character.class, Serializable.class, Comparable.class, Object.class);
			case Int :
				return is(typeA, Integer.class, Serializable.class, Comparable.class, Number.class, Object.class);
			case Long :
				return is(typeA, Long.class, Serializable.class, Comparable.class, Number.class, Object.class);
			case Float :
				return is(typeA, Float.class, Serializable.class, Comparable.class, Number.class, Object.class);
			case Double :
				return is(typeA, Double.class, Serializable.class, Comparable.class, Number.class, Object.class);
			case Boolean :
				return is(typeA, Boolean.class, Serializable.class, Comparable.class, Object.class);
			default :
				return false;
		}
	}

	/**
	 * see <a href="http://java.sun.com/docs/books/jls/third_edition/html/conversions.html#5.1.8">§ 5.1.8</a>
	 */
	protected boolean isUnBoxing(JvmPrimitiveType typeA, JvmType typeB) {
		Primitive primitive = primitiveKind(typeA);
		switch (primitive) {
			case Byte :
				return is(typeB, Byte.class);
			case Short :
				return is(typeB, Short.class);
			case Char :
				return is(typeB, Character.class);
			case Int :
				return is(typeB, Integer.class);
			case Long :
				return is(typeB, Long.class);
			case Float :
				return is(typeB, Float.class);
			case Double :
				return is(typeB, Double.class);
			case Boolean :
				return is(typeB, Boolean.class);
			default :
				return false;
		}
	}

	protected boolean is(JvmType typeA, Class<?> ...class1) {
		for (Class<?> class2 : class1) {
			boolean result = typeA.getCanonicalName().equals(class2.getCanonicalName());
			if (result)
				return true;
		}
		return false;
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

	protected boolean isNullOrProxy(JvmTypeReference type) {
		return type==null || type.getType()==null || type.eIsProxy();
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
		TypeArgumentContext firstContext = typeArgumentContextProvider.getReceiverContext(firstType);
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