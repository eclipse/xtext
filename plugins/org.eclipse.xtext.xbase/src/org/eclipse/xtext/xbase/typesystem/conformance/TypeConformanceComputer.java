/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

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
 * @author Sebastian Zarnekow
 */
@Singleton
public class TypeConformanceComputer extends RawTypeConformanceComputer {

	@Inject
	private RawTypeConformanceComputer rawTypeConformanceComputer = new RawTypeConformanceComputer();
	
	public boolean isConformant(LightweightTypeReference left, LightweightTypeReference right) {
		return (isConformant(left, right, ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION | ALLOW_RAW_TYPE_CONVERSION) & SUCCESS) != 0;
	}
	
	public TypeConformanceResult isConformant(LightweightTypeReference left, LightweightTypeReference right, TypeConformanceComputationArgument argument) {
		int flags = toFlags(argument);
		int result = isConformant(left, right, flags);
		EnumSet<ConformanceHint> resultFlags = toResult(result);
		return new TypeConformanceResult(resultFlags);
	}

	protected EnumSet<ConformanceHint> toResult(int result) {
		EnumSet<ConformanceHint> resultFlags = EnumSet.noneOf(ConformanceHint.class);
		if ((result & SUCCESS) != 0) {
			resultFlags.add(ConformanceHint.SUCCESS);
		} else {
			resultFlags.add(ConformanceHint.INCOMPATIBLE);
		}
		if ((result & DEMAND_CONVERSION) != 0) {
			resultFlags.add(ConformanceHint.DEMAND_CONVERSION);
		}
		if ((result & SUBTYPE) != 0) {
			resultFlags.add(ConformanceHint.SUBTYPE);
		}
		if ((result & PRIMITIVE_WIDENING) != 0) {
			resultFlags.add(ConformanceHint.PRIMITIVE_WIDENING);
		}
		if ((result & UNBOXING) != 0) {
			resultFlags.add(ConformanceHint.UNBOXING);
		}
		if ((result & BOXING) != 0) {
			resultFlags.add(ConformanceHint.BOXING);
		}
		if ((result & RAW_TYPE_CONVERSION) != 0) {
			resultFlags.add(ConformanceHint.RAWTYPE_CONVERSION);
		}
		if ((result & RAW_TYPE) != 0) {
			resultFlags.add(ConformanceHint.RAW);
		}
		if ((result & SYNONYM) != 0) {
			resultFlags.add(ConformanceHint.SYNONYM);
		}
		if ((result & UNKNOWN_TYPE_PARTICIPATED) != 0) {
			resultFlags.add(ConformanceHint.UNKNOWN_TYPE_PARTICIPATED);
		}
		return resultFlags;
	}

	protected int toFlags(TypeConformanceComputationArgument argument) {
		int flags = ALLOW_RAW_TYPE_CONVERSION | ALLOW_FUNCTION_CONVERSION;
		if (argument.allowPrimitiveConversion) {
			flags |= ALLOW_BOXING_UNBOXING;
		}
		if (argument.allowPrimitiveWidening) {
			flags |= ALLOW_PRIMITIVE_WIDENING;
		}
		if (argument.allowSynonyms) {
			flags |= ALLOW_SYNONYMS;
		}
		if (argument.rawType) {
			flags |= RAW_TYPE;
		}
		if (argument.asTypeArgument) {
			flags |= AS_TYPE_ARGUMENT;
		}
		if (argument.unboundComputationAddsHints) {
			flags |= UNBOUND_COMPUTATION_ADDS_HINTS;
		}
		return flags;
	}
	
	@Override
	public int isConformant(LightweightTypeReference left, LightweightTypeReference right, int flags) {
		if (left == right && left != null) // TODO handle null
			return flags | SUCCESS;
		if ((flags & RAW_TYPE) != 0 || ((left.isRawType() || right.isRawType()) && (flags & ALLOW_RAW_TYPE_CONVERSION) != 0)) {
			int result = rawTypeConformanceComputer.isConformant(left, right, flags);
			if ((result & SUCCESS) != 0) {
				if (left.isRawType() != right.isRawType() && left.getTypeArguments().isEmpty() != right.getTypeArguments().isEmpty()) {
					result |= RAW_TYPE_CONVERSION;
				}
			} else {
				return isSynonymConformant(result, left, right, flags);
			}
			return result;
		}
		int result = doIsConformant(left, right, flags);
		return isSynonymConformant(result, left, right, flags);
	}
	
	@Override
	protected LightweightTypeReference getSuperType(ParameterizedTypeReference current, JvmType type) {
		return current.getSuperType(type);
	}
	
	@Override
	protected int doIsConformantTypeArguments(ParameterizedTypeReference left, ParameterizedTypeReference right, int flags) {
		List<LightweightTypeReference> leftTypeArguments = left.getTypeArguments();
		List<LightweightTypeReference> rightTypeArguments = right.getTypeArguments();
		int size = leftTypeArguments.size();
		if (size == rightTypeArguments.size()) {
			int argumentFlags = (flags | AS_TYPE_ARGUMENT) & ~(ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION | ALLOW_RAW_TYPE_CONVERSION);  
			for(int i = 0; i < size; i++) {
				if ((doIsConformant(leftTypeArguments.get(i), rightTypeArguments.get(i), argumentFlags) & SUCCESS) == 0) {
					return flags;
				}
			}
		} else if ((flags & ALLOW_RAW_TYPE_CONVERSION) != 0) {
			if (size == 0 || rightTypeArguments.isEmpty()) {
				return flags | SUCCESS | RAW_TYPE_CONVERSION;
			}
		} else {
			return flags;
		}
		return flags | SUCCESS;
	}
	
	@Override
	protected int doIsConformant(FunctionTypeReference left, FunctionTypeReference right, int flags) {
		if ((flags & ALLOW_FUNCTION_CONVERSION) == 0)
			return doIsConformant((ParameterizedTypeReference)left, (ParameterizedTypeReference)right, flags);
		List<LightweightTypeReference> leftParameterTypes = left.getParameterTypes();
		List<LightweightTypeReference> rightParameterTypes = right.getParameterTypes();
		if (leftParameterTypes.size() != rightParameterTypes.size()) {
			return flags;
		}
		LightweightTypeReference leftReturnType = left.getReturnType();
		LightweightTypeReference rightReturnType = right.getReturnType();
		if (leftReturnType!=rightReturnType && (leftReturnType == null || rightReturnType == null)) {
			return flags;
		}
		boolean leftIsVoid = leftReturnType != null && leftReturnType.isPrimitiveVoid();
		boolean rightIsVoid = rightReturnType != null && rightReturnType.isPrimitiveVoid();
		if (leftIsVoid) {
			if (!rightIsVoid) {
				return flags;
			}
		} else if (rightIsVoid) {
			return flags;
		}
		if (leftReturnType != rightReturnType && !leftIsVoid && (doIsConformant(leftReturnType, rightReturnType, 
				flags & ~(ALLOW_PRIMITIVE_WIDENING | ALLOW_FUNCTION_CONVERSION | ALLOW_SYNONYMS)) & SUCCESS) == 0) {
			return flags;
		}
		for(int i = 0; i < leftParameterTypes.size(); i++) {
			LightweightTypeReference leftParameterType = leftParameterTypes.get(i);
			LightweightTypeReference rightParameterType = rightParameterTypes.get(i);
			if (leftParameterType!=rightParameterType && (leftParameterType == null || rightParameterType == null)) {
				return flags;
			}
			if ((doIsConformant(rightParameterType, leftParameterType, flags & ~(ALLOW_PRIMITIVE_WIDENING | ALLOW_FUNCTION_CONVERSION | ALLOW_SYNONYMS )) & SUCCESS) == 0) {
				return flags;
			} 
		}
		return flags | SUCCESS;
	}
	
	/**
	 * Compute the common super type for the given types.
	 * 
	 * May return <code>null</code> in case one of the types is primitive void but not all 
	 * of them are.
	 */
	/* @Nullable */
	public LightweightTypeReference getCommonSuperType(final /* @NonNull */ List<LightweightTypeReference> types, ITypeReferenceOwner owner) {
		if (types==null || types.isEmpty())
			throw new IllegalArgumentException("Types can't be null or empty "+types);
		if (types.size()==1)
			return types.get(0);
		
		// Check the straight forward case - one of the types is a supertype of all the others.
		// Further more check if any of the types is Void.TYPE -> all have to be Void.TYPE
		boolean allVoid = true;
		for(LightweightTypeReference type: types) {
			if (!type.isPrimitiveVoid()) {
				allVoid = false;
				break;
			}
		}
		if (allVoid) {
			return types.get(0);
		}
		for(LightweightTypeReference type: types) {
			LightweightTypeReference conformantType = conformsToAll(type, types);
			if (conformantType != null)
				return conformantType;
			if (type.isPrimitiveVoid()) {
				// we saw void but was not all were void
				return null;
			}
		}
		if (containsPrimitiveOrAnyReferences(types)) {
			List<LightweightTypeReference> withoutPrimitives = replacePrimitivesAndRemoveAnyReferences(types);
			if (withoutPrimitives.equals(types))
				return null;
			return getCommonSuperType(withoutPrimitives, owner);
		}
		LightweightTypeReference firstType = types.get(0);
		final List<LightweightTypeReference> tail = types.subList(1, types.size());
		// mapping from rawtype to resolved parameterized types
		// used to determine the correct type arguments
		Multimap<JvmType, LightweightTypeReference> all = LinkedHashMultimap.create();
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
		List<LightweightTypeReference> referencesWithSameDistance = Lists.newArrayListWithExpectedSize(2);
		int wasDistance = -1;
		boolean classSeen = false;
		outer: for(Entry<JvmType> rawTypeCandidate: candidates) {
			JvmType rawType = rawTypeCandidate.getElement();
			LightweightTypeReference result = null;
			if (wasDistance == -1) {
				wasDistance = rawTypeCandidate.getCount();
			} else {
				if (wasDistance != rawTypeCandidate.getCount()) {
					if (classSeen)
						break;
					result = getTypeParametersForSupertype(all, rawType, owner, types);
					for(LightweightTypeReference alreadyCollected: referencesWithSameDistance) {
						if ((isConformant(result, alreadyCollected,
								RawTypeConformanceComputer.RAW_TYPE | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION | ALLOW_RAW_TYPE_CONVERSION) & SUCCESS) != 0) {
							classSeen = classSeen || isClass(rawType);
							continue outer;
						}
					}
					wasDistance = rawTypeCandidate.getCount(); 
				}
			}
			if (result == null)
				result = getTypeParametersForSupertype(all, rawType, owner, types);
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
			CompoundTypeReference result = new CompoundTypeReference(owner, false);
			for(LightweightTypeReference reference: referencesWithSameDistance) {
				result.addComponent(reference);
			}
			return result;
		}
		return null;
	}
	
	protected boolean isClass(JvmType type) {
		if (type.eClass() == TypesPackage.Literals.JVM_ARRAY_TYPE)
			return isClass(((JvmArrayType) type).getComponentType());
		return type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && !((JvmGenericType) type).isInterface();
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
	protected static class MaxDistanceRawTypeAcceptor implements SuperTypeAcceptor {

		/**
		 * The set with with the distance information.
		 */
		private final Multiset<JvmType> distances;
		
		/**
		 * All seen raw types mapped to their resolved parameterized references.
		 */
		private final Multimap<JvmType, LightweightTypeReference> rawTypeToReference;
		
		protected MaxDistanceRawTypeAcceptor(
				Multiset<JvmType> result, 
				Multimap<JvmType, LightweightTypeReference> all) {
			this.distances = result;
			this.rawTypeToReference = all;
		}
		
		public boolean accept(LightweightTypeReference superType, int distance) {
			if (superType == null)
				throw new IllegalStateException("superType may not be null");
			JvmType type = superType.getType();
			if (type != null) {
				rawTypeToReference.put(type, superType);
				if (distances.contains(type)) {
					int currentCount = distances.count(type);
					if (currentCount < distance + 1) {
						distances.setCount(type, distance + 1);
					}
				} else {
					distances.add(type, distance + 1);
				}
			}
			return true;
		}
		
	}
	
	protected void initializeDistance(final LightweightTypeReference firstType, Multimap<JvmType, LightweightTypeReference> all,
			Multiset<JvmType> cumulatedDistance) {
		MaxDistanceRawTypeAcceptor acceptor = new MaxDistanceRawTypeAcceptor(cumulatedDistance, all);
		acceptor.accept(firstType, 0);
		firstType.collectSuperTypes(acceptor);
	}

	/**
	 * Keeps the cumulated distance for all the common raw super types of the given references.
	 * Interfaces that are more directly implemented will get a lower total count than more general
	 * interfaces.
	 */
	protected void cumulateDistance(final List<LightweightTypeReference> references, Multimap<JvmType, LightweightTypeReference> all,
			Multiset<JvmType> cumulatedDistance) {
		for(LightweightTypeReference other: references) {
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
				if (element1.eClass() == TypesPackage.Literals.JVM_ARRAY_TYPE && element2.eClass() == TypesPackage.Literals.JVM_ARRAY_TYPE) {
					return compare(((JvmArrayType) element1).getComponentType(), ((JvmArrayType) element2).getComponentType());
				}
				if (element1.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && element2.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
					int result = Booleans.compare(((JvmGenericType) element1).isInterface(), ((JvmGenericType) element2).isInterface());
					if (result != 0) {
						return result;
					}
				}
				return element1.getIdentifier().compareTo(element2.getIdentifier());
			}
		});
	}

	protected List<LightweightTypeReference> replacePrimitivesAndRemoveAnyReferences(List<LightweightTypeReference> types) {
		List<LightweightTypeReference> result = Lists.newArrayList();
		for(LightweightTypeReference type: types) {
			if (!(type.isAny()))
				result.add(type.getWrapperTypeIfPrimitive());
		}
		return result;
	}

	protected boolean containsPrimitiveOrAnyReferences(List<LightweightTypeReference> types) {
		for(LightweightTypeReference type: types) {
			if (type.isPrimitive() || type.isAny())
				return true;
		}
		return false;
	}
	
	protected LightweightTypeReference getFirstForRawType(Multimap<JvmType, LightweightTypeReference> all, JvmType rawType) {
		Iterator<LightweightTypeReference> iterator = all.get(rawType).iterator();
		while(iterator.hasNext()) {
			LightweightTypeReference result = iterator.next();
			if (result instanceof ParameterizedTypeReference || result instanceof ArrayTypeReference) {
				return result;
			}
		}
		throw new IllegalStateException(all.toString() + " does not contain a useful type reference for rawtype " + rawType.getIdentifier());
	}
	
	protected LightweightTypeReference getTypeParametersForSupertype(
			final Multimap<JvmType, LightweightTypeReference> all, 
			JvmType rawType, 
			ITypeReferenceOwner owner,
			List<LightweightTypeReference> initiallyRequested) {
		if (rawType instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) rawType).getTypeParameters();
			// if we do not declare any parameters it is safe to return the first candidate
			if (typeParameters.isEmpty()) {
				return getFirstForRawType(all, rawType); 
			}
			List<LightweightTypeReference> parameterSuperTypes = Lists.newArrayListWithCapacity(typeParameters.size());
			for(int i = 0; i < typeParameters.size(); i++) {
				List<LightweightTypeReference> parameterReferences = Lists.newArrayListWithCapacity(typeParameters.size());
				for(LightweightTypeReference reference: all.get(rawType)) {
					if (reference instanceof ParameterizedTypeReference) {
						ParameterizedTypeReference parameterized = (ParameterizedTypeReference) reference;
						if (parameterized.getTypeArguments().isEmpty()) { // raw type candidate - best result
							return parameterized;
						}
						LightweightTypeReference parameterReference = parameterized.getTypeArguments().get(i);
						if (parameterized instanceof FunctionTypeReference && !(parameterReference instanceof WildcardTypeReference)) {
							FunctionTypeReference functionType = (FunctionTypeReference) parameterized;
							if (i == typeParameters.size() - 1 && parameterReference.equals(functionType.getReturnType())) { 
								WildcardTypeReference wildcard = new WildcardTypeReference(owner);
								wildcard.addUpperBound(parameterReference);
								parameterReferences.add(wildcard);
							} else if (functionType.getParameterTypes().contains(parameterReference)) {
								WildcardTypeReference wildcard = createObjectWildcardReference(owner);
								wildcard.setLowerBound(parameterReference);
								parameterReferences.add(wildcard);
							} else {
								parameterReferences.add(parameterReference);	
							}
						} else {
							parameterReferences.add(parameterReference);
						}
					} else {
						return null;
					}
				}
				LightweightTypeReference parameterSuperType = getCommonParameterSuperType(parameterReferences, initiallyRequested, owner);
				if (parameterSuperType == null) {
					return null;
				} else {
					parameterSuperTypes.add(parameterSuperType);
				}
			}
			
			ParameterizedTypeReference result = new ParameterizedTypeReference(owner, rawType);
			for(LightweightTypeReference parameterSuperType: parameterSuperTypes) {
				result.addTypeArgument(parameterSuperType.copyInto(owner));
			}
			FunctionTypeReference resultAsFunctionType = result.getAsFunctionTypeReference();
			if (resultAsFunctionType != null)
				return resultAsFunctionType;
			return result;
		} else if (rawType.eClass() == TypesPackage.Literals.JVM_ARRAY_TYPE) {
			JvmComponentType componentType = ((JvmArrayType) rawType).getComponentType();
			Multimap<JvmType,LightweightTypeReference> copiedMultimap = LinkedHashMultimap.create(all);
			Collection<LightweightTypeReference> originalReferences = all.get(rawType);
			List<LightweightTypeReference> componentReferences = Lists.newArrayListWithCapacity(originalReferences.size());
			for(LightweightTypeReference originalReference: originalReferences) {
				addComponentType(originalReference, componentReferences);
			}
			copiedMultimap.replaceValues(componentType, componentReferences);
			List<LightweightTypeReference> componentRequests = Lists.newArrayListWithCapacity(initiallyRequested.size());
			for(LightweightTypeReference initialRequest: initiallyRequested) {
				addComponentType(initialRequest, componentRequests);
			}
			LightweightTypeReference componentTypeReference = getTypeParametersForSupertype(
					copiedMultimap, 
					componentType,
					owner,
					componentRequests);
			if (componentTypeReference != null) {
				return new ArrayTypeReference(owner, componentTypeReference);
			}
		}
		return null;
	}
	
	public LightweightTypeReference getCommonParameterSuperType(List<LightweightTypeReference> types, List<LightweightTypeReference> initiallyRequested, ITypeReferenceOwner owner) {
		LightweightTypeReference mostSpecialTypeIfAllWildcards = getMostSpecialTypeIfAllWildcards(types, owner);
		if (mostSpecialTypeIfAllWildcards != null) {
			if (mostSpecialTypeIfAllWildcards instanceof WildcardTypeReference)
				return mostSpecialTypeIfAllWildcards;
			WildcardTypeReference result = createObjectWildcardReference(owner);
			result.setLowerBound(mostSpecialTypeIfAllWildcards);
			return result;
		}
		Set<String> allNames = Sets.newHashSet();
		Set<String> allBoundNames = Sets.newHashSet();
		boolean allResolved = true;
		for(int i = 0; i < types.size() && allResolved; i++) {
			allResolved = types.get(i).isResolved();
		}
		for(int i = 0; i < types.size(); i++) {
			LightweightTypeReference type = types.get(i);
			if (allResolved) {
				type = type.getUpperBoundSubstitute();
			} else {
				type = type.getInvariantBoundSubstitute();
			}
			types.set(i, type);
			addIdentifier(type, allNames, allBoundNames);
		}
		if (allNames.size() == 1) {
			return types.get(0);
		}
		// recursive request - return object wildcard
		if (isRecursiveRequest(types, allNames, initiallyRequested)) {
			return createObjectWildcardReference(owner);
		}
		LightweightTypeReference superType = getCommonSuperType(types, owner);
		if (superType instanceof WildcardTypeReference)
			return superType;
		if (superType == null) {
			return createObjectWildcardReference(owner);
		}
		if (superType instanceof UnboundTypeReference)
			return superType;
		if (allBoundNames.size() != allNames.size()) {
			if (allBoundNames.size() == 1 && allBoundNames.contains(getIdentifier(superType))) {
				return superType;
			}
		}
		WildcardTypeReference result = new WildcardTypeReference(owner);
		result.addUpperBound(superType.copyInto(owner));
		return result;
	}

	protected boolean isRecursiveRequest(List<LightweightTypeReference> types, Set<String> allNames, List<LightweightTypeReference> initiallyRequested) {
		if (types.size() < initiallyRequested.size()) {
			return false;
		}
		for(LightweightTypeReference initialRequest: initiallyRequested) {
			if (!allNames.contains(getIdentifier(initialRequest))) {
				return false;
			}
		}
		return true;
	}
	
	private void addIdentifier(LightweightTypeReference type, Set<String> allNames, Set<String> allBoundNames) {
		if (type instanceof UnboundTypeReference && !type.isResolved()) {
			allNames.add(((UnboundTypeReference) type).getHandle().toString());
		} else {
			String identifier = type.getJavaIdentifier();
			allNames.add(identifier);
			allBoundNames.add(identifier);
		}
	}
	
	private String getIdentifier(LightweightTypeReference type) {
		if (type instanceof UnboundTypeReference && !type.isResolved())
			return ((UnboundTypeReference) type).getHandle().toString();
		return type.getJavaIdentifier();
	}
	
	private LightweightTypeReference getMostSpecialTypeIfAllWildcards(List<LightweightTypeReference> types, ITypeReferenceOwner owner) {
		boolean objectIsCandidate = false;
		boolean lowerBoundSeen = false;
		for(LightweightTypeReference type: types) {
			if (type instanceof WildcardTypeReference) {
				if (((WildcardTypeReference) type).getLowerBound() == null) {
					objectIsCandidate = true;
				} else {
					lowerBoundSeen = true;
				}
			} else {
				return null;
			}
		}
		if (!lowerBoundSeen) {
			return null;
		}
		if (objectIsCandidate)
			return createObjectWildcardReference(owner);
		return getMostSpecialType(types);
	}
	
	public LightweightTypeReference getMostSpecialType(List<LightweightTypeReference> candidates) {
		LightweightTypeReference type;
		type = candidates.get(0).getLowerBoundSubstitute();
		for(int i = 1; i < candidates.size(); i++) {
			LightweightTypeReference candidate = candidates.get(i).getLowerBoundSubstitute();
			if (type.isAssignableFrom(candidate)) {
				type = candidate;
			} else if (!candidate.isAssignableFrom(type))
				return null;
		}
		return type;
	}
	
	protected void addComponentType(LightweightTypeReference reference, List<LightweightTypeReference> result) {
		if (reference.isArray()) {
			result.add(((ArrayTypeReference) reference).getComponentType());
		} else {
			result.add(reference);
		}
	}

	protected WildcardTypeReference createObjectWildcardReference(ITypeReferenceOwner owner) {
		JvmType objectType = owner.getServices().getTypeReferences().findDeclaredType(Object.class, owner.getContextResourceSet());
		ParameterizedTypeReference objectReference = new ParameterizedTypeReference(owner, objectType);
		WildcardTypeReference result = new WildcardTypeReference(owner);
		result.addUpperBound(objectReference);
		return result;
	}
	
	protected LightweightTypeReference conformsToAll(LightweightTypeReference type, List<LightweightTypeReference> types) {
		LightweightTypeReference result = type;
		for (int i = 0; i < types.size(); i++) {
			LightweightTypeReference other = types.get(i);
			if (result != other) {
				// if we stumble across unbound references without any hints, assume they are compatible and add respective hints
				int conformance = isConformant(result, other, ALLOW_BOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_FUNCTION_CONVERSION | UNBOUND_COMPUTATION_ADDS_HINTS | ALLOW_RAW_TYPE_CONVERSION);
				if ((conformance & SUCCESS) != 0) {
					boolean resultIsFunctionType = result instanceof FunctionTypeReference;
					if (!resultIsFunctionType && (other instanceof FunctionTypeReference) &&
							other.isAssignableFrom(result)) {
						result = other;
					}
				} else {
					return null;
				}
			}
			
		}
		return result;
	}
	
}