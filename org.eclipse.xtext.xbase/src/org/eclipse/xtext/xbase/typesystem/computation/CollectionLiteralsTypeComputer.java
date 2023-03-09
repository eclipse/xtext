/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

import com.google.common.collect.Lists;

/**
 * Utility that helps to compute the type for collection literals.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class CollectionLiteralsTypeComputer extends AbstractTypeComputer {

	/**
	 * Entry point from the {@link XbaseTypeComputer}.
	 */
	public void computeType(XSetLiteral literal, ITypeComputationState state) {
		JvmGenericType setType = findDeclaredType(Set.class, state);
		if (setType == null) {
			handleCollectionTypeNotAvailable(literal, state, Set.class);
			return;
		}
		JvmGenericType mapType = findDeclaredType(Map.class, state);
		for(ITypeExpectation expectation: state.getExpectations()) {
			computeType(literal, setType, mapType, expectation, state);
		}
	}
	
	/**
	 * Entry point from the {@link XbaseTypeComputer}.
	 */
	public void computeType(XListLiteral literal, ITypeComputationState state) {
		JvmGenericType listType = findDeclaredType(List.class, state);
		if (listType == null) {
			handleCollectionTypeNotAvailable(literal, state, List.class);
			return;
		}
		for(ITypeExpectation expectation: state.getExpectations()) {
			computeType(literal, listType, expectation, state);
		}
	}
	
	/**
	 * Specializes the super implementation such that is allows an empty list of types.
	 * Returns {@code null} for those.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected LightweightTypeReference getCommonSuperType(List<LightweightTypeReference> types, ITypeComputationState state) {
		if (types.isEmpty()) {
			return null;
		}
		LightweightTypeReference result = super.getCommonSuperType(types, state);
		return result;
	}

	protected void computeType(XSetLiteral literal, JvmGenericType setType, JvmGenericType mapType, ITypeExpectation expectation, ITypeComputationState state) {
		LightweightTypeReference elementTypeExpectation = null;
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if(expectedType != null) {
			elementTypeExpectation = getElementOrComponentType(expectedType, state);
		}
		List<LightweightTypeReference> setTypeCandidates = computeCollectionTypeCandidates(literal, setType, elementTypeExpectation, state);
		LightweightTypeReference commonSetType = getCommonSuperType(setTypeCandidates, state);
		ITypeReferenceOwner owner = state.getReferenceOwner();
		if(commonSetType != null) {
			LightweightTypeReference commonElementType = commonSetType.getTypeArguments().get(0).getInvariantBoundSubstitute();
			if(isMapLiteral(expectedType, commonElementType)) {
				LightweightTypeReference mapTypeReference = createMapTypeReference(mapType, commonElementType, expectedType, owner);
				expectation.acceptActualType(mapTypeReference, ConformanceFlags.UNCHECKED);
				commonElementType = createNormalizedPairType(commonElementType, mapTypeReference, owner);
				refineElementTypeExpectation(literal, commonElementType, state);
			} else {
				commonElementType = normalizeElementType(commonElementType, expectedType, owner);
				if (expectedType != null) {
					commonSetType = createCollectionTypeReference(setType, commonElementType, expectedType, owner);
				}
				expectation.acceptActualType(commonSetType, ConformanceFlags.UNCHECKED);
				refineElementTypeExpectation(literal, commonElementType, state);
			}
		} else {
			if(isMapExpectation(expectedType)) {
				ParameterizedTypeReference unboundCollectionType = owner.newParameterizedTypeReference(mapType);
				unboundCollectionType.addTypeArgument(expectation.createUnboundTypeReference(literal, mapType.getTypeParameters().get(0)));
				unboundCollectionType.addTypeArgument(expectation.createUnboundTypeReference(literal, mapType.getTypeParameters().get(1)));
				expectation.acceptActualType(unboundCollectionType, ConformanceFlags.UNCHECKED);
			} else {
				setUnboundCollectionType(literal, setType, expectation, elementTypeExpectation, state);
			}
		}
	}

	protected void setUnboundCollectionType(XCollectionLiteral literal, JvmGenericType collectionType, ITypeExpectation expectation,
			LightweightTypeReference elementTypeExpectation, ITypeComputationState state) {
		ParameterizedTypeReference unboundCollectionType = state.getReferenceOwner().newParameterizedTypeReference(collectionType);
		if (elementTypeExpectation != null) {
			unboundCollectionType.addTypeArgument(elementTypeExpectation);
		} else {
			UnboundTypeReference unboundTypeArgument = expectation.createUnboundTypeReference(literal, collectionType.getTypeParameters().get(0));
			unboundCollectionType.addTypeArgument(unboundTypeArgument);
		}
		expectation.acceptActualType(unboundCollectionType, ConformanceFlags.UNCHECKED);
	}

	protected void refineElementTypeExpectation(XCollectionLiteral literal, LightweightTypeReference expectation, ITypeComputationState state) {
		for (XExpression element : literal.getElements()) {
			state.refineExpectedType(element, expectation);
		}
	}

	protected boolean isMapLiteral(LightweightTypeReference expectation, LightweightTypeReference elementType) {
		if (isIterableExpectation(expectation)) {
			return false;
		}
		return elementType.isType(Pair.class) && elementType.getTypeArguments().size() == 2;
	}

	protected boolean isMapExpectation(LightweightTypeReference expectation) {
		return isExpectedType(expectation, Map.class);
	}

	protected void computeType(XListLiteral literal, JvmGenericType listType, ITypeExpectation expectation,
			ITypeComputationState state) {
		LightweightTypeReference elementTypeExpectation = null;
		final LightweightTypeReference expectedType = expectation.getExpectedType();
		if(expectedType != null) {
			if(expectedType.isArray()) {
				computeArrayLiteralType(literal, expectedType, expectation, state);
				return; 
			} 
			elementTypeExpectation = getElementOrComponentType(expectedType, state);
		}
		List<LightweightTypeReference> listTypeCandidates = computeCollectionTypeCandidates(literal, listType, elementTypeExpectation, state);
		LightweightTypeReference commonListType = getCommonSuperType(listTypeCandidates, state);
		if (commonListType != null) {
			LightweightTypeReference commonElementType = getElementOrComponentType(commonListType, state);
			ITypeReferenceOwner owner = state.getReferenceOwner();
			commonElementType = normalizeElementType(commonElementType, expectedType, owner);
			if (expectedType != null) {
				commonListType = createCollectionTypeReference(listType, commonElementType, expectedType, owner);
			}
			expectation.acceptActualType(commonListType, ConformanceFlags.UNCHECKED);
			refineElementTypeExpectation(literal, commonElementType, state);
		} else {
			setUnboundCollectionType(literal, listType, expectation, elementTypeExpectation, state);
		}
	}

	protected void computeArrayLiteralType(XListLiteral literal, LightweightTypeReference expectedArrayType, ITypeExpectation expectation,
			ITypeComputationState state) {
		LightweightTypeReference elementTypeExpectation = getElementOrComponentType(expectedArrayType, state);
		int allFlags = 0;
		for(XExpression element: literal.getElements()) {
			ITypeComputationResult elementTypeResult = computeTypes(element, elementTypeExpectation, state);
			deferredBindTypeArgument(elementTypeExpectation, elementTypeResult.getActualExpressionType(), state);
			allFlags |= elementTypeResult.getCheckedConformanceFlags();
		}
		if ((allFlags & ConformanceFlags.INCOMPATIBLE) != 0) {
			allFlags &= (~ConformanceFlags.SUCCESS);
			allFlags |= ConformanceFlags.SEALED | ConformanceFlags.CHECKED | ConformanceFlags.PROPAGATED_TYPE;
			expectation.acceptActualType(expectedArrayType, allFlags);
		} else if ((allFlags & ConformanceFlags.SUCCESS) != 0) {
			allFlags |= ConformanceFlags.SEALED | ConformanceFlags.CHECKED;
			expectation.acceptActualType(expectedArrayType, allFlags);
		} else {
			expectation.acceptActualType(expectedArrayType, ConformanceFlags.CHECKED_SUCCESS | ConformanceFlags.SEALED);
		}
	}

	protected ITypeComputationResult computeTypes(XExpression element, LightweightTypeReference expectation, ITypeComputationState state) {
		ITypeComputationResult elementTypeResult = expectation != null
				? state.withExpectation(expectation).computeTypes(element)
				: state.withNonVoidExpectation().computeTypes(element);
		return elementTypeResult;
	}

	/**
	 * Process all children and assign an unknown type to the literal. 
	 */
	protected void handleCollectionTypeNotAvailable(XCollectionLiteral literal, ITypeComputationState state, Class<?> clazz) {
		for(XExpression element: literal.getElements()) {
			state.withNonVoidExpectation().computeTypes(element);
		}
		state.acceptActualType(state.getReferenceOwner().newUnknownTypeReference(clazz.getName()));
	}

	/**
	 * The map type may be constructed from different pairs, e.g. the pair's type arguments don't need to be as strict
	 * as the map suggests. The pair's expectation is adjusted accordingly.
	 */
	protected LightweightTypeReference createNormalizedPairType(LightweightTypeReference pairType, LightweightTypeReference mapType, ITypeReferenceOwner owner) {
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, pairType.getType());
		LightweightTypeReference keyType = mapType.getTypeArguments().get(0);
		if (keyType.getKind() != LightweightTypeReference.KIND_WILDCARD_TYPE_REFERENCE) {
			WildcardTypeReference wc = new WildcardTypeReference(owner);
			wc.addUpperBound(keyType);
			keyType = wc;
		}
		LightweightTypeReference valueType = mapType.getTypeArguments().get(1);
		if (valueType.getKind() != LightweightTypeReference.KIND_WILDCARD_TYPE_REFERENCE) {
			WildcardTypeReference wc = new WildcardTypeReference(owner);
			wc.addUpperBound(valueType);
			valueType = wc;
		}
		result.addTypeArgument(keyType);
		result.addTypeArgument(valueType);
		return result;
	}

	/**
	 * Creates a collection type reference that comes as close as possible / necessary to its expected type.
	 */
	protected LightweightTypeReference createCollectionTypeReference(JvmGenericType collectionType, LightweightTypeReference elementType, LightweightTypeReference expectedType, ITypeReferenceOwner owner) {
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, collectionType);
		result.addTypeArgument(elementType);
		if (isIterableExpectation(expectedType) && !expectedType.isAssignableFrom(result)) {
			// avoid to assign a set literal to a list and viceversa:
			// at least the raw types must be assignable
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=498779
			if (expectedType.getRawTypeReference().isAssignableFrom(result.getRawTypeReference())) {
				LightweightTypeReference expectedElementType = getElementOrComponentType(expectedType, owner);
				if (matchesExpectation(elementType, expectedElementType)) {
					return expectedType;
				}
			}
		}
		return result;
	}

	/**
	 * Creates a map type reference that comes as close as possible / necessary to its expected type.
	 */
	protected LightweightTypeReference createMapTypeReference(JvmGenericType mapType, LightweightTypeReference pairType, LightweightTypeReference expectation, ITypeReferenceOwner owner) {
		List<LightweightTypeReference> leftAndRight = pairType.getTypeArguments();
		
		LightweightTypeReference left = leftAndRight.get(0).getInvariantBoundSubstitute();
		LightweightTypeReference right = leftAndRight.get(1).getInvariantBoundSubstitute();
		
		LightweightTypeReference mapExpectation = getMapExpectation(expectation);
		if (mapExpectation != null) {
			List<LightweightTypeReference> typeArguments = expectation.getTypeArguments();
			left = doNormalizeElementType(left, typeArguments.get(0));
			right = doNormalizeElementType(right, typeArguments.get(1));
		}
		ParameterizedTypeReference result = owner.newParameterizedTypeReference(mapType);
		result.addTypeArgument(left.copyInto(owner));
		result.addTypeArgument(right.copyInto(owner));
		if (mapExpectation != null && !expectation.isAssignableFrom(result)) {
			// expectation does not match the computed type, but looks good according to the element types:
			// use expected type
			if (matchesExpectation(left, mapExpectation.getTypeArguments().get(0)) && matchesExpectation(right, mapExpectation.getTypeArguments().get(1))) {
				return expectation;
			}
		}
		return result;
	}

	/**
	 * Implements fall-back strategy. If the expected type of a collection literal does not match the actual type, but the expected element
	 * types would match the actual element type, the collection literal will be successfully typed according to the expectation.
	 */
	protected boolean matchesExpectation(LightweightTypeReference elementType, LightweightTypeReference expectation) {
		return expectation != null && expectation.isResolved() && !expectation.isWildcard() && expectation.isAssignableFrom(elementType);
	}

	/**
	 * If the expected type is a subtype of {@link Map}, the resolved super type is returned.
	 * This allows to query for the type arguments that are available on the expectation.
	 */
	protected LightweightTypeReference getMapExpectation(LightweightTypeReference expectation) {
		if (expectation != null && expectation.isResolved()) {
			LightweightTypeReference result = expectation.getSuperType(Map.class);
			if (result != null && result.getTypeArguments().size() == 2) {
				return result;
			}
		}
		return null;
	}

	/**
	 * The expected collection type may drive the type of the elements in the collection if the type is used as an
	 * invariant type. In other word, an expectation of the form
	 * {@code Collection<CharSequence>} may yield a type {@code List<CharSequence>} for the literal
	 * {@code ['a']} even though it would be {@code List<? extends String>} if no expectation was given.
	 */
	protected LightweightTypeReference normalizeElementType(LightweightTypeReference collectionElementType, LightweightTypeReference expectedCollectionType, ITypeReferenceOwner owner) {
		if (isIterableExpectation(expectedCollectionType)) {
			LightweightTypeReference expectedElementType = getElementOrComponentType(expectedCollectionType, owner);
			return doNormalizeElementType(collectionElementType, expectedElementType);
		}
		return normalizeFunctionTypeReference(collectionElementType);
	}

	protected boolean isIterableExpectation(LightweightTypeReference expectation) {
		return isExpectedType(expectation, Iterable.class);
	}

	protected boolean isExpectedType(LightweightTypeReference expectation, Class<?> clazz) {
		if (expectation != null) {
			if (expectation.isResolved() && isSubtypeButNotSynonym(expectation, clazz)) {
				return true;
			}
			if (expectation instanceof UnboundTypeReference) {
				if (expectation.getOwner().newParameterizedTypeReference(((UnboundTypeReference) expectation).getTypeParameter()).isSubtypeOf(clazz)) {
					return true;
				}
				List<LightweightBoundTypeArgument> hints = ((UnboundTypeReference) expectation).getAllHints();
				for(LightweightBoundTypeArgument hint: hints) {
					LightweightTypeReference hintReference = hint.getTypeReference();
					if (hintReference != null && isSubtypeButNotSynonym(hintReference, clazz)) {
						return true;
					}
				}
			} else if (expectation instanceof ParameterizedTypeReference) {
				return isSubtypeButNotSynonym(expectation, clazz);
			}
		}
		return false;
	}

	/**
	 * Same as {@link LightweightTypeReference#isSubtypeOf(Class)} but does not accept synonym types as subtypes.
	 */
	protected boolean isSubtypeButNotSynonym(LightweightTypeReference expectation, Class<?> clazz) {
		if (expectation.isType(clazz)) {
			return true;
		}
		ITypeReferenceOwner owner = expectation.getOwner();
		JvmType declaredType = owner.getServices().getTypeReferences().findDeclaredType(clazz, owner.getContextResourceSet());
		if (declaredType == null) {
			return false;
		}
		LightweightTypeReference superType = owner.newParameterizedTypeReference(declaredType);
		// don't allow synonyms, e.g. Iterable is not considered to be a supertype of Functions.Function0
		boolean result = superType.isAssignableFrom(expectation.getRawTypeReference(), 
				new TypeConformanceComputationArgument(false, false, true, true, false, false));
		return result;
	}

	/**
	 * A function type reference may be known to have the type argument {@link Number} but still use a more
	 * specific return type {@link Integer}. Normalization converts such a reference to the return type {@link Number}.
	 */
	protected LightweightTypeReference normalizeFunctionTypeReference(LightweightTypeReference type) {
		if (type.getKind() == LightweightTypeReference.KIND_FUNCTION_TYPE_REFERENCE) {
			ParameterizedTypeReference parameterized = new ParameterizedTypeReference(type.getOwner(), type.getType());
			for(LightweightTypeReference argument: type.getTypeArguments()) {
				parameterized.addTypeArgument(argument);
			}
			type = parameterized.tryConvertToFunctionTypeReference(false);
		}
		return type;
	}

	/**
	 * If the expected type is not a wildcard, it may supersede the actual element type.
	 */
	protected LightweightTypeReference doNormalizeElementType(LightweightTypeReference actual, LightweightTypeReference expected) {
		if (matchesExpectation(actual, expected)) {
			return expected;
		}
		return normalizeFunctionTypeReference(actual);
	}

	/**
	 * Creates a list of collection type references from the element types of a collection literal.
	 */
	protected List<LightweightTypeReference> computeCollectionTypeCandidates(XCollectionLiteral literal, JvmGenericType collectionType, LightweightTypeReference elementTypeExpectation, ITypeComputationState state) {
		List<XExpression> elements = literal.getElements();
		if(!elements.isEmpty()) {
			List<LightweightTypeReference> elementTypes = Lists.newArrayListWithCapacity(elements.size());
			for(XExpression element: elements) {
				ITypeComputationResult elementType = computeTypes(element, elementTypeExpectation, state);
				LightweightTypeReference actualType = elementType.getActualExpressionType();
				if(actualType != null && !actualType.isAny()) {
					ParameterizedTypeReference collectionTypeCandidate = state.getReferenceOwner().newParameterizedTypeReference(collectionType);
					collectionTypeCandidate.addTypeArgument(actualType.getWrapperTypeIfPrimitive());
					elementTypes.add(collectionTypeCandidate);
				}
			}
			return elementTypes;
		}
		return Collections.emptyList();
	}
	
	/* @Nullable */
	protected LightweightTypeReference getElementOrComponentType(LightweightTypeReference iterableOrArray, ITypeComputationState state) {
		return getElementOrComponentType(iterableOrArray, state.getReferenceOwner());
	}
	
	/**
	 * Delegates to {@link ElementOrComponentTypeComputer#compute(LightweightTypeReference, ITypeReferenceOwner)}.
	 * Clients may override.
	 */
	/* @Nullable */
	protected LightweightTypeReference getElementOrComponentType(LightweightTypeReference iterableOrArray, ITypeReferenceOwner owner) {
		return ElementOrComponentTypeComputer.compute(iterableOrArray, owner);
	}

}
