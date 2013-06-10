/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import static org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Booleans;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
public class TypeConformanceComputer {

	/**
	 * Indicates that the types should be checked as if they were raw types.
	 * 
	 * This bit will be set automatically if one of both types is actually a
	 * raw type and {@link #ALLOW_RAW_TYPE_CONVERSION} is set.
	 */
	public final static int RAW_TYPE = 1 << 0;
	
	/**
	 * Check for conformance as if the given types were used as type arguments.
	 * Type arguments have to be an exact type, e.g. they are not allowed to be in
	 * a subtype relationship, since {@code List<Object>} is not a supertype
	 * of {@code List<String>}, e.g. if used as type argument, {@code String}
	 * is not conformant to {@code Object}.
	 */
	public final static int AS_TYPE_ARGUMENT = RAW_TYPE << 1;
	
	/**
	 * Indicate whether raw type conformance has to be taken into account.
	 * Raw type conformance may not be considered for type arguments, e.g.
	 * {@code Class<? extends Map>} and {@code Class<? extends Map<String, String>>}
	 * are not conformant. 
	 */
	public final static int ALLOW_RAW_TYPE_CONVERSION = AS_TYPE_ARGUMENT << 1;
	
	/**
	 * If this bit is set, boxing and unboxing conversion may be applied to primitives
	 * and wrapper types.
	 */
	public final static int ALLOW_BOXING_UNBOXING = ALLOW_RAW_TYPE_CONVERSION << 1;
	
	/**
	 * Indicates that widening conversion may be taken into account.
	 */
	public final static int ALLOW_PRIMITIVE_WIDENING = ALLOW_BOXING_UNBOXING << 1;
	
	/**
	 * If otherwise unspecified {@link UnboundTypeReference unbound references} are given,
	 * the conformance check may alter the references and 
	 * {@link UnboundTypeReference#acceptHint(LightweightBoundTypeArgument) add hints}.
	 */
	public final static int UNBOUND_COMPUTATION_ADDS_HINTS = ALLOW_PRIMITIVE_WIDENING << 1;
	
	/**
	 * Set this bit if synonym types should be considered.
	 */
	public final static int ALLOW_SYNONYMS = UNBOUND_COMPUTATION_ADDS_HINTS << 1;
	
	/**
	 * This bit indicates a successful check for conformance.
	 */
	public final static int SUCCESS = ALLOW_SYNONYMS << 1;
	
	/**
	 * If the result has this bit set, a demand conversion had to be applied to make
	 * both types conformant. This is especially interesting for function types. 
	 * Also a {@link #SYNONYM} may require a demand conversion.
	 */
	public final static int DEMAND_CONVERSION = SUCCESS << 1;
	
	/**
	 * Indicates that both types are in a subtype relationship.
	 */
	public final static int SUBTYPE = DEMAND_CONVERSION << 1;
	
	/**
	 * This is set if primitive widening had to be applied.
	 */
	public final static int PRIMITIVE_WIDENING = SUBTYPE << 1;
	
	/**
	 * If unboxing conversion was necessary, this bit is set.
	 */
	public final static int UNBOXING = PRIMITIVE_WIDENING << 1;
	
	/**
	 * If boxing conversion was necessary, this bit is set.
	 */
	public final static int BOXING = UNBOXING << 1;
	
	/**
	 * This is set if the conformance was possible due to raw type conversion.
	 */
	public final static int RAW_TYPE_CONVERSION = BOXING << 1;
	
	/**
	 * If a synonym conversion was necessary, this bit is set in the result value.
	 */
	public final static int SYNONYM = RAW_TYPE_CONVERSION << 1;
	
	public boolean isConformant(LightweightTypeReference left, LightweightTypeReference right) {
		return (isConformant(left, right, ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_RAW_TYPE_CONVERSION) & SUCCESS) != 0;
	}
	
	public TypeConformanceResult isConformant(LightweightTypeReference left, LightweightTypeReference right, TypeConformanceComputationArgument argument) {
		int flags = ALLOW_RAW_TYPE_CONVERSION;
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
		int result = isConformant(left, right, flags);
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
		if ((result & SYNONYM) != 0) {
			resultFlags.add(ConformanceHint.SYNONYM);
		}
		return new TypeConformanceResult(resultFlags);
	}
	
	public int isConformant(LightweightTypeReference left, LightweightTypeReference right, int flags) {
		if (left == right && left != null) // TODO handle null
			return SUCCESS;
		if ((flags & RAW_TYPE) != 0 || ((left.isRawType() || right.isRawType()) && (flags & ALLOW_RAW_TYPE_CONVERSION) != 0)) {
			return doIsConformant(left.getRawTypeReference(), right.getRawTypeReference(), flags | RAW_TYPE);
		}
		return doIsConformant(left, right, flags);
	}
	
	public int doIsConformant(LightweightTypeReference left, LightweightTypeReference right, int flags) {
		int rightKind = right.getKind();
		switch(rightKind) {
			case KIND_UNKNOWN_TYPE_REFERENCE:
				return flags | SUCCESS;
			case KIND_UNBOUND_TYPE_REFERENCE: {
				UnboundTypeReference castedRight = (UnboundTypeReference) right;
				LightweightTypeReference resolved = castedRight.internalGetResolvedTo();
				if (resolved != null) {
					return doIsConformant(left, resolved, flags);
				}
				if (left.getKind() == KIND_UNBOUND_TYPE_REFERENCE) {
					UnboundTypeReference castedLeft = (UnboundTypeReference) left;
					LightweightTypeReference resolvedLeft = castedLeft.internalGetResolvedTo();
					if (resolvedLeft != null) {
						return doIsConformant(resolvedLeft, right, flags);
					}
					return doIsConformant((UnboundTypeReference) left, (UnboundTypeReference) right, flags);
				} else {
					return doIsConformant(left, (UnboundTypeReference) right, flags);
				}
			}
			case KIND_COMPOUND_TYPE_REFERENCE: {
				int leftKind = left.getKind();
				if (leftKind != KIND_UNBOUND_TYPE_REFERENCE && leftKind != KIND_COMPOUND_TYPE_REFERENCE) {
					for(LightweightTypeReference component: right.getMultiTypeComponents()) {
						int result = doIsConformant(left, component, flags);
						if ((result & SUCCESS) != 0) {
							return result;
						}
					}
					return flags;
				}
			}
			default: switch(left.getKind()) {
				case KIND_UNKNOWN_TYPE_REFERENCE: {
					return flags | SUCCESS;
				}
				case KIND_FUNCTION_TYPE_REFERENCE: {
					switch(rightKind) {
						case KIND_FUNCTION_TYPE_REFERENCE: {
							return doIsConformant((FunctionTypeReference)left, (FunctionTypeReference)right, flags);
						}
						case KIND_PARAMETERIZED_TYPE_REFERENCE: {
							return doIsConformant((FunctionTypeReference)left, (ParameterizedTypeReference)right, flags);
						}
					}
					// missing break is intentional
				}
				case KIND_PARAMETERIZED_TYPE_REFERENCE: {
					switch(rightKind) {
						case KIND_ARRAY_TYPE_REFERENCE: {
							return doIsConformant((ParameterizedTypeReference)left, (ArrayTypeReference)right, flags);
						}
						case KIND_FUNCTION_TYPE_REFERENCE: {
							return doIsConformant((ParameterizedTypeReference)left, (FunctionTypeReference)right, flags);
						}
						case KIND_PARAMETERIZED_TYPE_REFERENCE: {
							return doIsConformant((ParameterizedTypeReference)left, (ParameterizedTypeReference)right, flags);
						}
						case KIND_ANY_TYPE_REFERENCE: {
							return doIsConformantToAnyType((ParameterizedTypeReference)left, flags);
						}
						case KIND_WILDCARD_TYPE_REFERENCE: {
							return doIsConformant(left, (WildcardTypeReference) right, flags);
						}
					}
					return flags;
				}
				case KIND_ARRAY_TYPE_REFERENCE: {
					switch(rightKind) {
						case KIND_ARRAY_TYPE_REFERENCE: {
							return doIsConformant((ArrayTypeReference)left, (ArrayTypeReference)right, flags);
						}
						case KIND_FUNCTION_TYPE_REFERENCE:
						case KIND_PARAMETERIZED_TYPE_REFERENCE: {
							return doIsConformant((ArrayTypeReference)left, (ParameterizedTypeReference)right, flags);
						}
						case KIND_ANY_TYPE_REFERENCE: {
							return flags | SUCCESS;
						}
						case KIND_WILDCARD_TYPE_REFERENCE: {
							return doIsConformant(left, (WildcardTypeReference) right, flags);
						}
					}
					return flags;
				}
				case KIND_COMPOUND_TYPE_REFERENCE: {
					List<LightweightTypeReference> leftReferences = left.getMultiTypeComponents();
					if (leftReferences.isEmpty()) {
						if (left.isSynonym())
							return flags;
						return flags | SUCCESS;
					}
					int result = flags;
					for(LightweightTypeReference reference: leftReferences) {
						int componentResult = doIsConformant(reference, right, flags); 
						if ((componentResult & SUCCESS) != 0) {
							if (left.isSynonym()) {
								return componentResult;
							}
							result |= componentResult;
						} else if (!left.isSynonym()) {
							return flags;
						}
					}
					return result;
				}
				case KIND_ANY_TYPE_REFERENCE: {
					switch(rightKind) {
						case KIND_ANY_TYPE_REFERENCE:
							return flags | SUCCESS;
						case KIND_WILDCARD_TYPE_REFERENCE: {
							return doIsConformant(left, (WildcardTypeReference) right, flags);
						}
					}
					return flags;
					
				}
				case KIND_UNBOUND_TYPE_REFERENCE: {
					UnboundTypeReference castedLeft = (UnboundTypeReference) left;
					LightweightTypeReference resolvedLeft = castedLeft.internalGetResolvedTo();
					if (resolvedLeft != null) {
						return doIsConformant(resolvedLeft, right, flags);
					}
					switch(rightKind) {
						case KIND_ANY_TYPE_REFERENCE:
							return flags | SUCCESS;
						default: {
							return tryResolveAndCheckConformance(castedLeft, right, flags);
						}
					}
				}
				case KIND_WILDCARD_TYPE_REFERENCE: {
					switch(rightKind) {
						case KIND_WILDCARD_TYPE_REFERENCE: {
							return doIsConformant((WildcardTypeReference) left, (WildcardTypeReference) right, flags);
						}
						default: {
							return doIsConformant((WildcardTypeReference) left, right, flags);
						}
					}
				}
			}
		}
		return flags;
	}
	
	protected int doIsConformant(ParameterizedTypeReference left, ArrayTypeReference right, int flags) {
		if (left.isType(Object.class) || left.isType(Serializable.class) || left.isType(Cloneable.class)) {
			return flags | SUCCESS | SUBTYPE;
		}
		// Arrays are generally assignable to List and its supertypes
		if (left.isType(List.class) || left.isType(Collection.class) || left.isType(Iterable.class)) {
			List<LightweightTypeReference> arguments = left.getTypeArguments();
			if (arguments.isEmpty()) { // type argument is bound to Object
				return flags | SUCCESS | DEMAND_CONVERSION;
			}
			LightweightTypeReference componentType = getWrapperTypeIfPrimitive(right.getComponentType());
			int result = doIsConformant(arguments.get(0), componentType, flags);
			if ((result & SUCCESS) != 0) {
				return result | DEMAND_CONVERSION;
			}
		}
		return flags;
	}
	
	protected int doIsConformant(ArrayTypeReference left, ArrayTypeReference right, int flags) {
		LightweightTypeReference leftComponent = left.getComponentType();
		LightweightTypeReference rightComponent = right.getComponentType();
		return doIsConformant(leftComponent, rightComponent, flags & ~(ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS));
	}
	
	protected int doIsConformant(ArrayTypeReference left, ParameterizedTypeReference right, int flags) {
		if ((flags & AS_TYPE_ARGUMENT) == 0 && (flags & ALLOW_SYNONYMS) != 0) {
			ArrayTypeReference rightAsArray = right.tryConvertToArray();
			if (rightAsArray != null) {
				LightweightTypeReference leftComponent = getWrapperTypeIfPrimitive(left.getComponentType());
				LightweightTypeReference rightComponent = rightAsArray.getComponentType();
				int result = doIsConformant(leftComponent, rightComponent, flags & ~(ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS));
				if ((result & SUCCESS) != 0) {
					return result | DEMAND_CONVERSION | SYNONYM;
				}
			}
		}
		return flags;
	}
	
	protected int doIsConformant(LightweightTypeReference left, WildcardTypeReference right, int flags) {
		if ((flags & AS_TYPE_ARGUMENT) == 0) {
			for(LightweightTypeReference upperBound: right.getUpperBounds()) {
				int result = doIsConformant(left, upperBound, flags);
				if ((result & SUCCESS) != 0) {
					return result;
				}
			}
		}
		return flags;
	}
	
	protected int doIsConformant(WildcardTypeReference left, LightweightTypeReference right, int flags) {
		if ((flags & AS_TYPE_ARGUMENT) != 0) {
			LightweightTypeReference lowerBound = left.getLowerBound();
			if (lowerBound != null) {
				int result = doIsConformant(right, lowerBound, flags & ~(ALLOW_RAW_TYPE_CONVERSION | AS_TYPE_ARGUMENT | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS));
				if ((result & SUCCESS) == 0) {
					return result;
				}
			}
			for(LightweightTypeReference leftUpperBound: left.getUpperBounds()) {
				int result = doIsConformant(leftUpperBound, right, flags & ~(ALLOW_RAW_TYPE_CONVERSION | AS_TYPE_ARGUMENT | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS));
				if ((result & SUCCESS) == 0) {
					return result;
				}
			}
			return flags | SUCCESS | SUBTYPE;
		}
		return flags;
	}
	
	protected int doIsConformant(WildcardTypeReference left, WildcardTypeReference right, int flags) {
		if ((flags & AS_TYPE_ARGUMENT) != 0) {
			LightweightTypeReference leftLowerBound = left.getLowerBound();
			if (leftLowerBound != null) {
				LightweightTypeReference rightLowerBound = right.getLowerBound();
				if (rightLowerBound != null) {
					int result = doIsConformant(rightLowerBound, leftLowerBound, flags & ~(ALLOW_RAW_TYPE_CONVERSION | AS_TYPE_ARGUMENT | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS));
					return result;
				}
				return flags;
			}
			int rightIsSubtype = 0;
			for(LightweightTypeReference leftUpperBound: left.getUpperBounds()) {
				int result = doIsConformant(leftUpperBound, (LightweightTypeReference) right, flags & ~(ALLOW_RAW_TYPE_CONVERSION | AS_TYPE_ARGUMENT | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS));
				if ((result & SUCCESS) == 0) {
					return result;
				}
				rightIsSubtype = rightIsSubtype | (result & SUBTYPE);
			}
			return flags | SUCCESS | rightIsSubtype;
		}
		return flags;
	}
	
	protected int doIsConformantToAnyType(ParameterizedTypeReference left, int flags) {
		if (left.isPrimitive() || left.isPrimitiveVoid())
			return flags;
		return flags | SUCCESS;
	}

	protected int doIsConformant(LightweightTypeReference left, UnboundTypeReference right, int flags) {
		if (left.getType() == right.getType() || left.isType(Object.class)) {
			return flags | SUCCESS;
		}
		boolean doesNotHaveSignificantHints = false;
		if (right.canResolveTo(left) || (flags & AS_TYPE_ARGUMENT) != 0 && (doesNotHaveSignificantHints = !right.hasSignificantHints())) {
			if ((flags & UNBOUND_COMPUTATION_ADDS_HINTS) != 0 && doesNotHaveSignificantHints) {
				right.acceptHint(left, BoundTypeArgumentSource.INFERRED_LATER, left, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
			}
			return flags | SUCCESS;
		}
		right.tryResolve();
		LightweightTypeReference resolvedTo = right.getResolvedTo();
		if (resolvedTo != null) {
			return doIsConformant(left, resolvedTo, flags);
		}
		return flags;
	}
	
	protected int doIsConformant(UnboundTypeReference left, UnboundTypeReference right, int flags) {
		if (left.getHandle().equals(right.getHandle())) {
			return flags | SUCCESS;
		}
		List<LightweightBoundTypeArgument> leftHints = null; left.getAllHints();
		List<LightweightBoundTypeArgument> rightHints = null; right.getAllHints();
		if ((flags & UNBOUND_COMPUTATION_ADDS_HINTS) != 0) {
			leftHints = left.getAllHints();
			if (!leftHints.isEmpty() && left.hasSignificantHints(leftHints)) {
				rightHints = right.getAllHints();
				if (!rightHints.isEmpty() && right.hasSignificantHints(rightHints)) {
					left.acceptHint(right, BoundTypeArgumentSource.INFERRED, this, VarianceInfo.OUT, VarianceInfo.OUT);
					return flags | SUCCESS;
				}
			}
		}
		if (leftHints == null) {
			leftHints = left.getAllHints();
		}
		if (rightHints == null) {
			rightHints = right.getAllHints();
		}
		if (leftHints.equals(rightHints)) {
			return flags | SUCCESS;
		}
		return tryResolveAndCheckConformance(left, right, flags);
	}
	
	protected int tryResolveAndCheckConformance(UnboundTypeReference left, LightweightTypeReference right, int flags) {
		return tryResolveAndCheckConformance(left, left.getAllHints(), right, flags);
	}
	
	protected int tryResolveAndCheckConformance(
			UnboundTypeReference left,
			final List<LightweightBoundTypeArgument> leftHints,
			LightweightTypeReference right,
			int flags) {
		class Helper {
			final List<LightweightBoundTypeArgument> hintsToProcess;
			final List<LightweightBoundTypeArgument> inferredHintsToProcess;
			int laterCount = 0;
			boolean inferredAsWildcard = false;
			Helper(List<LightweightBoundTypeArgument> hints) {
				hintsToProcess = Lists.newArrayListWithCapacity(hints.size());
				inferredHintsToProcess = Lists.newArrayListWithCapacity(hints.size());
				for(LightweightBoundTypeArgument hint: hints) {
					if (hint.getDeclaredVariance() != null) {
						hintsToProcess.add(hint);
						if (hint.getSource() == BoundTypeArgumentSource.INFERRED) {
							if (hint.getTypeReference() instanceof WildcardTypeReference) {
								inferredAsWildcard = true;
							}
							inferredHintsToProcess.add(hint);
						} else if (hint.getSource() == BoundTypeArgumentSource.INFERRED_LATER) {
							laterCount++;
						}
					}
				}
			}
			
			private List<LightweightBoundTypeArgument> getHintsToMerge() {
				return inferredHintsToProcess.isEmpty() || (laterCount > 1 && inferredAsWildcard) ? hintsToProcess : inferredHintsToProcess;
			}
			
			@Nullable
			LightweightMergedBoundTypeArgument getMergeResult(UnboundTypeReference left) {
				BoundTypeArgumentMerger merger = left.getOwner().getServices().getBoundTypeArgumentMerger();
				if (inferredHintsToProcess.size() == 1) {
					LightweightBoundTypeArgument singleBoundArgument = inferredHintsToProcess.get(0);
					VarianceInfo varianceInfo = singleBoundArgument.getDeclaredVariance().mergeDeclaredWithActual(singleBoundArgument.getActualVariance());
					if (varianceInfo != null)
						return new LightweightMergedBoundTypeArgument(singleBoundArgument.getTypeReference(), varianceInfo);
				} 
				return merger.merge(getHintsToMerge(), left.getOwner());
			}
		}
		
		if (leftHints.isEmpty() && (flags & UNBOUND_COMPUTATION_ADDS_HINTS) == 0) {
			return flags; 
		}
		if (!left.isConformantToConstraints(right, leftHints)) {
			return flags;
		}
		Helper state = new Helper(leftHints);
		if (state.hintsToProcess.isEmpty() && (flags & UNBOUND_COMPUTATION_ADDS_HINTS) != 0) {
			return addHintAndAnnounceSuccess(left, right, flags);
		} else {
			LightweightMergedBoundTypeArgument mergeResult = state.getMergeResult(left);
			if (mergeResult != null && mergeResult.getVariance() != null) {
				return isConformantMergeResult(mergeResult, right, flags);
			}
		}
		return flags;
	}

	protected int addHintAndAnnounceSuccess(UnboundTypeReference left, LightweightTypeReference hint,
			int flags) {
		if (hint instanceof WildcardTypeReference) {
			List<LightweightTypeReference> bounds = ((WildcardTypeReference) hint).getUpperBounds();
			for(LightweightTypeReference upperBound: bounds)
				left.acceptHint(upperBound, BoundTypeArgumentSource.INFERRED, this, VarianceInfo.OUT, VarianceInfo.OUT);
		} else {
			left.acceptHint(hint, BoundTypeArgumentSource.INFERRED, this, VarianceInfo.OUT, VarianceInfo.OUT);
		}
		return flags | SUCCESS;
	}
	
	protected int isConformantMergeResult(LightweightMergedBoundTypeArgument mergeResult, LightweightTypeReference right,
			int flags) {
		LightweightTypeReference mergeResultReference = mergeResult.getTypeReference();
		if (right.isWildcard() && mergeResultReference.isWildcard()) {
			if (right.getLowerBoundSubstitute().isAny()) {
				LightweightTypeReference lowerBoundMergeResult = mergeResultReference.getLowerBoundSubstitute();
				if (!lowerBoundMergeResult.isAny()) {
					mergeResultReference = lowerBoundMergeResult;
				}
			} else {
				flags = flags | AS_TYPE_ARGUMENT;
			}
		} else if (mergeResultReference.isWildcard()) {
			flags = flags | AS_TYPE_ARGUMENT;
		}
		return isConformant(mergeResultReference, right, flags);
	}
	
	protected int doIsConformant(ParameterizedTypeReference left, FunctionTypeReference right, int flags) {
		// TODO don't convert if not necessary:
		// right.getType == left.getType -> doIsConformant optimized to function types -> declarator == procedure, ignore return type etc
		
		// next: get function type kind and arity of right and check against left if it is a function type
		// afterwards, do optimized check of left against the argument types of right
		FunctionTypeReference convertedLeft = left.getAsFunctionTypeReference();
		if (convertedLeft != null) {
			return doIsConformant(convertedLeft, right, flags);
		}
		if (right.isFunctionType()) {
			// todo optimize tryConvertToFunctionTypeReference
			convertedLeft = left.tryConvertToFunctionTypeReference(false);
			if (convertedLeft != null) {
				int result = doIsConformant(convertedLeft, right, flags);
				if ((result & SUCCESS) != 0) {
					return result | DEMAND_CONVERSION;
				}
			}
		}
		return doIsConformant(left, (ParameterizedTypeReference) right, flags);
	}
	
	protected int doIsConformant(FunctionTypeReference left, FunctionTypeReference right, int flags) {
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
		if (leftReturnType != rightReturnType && !leftIsVoid && (doIsConformant(leftReturnType, rightReturnType, flags & ~ALLOW_PRIMITIVE_WIDENING) & SUCCESS) == 0) {
			return flags;
		}
		for(int i = 0; i < leftParameterTypes.size(); i++) {
			LightweightTypeReference leftParameterType = leftParameterTypes.get(i);
			LightweightTypeReference rightParameterType = rightParameterTypes.get(i);
			if (leftParameterType!=rightParameterType && (leftParameterType == null || rightParameterType == null)) {
				return flags;
			}
			if ((doIsConformant(rightParameterType, leftParameterType, flags & ~ALLOW_PRIMITIVE_WIDENING) & SUCCESS) == 0) {
				return flags;
			} 
		}
		return flags | SUCCESS;
	}
	
	protected int doIsConformant(FunctionTypeReference left, ParameterizedTypeReference right, int flags) {
		FunctionTypeReference convertedRight = right.getAsFunctionTypeReference();
		if (convertedRight != null) {
			return doIsConformant(left, convertedRight, flags);
		}
		if (left.isFunctionType()) {
			convertedRight = right.tryConvertToFunctionTypeReference(false);
			if (convertedRight != null) {
				int result = doIsConformant(left, convertedRight, flags);
				if ((result & SUCCESS) != 0) {
					return result | DEMAND_CONVERSION;
				}
			}
		}
		return doIsConformant((ParameterizedTypeReference) left, right, flags);
	}
	
	protected int doIsConformant(ParameterizedTypeReference left, ParameterizedTypeReference right, int flags) {
		if (left.getType() == right.getType()) {
			return doIsConformantTypeArguments(left, right, flags);
		}
		if (left.isPrimitiveVoid() || right.isPrimitiveVoid()) {
			return flags;
		}
		if ((flags & (ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING)) != 0) {
			Primitive leftPrimitiveKind = getPrimitiveKind(left);
			if (leftPrimitiveKind != null) {
				Primitive rightPrimitiveKind = getPrimitiveKind(right);
				if (rightPrimitiveKind != null) {
					if ((flags & ALLOW_PRIMITIVE_WIDENING) != 0) {
						if (isWideningConversion(leftPrimitiveKind, rightPrimitiveKind)) {
							return flags | SUCCESS | PRIMITIVE_WIDENING;
						}
					}
				} else if ((flags & ALLOW_BOXING_UNBOXING) != 0) {
					rightPrimitiveKind = getPrimitiveKindFromWrapper(right);
					if (rightPrimitiveKind != null) {
						if (rightPrimitiveKind == leftPrimitiveKind || isWideningConversion(leftPrimitiveKind, rightPrimitiveKind)) {
							return flags | SUCCESS | UNBOXING;
						}
					}
				}
				if (!(right.getType().eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER))
					return flags;
			} else if ((flags & ALLOW_BOXING_UNBOXING) != 0) {
				Primitive rightPrimitiveKind = getPrimitiveKind(right);
				if (rightPrimitiveKind != null) {
					if (left.isType(Object.class)) {
						return flags | SUCCESS | BOXING;
					}
					if (left.isType(String.class)) {
						return flags;
					}
					LightweightTypeReference wrapper = getWrapperType(right, rightPrimitiveKind);
					int result = doIsConformant(left, (ParameterizedTypeReference) wrapper, flags);
					if ((result & SUCCESS) != 0)
						return result | BOXING;
					return flags;
				}
			}
		} else if (left.isPrimitive() || right.isPrimitive()) {
			return flags;
		}
		if ((flags & AS_TYPE_ARGUMENT) != 0)
			return flags;
		if (left.isType(Object.class)) {
			return flags | SUCCESS | SUBTYPE;
		}
		JvmType leftType = left.getType();
		JvmType rightType = right.getType();
		if (leftType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			JvmGenericType castedLeftType = (JvmGenericType) leftType;
			if (castedLeftType.isFinal()) {
				if (rightType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER && right.getSuperType(castedLeftType) != null) {
					return flags | SUCCESS | SUBTYPE;
				}
				return flags;
			}
			if (!castedLeftType.isInterface() && rightType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) rightType).isInterface()) {
				return flags;
			}
		} else if (leftType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			if (rightType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER && right.getSuperType(leftType) != null) {
				return flags | SUCCESS | SUBTYPE;
			}
			return flags;
		} else if (leftType.eClass() == TypesPackage.Literals.JVM_PRIMITIVE_TYPE) {
			leftType = getWrapperTypeIfPrimitive(left).getType();
		}
		ParameterizedTypeReference rightSuperType = (ParameterizedTypeReference) right.getSuperType(leftType);
		if (rightSuperType != null) {
			return doIsConformantTypeArguments(left, rightSuperType, flags); 
		}
		return isAssignableAsFunctionType(left, right, flags);
	}
	
	protected int isAssignableAsFunctionType(ParameterizedTypeReference left,
			ParameterizedTypeReference right, int flags) {
		// TODO only if flags allow conversion, e.g. not AS_TYPE_ARGUMENT or better javaConformance?
		FunctionTypeReference leftFunctionType = left.getAsFunctionTypeReference();
		if (leftFunctionType != null) {
			FunctionTypeReference rightFunctionType = right.getAsFunctionTypeReference();
			if (rightFunctionType != null) {
				return flags;
			}
			rightFunctionType = right.tryConvertToFunctionTypeReference(false);
			if (rightFunctionType != null) {
				int result = doIsConformant(leftFunctionType, rightFunctionType, flags);
				if ((result & SUCCESS) != 0) {
					return result | DEMAND_CONVERSION;
				}
			}
		} else {
			FunctionTypeReference rightFunctionType = right.getAsFunctionTypeReference();
			if (rightFunctionType != null) {
				leftFunctionType = left.tryConvertToFunctionTypeReference(false);
				if (leftFunctionType != null) {
					int result = doIsConformant(leftFunctionType, rightFunctionType, flags);
					if ((result & SUCCESS) != 0) {
						return result | DEMAND_CONVERSION;
					}
				}
			}
		}
		return flags;
	}
	
	private boolean isWideningConversion(Primitive leftPrimitiveKind, Primitive rightPrimitiveKind) {
		switch (rightPrimitiveKind) {
			case Byte :
				switch (leftPrimitiveKind) { 
					case Void:
					case Byte:
						return false;
					default:
						return true;
				}
			case Short :
			case Char :
				switch (leftPrimitiveKind) { 
					case Void:
					case Byte:
					case Short:
					case Char:
						return false;
					default:
						return true;
				}
			case Int :
				switch (leftPrimitiveKind) { 
					case Long:
					case Float:
					case Double:
						return true;
					default:
						return false;
				}
			case Long :
				switch (leftPrimitiveKind) { 
					case Float:
					case Double:
						return true;
					default:
						return false;
				}
			case Float :
				return leftPrimitiveKind == Primitive.Double;
			default :
				return false;
		}
	}
	
	protected LightweightTypeReference getWrapperTypeIfPrimitive(LightweightTypeReference type) {
		Primitive primitiveKind = getPrimitiveKind(type);
		return getWrapperType(type, primitiveKind);
	}

	protected LightweightTypeReference getWrapperType(LightweightTypeReference type, Primitive primitiveKind) {
		if (primitiveKind != null) {
			switch(primitiveKind) {
				case Boolean:
					return findTopLevelType(type, "java.lang.Boolean");
				case Byte:
					return findTopLevelType(type, "java.lang.Byte");
				case Char:
					return findTopLevelType(type, "java.lang.Character");
				case Double:
					return findTopLevelType(type, "java.lang.Double");
				case Float:
					return findTopLevelType(type, "java.lang.Float");
				case Int:
					return findTopLevelType(type, "java.lang.Integer");
				case Long:
					return findTopLevelType(type, "java.lang.Long");
				case Short:
					return findTopLevelType(type, "java.lang.Short");
				case Void:
					return findTopLevelType(type, "java.lang.Void");
			}
		}
		return type;
	}

	private LightweightTypeReference findTopLevelType(LightweightTypeReference typeReference, String typeName) {
		ITypeReferenceOwner owner = typeReference.getOwner();
		ResourceSet resourceSet = owner.getContextResourceSet();
		Resource typeResource = resourceSet.getResource(URIHelperConstants.OBJECTS_URI.appendSegment(typeName), true);
		JvmType type = (JvmType) typeResource.getContents().get(0);
		if (type == null)
			return typeReference;
		return new ParameterizedTypeReference(owner, type);
	}

	protected Primitive getPrimitiveKind(LightweightTypeReference reference) {
		JvmType type = reference.getType();
		if (type.eIsProxy())
			return null;
		if (type.eClass() == TypesPackage.Literals.JVM_PRIMITIVE_TYPE) {
			String name = type.getSimpleName();
			if ("boolean".equals(name)) {
				return Primitive.Boolean;
			} else if ("int".equals(name)) {
				return Primitive.Int;
			} else if ("long".equals(name)) {
				return Primitive.Long;
			} else if ("double".equals(name)) {
				return Primitive.Double;
			} else if ("char".equals(name)) {
				return Primitive.Char;
			} else if ("byte".equals(name)) {
				return Primitive.Byte;
			} else if ("short".equals(name)) {
				return Primitive.Short;
			} else if ("float".equals(name)) {
				return Primitive.Float;
			}
		} else if (type.eClass() == TypesPackage.Literals.JVM_VOID) {
			return Primitive.Void;
		}
		return null;
	}
	
	protected Primitive getPrimitiveKindFromWrapper(LightweightTypeReference reference) {
		JvmType type = reference.getType();
		if (type.eIsProxy())
			return null;
		if (type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			String name = type.getIdentifier();
			if ("java.lang.Boolean".equals(name)) {
				return Primitive.Boolean;
			} else if ("java.lang.Integer".equals(name)) {
				return Primitive.Int;
			} else if ("java.lang.Long".equals(name)) {
				return Primitive.Long;
			} else if ("java.lang.Double".equals(name)) {
				return Primitive.Double;
			} else if ("java.lang.Character".equals(name)) {
				return Primitive.Char;
			} else if ("java.lang.Byte".equals(name)) {
				return Primitive.Byte;
			} else if ("java.lang.Short".equals(name)) {
				return Primitive.Short;
			} else if ("java.lang.Float".equals(name)) {
				return Primitive.Float;
			} else if ("java.lang.Void".equals(name)) {
				return Primitive.Void;
			}
		}
		return null;
	}
	
	protected int doIsConformantTypeArguments(ParameterizedTypeReference left, ParameterizedTypeReference right, int flags) {
		List<LightweightTypeReference> leftTypeArguments = left.getTypeArguments();
		List<LightweightTypeReference> rightTypeArguments = right.getTypeArguments();
		int size = leftTypeArguments.size();
		if (size == rightTypeArguments.size()) {
			int argumentFlags = (flags | AS_TYPE_ARGUMENT) & ~(ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_RAW_TYPE_CONVERSION);  
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
	
	
	/**
	 * Compute the common super type for the given types.
	 * 
	 * May return <code>null</code> in case one of the types is primitive void but not all 
	 * of them are.
	 */
	@Nullable
	public LightweightTypeReference getCommonSuperType(final @NonNull List<LightweightTypeReference> types, ITypeReferenceOwner owner) {
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
								TypeConformanceComputer.RAW_TYPE | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_RAW_TYPE_CONVERSION) & SUCCESS) != 0) {
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
	@NonNullByDefault
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
				result.add(getWrapperTypeIfPrimitive(type));
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
		for(int i = 0; i < types.size(); i++) {
			LightweightTypeReference type = types.get(i).getInvariantBoundSubstitute();
			types.set(i, type);
			addIdentifier(type, allNames, allBoundNames);
		}
		if (allNames.size() == 1)
			return types.get(0);
		if (types.size() == initiallyRequested.size()) {
			boolean containsAll = true;
			for(LightweightTypeReference initialRequest: initiallyRequested) {
				if (!allNames.contains(getIdentifier(initialRequest))) {
					containsAll = false;
					break;
				}
			}
			// recursive request - return object wildcard
			if (containsAll) {
				return createObjectWildcardReference(owner);
			}
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
				// if we stumble accross unbound references without any hints, assume they are compatible and add respective hints
				int conformance = isConformant(result, other, ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | UNBOUND_COMPUTATION_ADDS_HINTS | ALLOW_RAW_TYPE_CONVERSION);
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