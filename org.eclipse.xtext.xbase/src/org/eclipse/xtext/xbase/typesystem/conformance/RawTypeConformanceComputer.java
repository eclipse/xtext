/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import static org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.internal.util.WrapperTypeLookup;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.InnerFunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.InnerTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Implements conversion on the raw type level. The implementation provides hooks that are
 * specialized by the {@link TypeConformanceComputer} which will also check the type arguments.
 * 
 * This architecture was chosen to avoid yet more conditions in the implementation of the
 * type conformance check. It allows to dispatch early to the raw type check or the
 * complete check based on the flags rather than probing this all the time in the implementation.
 * 
 * @author Sebastian Zarnekow
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@Singleton
public class RawTypeConformanceComputer {
	
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
	 * is not compatible to {@code Object}.
	 */
	public final static int AS_TYPE_ARGUMENT = RAW_TYPE << 1;
	
	/**
	 * Indicate whether raw type conformance has to be taken into account.
	 * Raw type conformance may not be considered for type arguments, e.g.
	 * {@code Class<? extends Map>} and {@code Class<? extends Map<String, String>>}
	 * are not compatible. 
	 */
	public final static int ALLOW_RAW_TYPE_CONVERSION = AS_TYPE_ARGUMENT << 1;
	
	/**
	 * If this bit is set, boxing conversion may be applied to primitives
	 * and wrapper types.
	 */
	public final static int ALLOW_BOXING = ALLOW_RAW_TYPE_CONVERSION << 1;
	
	/**
	 * If this bit is set, unboxing conversion may be applied to primitives
	 * and wrapper types.
	 */
	public final static int ALLOW_UNBOXING = ALLOW_BOXING << 1;
	
	/**
	 * If this bit is set, boxing and unboxing conversion may be applied to primitives
	 * and wrapper types.
	 */
	public final static int ALLOW_BOXING_UNBOXING = ALLOW_BOXING | ALLOW_UNBOXING;
	
	/**
	 * Indicates that widening conversion may be taken into account.
	 */
	public final static int ALLOW_PRIMITIVE_WIDENING = ALLOW_UNBOXING << 1;
	
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
	 * Set this bit if synonym types should be considered.
	 */
	public final static int ALLOW_FUNCTION_CONVERSION = ALLOW_SYNONYMS << 1;
	
	/**
	 * This bit indicates a successful check for conformance.
	 */
	public final static int SUCCESS = ALLOW_FUNCTION_CONVERSION << 1;
	
	/**
	 * If the result has this bit set, a demand conversion had to be applied to make
	 * both types compatible. This is especially interesting for function types. 
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
	
	/**
	 * If one of the compared types was an unknown type, this bit is set in the result value.
	 */
	public final static int UNKNOWN_TYPE_PARTICIPATED = SYNONYM << 1;
	
	public final static int INCOMPATIBLE = UNKNOWN_TYPE_PARTICIPATED << 1;
	
	/**
	 * Check for conformance as if the given types were used as type arguments of type arguments.
	 * E.g. an {@code Iterable<Iterable<?>>} is not assignable from {@code Iterable<Iterable<? extends CharSequence>>}.
	 * The usage of the nested type argument is honored by this bit.
	 */
	public final static int AS_NESTED_TYPE_ARGUMENT = INCOMPATIBLE << 1;

	private SynonymTypesProvider synonymTypesProvider;
	/**
	 * This is to avoid unnecessary expensive, redundant conversion in case the default
	 * synonym types are used.
	 */
	private boolean useCustomSynonymTypes = false;
	
	@Inject
	public void setSynonymTypesProvider(SynonymTypesProvider synonymTypesProvider) {
		this.synonymTypesProvider = synonymTypesProvider;
		useCustomSynonymTypes = !synonymTypesProvider.getClass().equals(SynonymTypesProvider.class); 
	}

	public int isConformant(final LightweightTypeReference left, LightweightTypeReference right, final int flags) {
		if (left == right && left != null) // TODO handle null
			return flags | SUCCESS;
		int result = doIsConformant(left, right, flags);
		result = isSynonymConformant(result, left, right, flags);
		if ((result & SUCCESS) == 0)
			result |= INCOMPATIBLE;
		return result & ~AS_NESTED_TYPE_ARGUMENT;
	}

	protected int isSynonymConformant(int originalConformance, final LightweightTypeReference left, LightweightTypeReference right, final int flags) {
		if (useCustomSynonymTypes && (originalConformance & SUCCESS) == 0 && (flags & ALLOW_SYNONYMS) != 0) {
			final int[] resultFromSynonyms = new int[] { originalConformance };
			synonymTypesProvider.collectSynonymTypes(right, new SynonymTypesProvider.Acceptor() {
				@Override
				protected boolean accept(/* @NonNull */ LightweightTypeReference synonym, int synonymFlags) {
					if ((synonymFlags & (ConformanceFlags.BOXING | ConformanceFlags.UNBOXING)) == 0) {
						int synonymResult = isConformant(left, synonym, flags & ~ALLOW_SYNONYMS);
						if ((synonymResult & SUCCESS) != 0) {
							resultFromSynonyms[0] = synonymResult | synonymFlags | ConformanceFlags.SYNONYM;
							return false;
						}
					}
					return true;
				}
			});
			return resultFromSynonyms[0];
		}
		return originalConformance;
	}
	
	protected int doIsConformant(LightweightTypeReference left, LightweightTypeReference right, int flags) {
		int rightKind = right.getKind();
		switch(rightKind) {
			case KIND_UNKNOWN_TYPE_REFERENCE:
				return flags | SUCCESS | UNKNOWN_TYPE_PARTICIPATED;
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
						return doIsConformant(resolvedLeft, castedRight, flags);
					}
					return doIsConformant((UnboundTypeReference) left, castedRight, flags);
				} else {
					return doIsConformant(left, castedRight, flags);
				}
			}
			case KIND_COMPOUND_TYPE_REFERENCE: {
				int leftKind = left.getKind();
				if (leftKind != KIND_UNBOUND_TYPE_REFERENCE && leftKind != KIND_COMPOUND_TYPE_REFERENCE && leftKind != KIND_WILDCARD_TYPE_REFERENCE) {
					for(LightweightTypeReference component: right.getMultiTypeComponents()) {
						int result = doIsConformant(left, component, flags);
						if ((result & SUCCESS) != 0) {
							return result;
						}
					}
					return flags;
				}
				// missing break is intentional
			}
			default: switch(left.getKind()) {
				case KIND_UNKNOWN_TYPE_REFERENCE: {
					return flags | SUCCESS | UNKNOWN_TYPE_PARTICIPATED;
				}
				case KIND_INNER_FUNCTION_TYPE_REFERENCE: {
					switch(rightKind) {
						case KIND_INNER_TYPE_REFERENCE:
							return doIsConformant((InnerFunctionTypeReference)left, (InnerTypeReference)right, flags);
						case KIND_INNER_FUNCTION_TYPE_REFERENCE:
							return doIsConformant((InnerFunctionTypeReference)left, (InnerFunctionTypeReference)right, flags);
					}
					// missing break is intentional
				}
				case KIND_FUNCTION_TYPE_REFERENCE: {
					switch(rightKind) {
						case KIND_FUNCTION_TYPE_REFERENCE: {
							return doIsConformant((FunctionTypeReference)left, (FunctionTypeReference)right, flags);
						}
						case KIND_INNER_TYPE_REFERENCE:
						case KIND_PARAMETERIZED_TYPE_REFERENCE: {
							return doIsConformant((FunctionTypeReference)left, (ParameterizedTypeReference)right, flags);
						}
						case KIND_ARRAY_TYPE_REFERENCE: {
							return doIsConformant((ParameterizedTypeReference)left, (ArrayTypeReference)right, flags);
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
				case KIND_INNER_TYPE_REFERENCE: {
					switch(rightKind) {
						case KIND_INNER_TYPE_REFERENCE:
							return doIsConformant((InnerTypeReference)left, (InnerTypeReference)right, flags);
						case KIND_INNER_FUNCTION_TYPE_REFERENCE:
							return doIsConformant((InnerTypeReference)left, (InnerFunctionTypeReference)right, flags);
					}
				}
				case KIND_PARAMETERIZED_TYPE_REFERENCE: {
					switch(rightKind) {
						case KIND_ARRAY_TYPE_REFERENCE: {
							return doIsConformant((ParameterizedTypeReference)left, (ArrayTypeReference)right, flags);
						}
						case KIND_INNER_FUNCTION_TYPE_REFERENCE:
						case KIND_FUNCTION_TYPE_REFERENCE: {
							return doIsConformant((ParameterizedTypeReference)left, (FunctionTypeReference)right, flags);
						}
						case KIND_INNER_TYPE_REFERENCE:
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
		if ((flags & ALLOW_SYNONYMS) != 0) {
			// Arrays are generally assignable to List and its supertypes
			if (left.isType(List.class) || left.isType(Collection.class) || left.isType(Iterable.class)) {
				List<LightweightTypeReference> arguments = left.getTypeArguments();
				if (arguments.isEmpty()) { // type argument is bound to Object
					return flags | SUCCESS | DEMAND_CONVERSION;
				}
				LightweightTypeReference componentType = right.getComponentType().getWrapperTypeIfPrimitive();
				int result = doIsConformant(arguments.get(0).getInvariantBoundSubstitute(), componentType, flags);
				if ((result & SUCCESS) != 0) {
					return result | DEMAND_CONVERSION;
				}
			}
		}
		return flags;
	}
	
	
	protected int doIsConformant(ArrayTypeReference left, ArrayTypeReference right, int flags) {
		LightweightTypeReference leftComponent = left.getComponentType();
		LightweightTypeReference rightComponent = right.getComponentType();
		return doIsConformant(leftComponent, rightComponent, flags & ~(ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION));
	}
	
	protected int doIsConformant(ArrayTypeReference left, ParameterizedTypeReference right, int flags) {
		if ((flags & AS_TYPE_ARGUMENT) == 0 && (flags & ALLOW_SYNONYMS) != 0) {
			ArrayTypeReference rightAsArray = right.tryConvertToArray();
			if (rightAsArray != null) {
				LightweightTypeReference leftComponent = left.getComponentType().getWrapperTypeIfPrimitive();
				LightweightTypeReference rightComponent = rightAsArray.getComponentType();
				int result = doIsConformant(leftComponent, rightComponent, flags & ~(ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION));
				if ((result & SUCCESS) != 0) {
					return result | DEMAND_CONVERSION | SYNONYM;
				}
			}
		}
		return flags;
	}
	
	protected int doIsConformant(LightweightTypeReference left, WildcardTypeReference right, int flags) {
		if ((flags & AS_TYPE_ARGUMENT) == 0 || (flags & AS_NESTED_TYPE_ARGUMENT) != 0) {
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
		if ((flags & AS_TYPE_ARGUMENT) != 0 || (flags & AS_NESTED_TYPE_ARGUMENT) != 0) {
			LightweightTypeReference lowerBound = left.getLowerBound();
			if (lowerBound != null) {
				int newFlags = flags & ~(ALLOW_RAW_TYPE_CONVERSION | AS_TYPE_ARGUMENT | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION);
				if ((newFlags & AS_NESTED_TYPE_ARGUMENT) != 0) {
					newFlags |= AS_TYPE_ARGUMENT;
				}
				if (right.isRawType()) {
					newFlags |= ALLOW_RAW_TYPE_CONVERSION;
				}
				int result = doIsConformant(right, lowerBound, newFlags);
				if ((result & SUCCESS) == 0) {
					return result;
				}
			}
			for(LightweightTypeReference leftUpperBound: left.getUpperBounds()) {
				int newFlags = flags & ~(ALLOW_RAW_TYPE_CONVERSION | AS_TYPE_ARGUMENT | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION);
				if ((newFlags & AS_NESTED_TYPE_ARGUMENT) != 0) {
					newFlags |= AS_TYPE_ARGUMENT;
				}
				if (leftUpperBound.isRawType()) {
					newFlags |= ALLOW_RAW_TYPE_CONVERSION;
				}
				int result = doIsConformant(leftUpperBound, right, newFlags);
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
					int newFlags = flags & ~(ALLOW_RAW_TYPE_CONVERSION | AS_TYPE_ARGUMENT | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION);
					if ((newFlags & AS_NESTED_TYPE_ARGUMENT) != 0) {
						newFlags |= AS_TYPE_ARGUMENT;
					}
					if (rightLowerBound.isRawType()) {
						newFlags |= ALLOW_RAW_TYPE_CONVERSION;
					}
					int result = doIsConformant(rightLowerBound, leftLowerBound, newFlags);
					return result;
				}
				return flags;
			}
			int subtypeOrRawConversion = 0;
			for(LightweightTypeReference leftUpperBound: left.getUpperBounds()) {
				int newFlags = flags & ~(ALLOW_RAW_TYPE_CONVERSION | AS_TYPE_ARGUMENT | ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION);
				if ((newFlags & AS_NESTED_TYPE_ARGUMENT) != 0) {
					newFlags |= AS_TYPE_ARGUMENT;
				}
				if (leftUpperBound.isRawType()) {
					newFlags |= ALLOW_RAW_TYPE_CONVERSION;
				}
				int result = doIsConformant(leftUpperBound, (LightweightTypeReference) right, newFlags);
				if ((result & SUCCESS) == 0) {
					return result;
				}
				subtypeOrRawConversion = subtypeOrRawConversion | (result & (SUBTYPE | RAW_TYPE_CONVERSION));
			}
			return flags | SUCCESS | subtypeOrRawConversion;
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
		if ((flags & ALLOW_UNBOXING) == 0 && left.isPrimitive()) {
			return flags;
		}
		boolean doesNotHaveSignificantHints = false;
		if (((flags & RAW_TYPE) == 0) && (right.canResolveTo(left) || (flags & AS_TYPE_ARGUMENT) != 0 && (doesNotHaveSignificantHints = !right.hasSignificantHints()))) {
			if ((flags & UNBOUND_COMPUTATION_ADDS_HINTS) != 0 && doesNotHaveSignificantHints) {
				right.acceptHint(left, BoundTypeArgumentSource.INFERRED_LATER, left, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
			}
			return flags | SUCCESS;
		}
		right.tryResolve(false);
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
		List<LightweightBoundTypeArgument> leftHints = left.getAllHints();
		List<LightweightBoundTypeArgument> rightHints = right.getAllHints();
		if ((flags & UNBOUND_COMPUTATION_ADDS_HINTS) != 0) {
			if (leftHints.isEmpty() || rightHints.isEmpty() || !left.hasSignificantHints(leftHints) || !right.hasSignificantHints()) {
				left.acceptHint(right, BoundTypeArgumentSource.INFERRED, this, VarianceInfo.OUT, VarianceInfo.OUT);
				return flags | SUCCESS;
			}
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
			
			/* @Nullable */
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
		if (isConstrainedRecursiveHintCheck(leftHints, right)) {
			return flags | SUCCESS;
		}
		int result = isConformantToConstraints(left, right, leftHints, 
				flags & ~(AS_TYPE_ARGUMENT | ALLOW_PRIMITIVE_WIDENING | ALLOW_SYNONYMS | ALLOW_FUNCTION_CONVERSION));
		if ((result & SUCCESS) == 0) {
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
	
	private boolean isConstrainedRecursiveHintCheck(List<LightweightBoundTypeArgument> leftHints, LightweightTypeReference right) {
		boolean hasConstraints = false;
		for(LightweightBoundTypeArgument leftHint: leftHints) {
			if (leftHint.getSource() == BoundTypeArgumentSource.CONSTRAINT) {
				hasConstraints = true;
			}
			if (leftHint.getSource() == BoundTypeArgumentSource.INFERRED_LATER && leftHint.getActualVariance() == VarianceInfo.INVARIANT) {
				if (!hasConstraints) {
					return false;
				}
				LightweightTypeReference leftHintReference = leftHint.getTypeReference();
				if (leftHintReference.getUniqueIdentifier().equals(right.getUniqueIdentifier())) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected int isConformantToConstraints(
			final UnboundTypeReference left, 
			final LightweightTypeReference right, 
			List<LightweightBoundTypeArgument> leftHints, 
			int flags) {
		int result = flags;
		for(LightweightBoundTypeArgument leftHint: leftHints) {
			if (leftHint.getSource() == BoundTypeArgumentSource.CONSTRAINT) {
				final LightweightTypeReference leftHintReference = leftHint.getTypeReference();
				if (!leftHintReference.getUniqueIdentifier().equals(right.getUniqueIdentifier())) {
					final LightweightMergedBoundTypeArgument rightTypeArgument = new LightweightMergedBoundTypeArgument(right.getWrapperTypeIfPrimitive(), VarianceInfo.INVARIANT);
					final UnboundTypeParameterPreservingSubstitutor unboundSubstitutor = new UnboundTypeParameterPreservingSubstitutor(
							Collections.singletonMap(left.getTypeParameter(), rightTypeArgument), right.getOwner()) {
						@Override
						public LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference, Set<JvmTypeParameter> visiting) {
							if (reference.getHandle() == left.getHandle()) {
								if (right.getKind() == KIND_UNBOUND_TYPE_REFERENCE) {
									UnboundTypeReference rightUnbound = (UnboundTypeReference) right;
									List<LightweightBoundTypeArgument> rightHints = rightUnbound.getAllHints();
									for(LightweightBoundTypeArgument rightHint: rightHints) {
										LightweightTypeReference rightHintReference = rightHint.getTypeReference();
										if (rightHintReference != null && leftHintReference.getUniqueIdentifier().equals(rightHintReference.getUniqueIdentifier())) {
											return super.doVisitUnboundTypeReference(reference, visiting);
										}
									}
								}
								return rightTypeArgument.getTypeReference();
							}
							return super.doVisitUnboundTypeReference(reference, visiting);
						}
					};
					LightweightTypeReference constraintReference = unboundSubstitutor.substitute(leftHintReference);
					int constraintResult = doIsConformant(constraintReference, right, flags);
					if ((constraintResult & SUCCESS) == 0) {
						return flags;
					}
					result |= constraintResult;
				}
			}
		}
		return result | SUCCESS;
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
		if ((flags & ALLOW_FUNCTION_CONVERSION) == 0)
			return doIsConformant(left, (ParameterizedTypeReference) right, flags);
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
		if (left.getType() == right.getType()) {
			return flags | SUCCESS;
		}
		if ((flags & ALLOW_FUNCTION_CONVERSION) == 0)
			return flags;
		// function types can be converted to native function types which will be raw assignable if their
		// number of parameters matches and the function type kind
		if (left.getParameterTypes().size() == right.getParameterTypes().size()) {
			LightweightTypeReference leftReturnType = left.getReturnType();
			LightweightTypeReference rightReturnType = right.getReturnType();
			if (leftReturnType == rightReturnType) {
				return flags | SUCCESS;
			}
			if (leftReturnType != null && rightReturnType != null && leftReturnType.isPrimitiveVoid() == rightReturnType.isPrimitiveVoid()) {
				return flags | SUCCESS; 
			}
		}
		return flags;
	}
	
	protected int doIsConformant(FunctionTypeReference left, ParameterizedTypeReference right, int flags) {
		if ((flags & ALLOW_FUNCTION_CONVERSION) == 0)
			return doIsConformant((ParameterizedTypeReference) left, right, flags);
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
	
	protected int doIsConformant(InnerFunctionTypeReference left, InnerFunctionTypeReference right, int flags) {
		int result = doIsConformant((FunctionTypeReference) left, (FunctionTypeReference) right, flags);
		return doIsConformantOuter(left, right, result, flags);
	}
	
	protected int doIsConformant(InnerFunctionTypeReference left, InnerTypeReference right, int flags) {
		int result = doIsConformant((FunctionTypeReference) left, (ParameterizedTypeReference) right, flags);
		return doIsConformantOuter(left, right, result, flags);
	}

	protected int doIsConformant(InnerTypeReference left, InnerFunctionTypeReference right, int flags) {
		int result = doIsConformant((ParameterizedTypeReference) left, (FunctionTypeReference) right, flags);
		return doIsConformantOuter(left, right, result, flags);
	}
	
	protected int doIsConformant(InnerTypeReference left, InnerTypeReference right, int flags) {
		int result = doIsConformant((ParameterizedTypeReference) left, (ParameterizedTypeReference) right, flags);
		return doIsConformantOuter(left, right, result, flags);
	}
	
	protected int doIsConformantOuter(LightweightTypeReference left, LightweightTypeReference right, int nestedResult, int flags) {
		if ((nestedResult & SUCCESS) != 0) {
			JvmType leftType = left.getType();
			EObject leftDeclarator = leftType.eContainer();
			if (leftDeclarator instanceof JvmDeclaredType) {
				JvmDeclaredType castedLeftDeclarator = (JvmDeclaredType) leftDeclarator;
				LightweightTypeReference leftOuter = left.getOuter().getSuperType(castedLeftDeclarator);
				if (leftOuter != null) {
					LightweightTypeReference rightOuter = right.getOuter().getSuperType(castedLeftDeclarator);
					if (rightOuter != null) {
						int outerResult = doIsConformant(leftOuter, rightOuter, flags);
						if ((outerResult & SUCCESS) == 0) {
							return outerResult;
						}
					}
				}
			}
		}
		return nestedResult;
	}
	
	protected int doIsConformant(ParameterizedTypeReference left, ParameterizedTypeReference right, int flags) {
		if (left.getType() == right.getType()) {
			if ((flags & AS_TYPE_ARGUMENT) != 0) {
				flags |= AS_NESTED_TYPE_ARGUMENT;
			}
			return doIsConformantTypeArguments(left, right, flags);
		}
		if (left.isPrimitiveVoid() || right.isPrimitiveVoid()) {
			return flags;
		}
		if ((flags & (ALLOW_BOXING_UNBOXING | ALLOW_PRIMITIVE_WIDENING)) != 0) {
			int leftPrimitiveKind = internalGetPrimitiveKind(left);
			if (leftPrimitiveKind != PRIMITIVE_NONE) {
				int rightPrimitiveKind = internalGetPrimitiveKind(right);
				if (rightPrimitiveKind != PRIMITIVE_NONE) {
					if ((flags & ALLOW_PRIMITIVE_WIDENING) != 0) {
						if (isWideningConversion(leftPrimitiveKind, rightPrimitiveKind)) {
							return flags | SUCCESS | PRIMITIVE_WIDENING;
						}
					}
				} else if ((flags & ALLOW_UNBOXING) != 0) {
					rightPrimitiveKind = internalGetPrimitiveKindFromWrapper(right);
					if (rightPrimitiveKind != PRIMITIVE_NONE) {
						if (rightPrimitiveKind == leftPrimitiveKind || isWideningConversion(leftPrimitiveKind, rightPrimitiveKind)) {
							return flags | SUCCESS | UNBOXING;
						}
					}
				}
				if (!(right.getType().eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER))
					return flags;
			} else if ((flags & ALLOW_BOXING) != 0) {
				Primitive rightPrimitiveKind = right.getPrimitiveKind();
				if (rightPrimitiveKind != null) {
					if (left.isType(Object.class)) {
						return flags | SUCCESS | BOXING;
					}
					if (left.isType(String.class)) {
						return flags;
					}
					LightweightTypeReference wrapper = WrapperTypeLookup.getWrapperType(right, rightPrimitiveKind);
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
		EClass leftEClass = leftType.eClass();
		if (leftEClass == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			JvmGenericType castedLeftType = (JvmGenericType) leftType;
			EClass rightEClass = rightType.eClass();
			if (castedLeftType.isFinal()) {
				if (rightEClass == TypesPackage.Literals.JVM_TYPE_PARAMETER && getSuperType(right, castedLeftType) != null) {
					return flags | SUCCESS | SUBTYPE;
				}
				return flags;
			}
			if (!castedLeftType.isInterface() && rightEClass == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) rightType).isInterface()) {
				return flags;
			}
		} else if (leftEClass == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			if (rightType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER && getSuperType(right, leftType) != null) {
				return flags | SUCCESS | SUBTYPE;
			}
			return flags;
		}
		ParameterizedTypeReference rightSuperType = (ParameterizedTypeReference) getSuperType(right, leftType);
		if (rightSuperType != null) {
			int result = doIsConformantTypeArguments(left, rightSuperType, flags);
			if ((result & SUCCESS) != 0) {
				return result | SUBTYPE;
			}
			return result;
		}
		return isAssignableAsFunctionType(left, right, flags);
	}
	
	protected int isAssignableAsFunctionType(ParameterizedTypeReference left,
			ParameterizedTypeReference right, int flags) {
		if ((flags & ALLOW_FUNCTION_CONVERSION) == 0)
			return flags;
		FunctionTypeReference leftFunctionType = left.getAsFunctionTypeReference();
		if (leftFunctionType != null) {
			FunctionTypeReference rightFunctionType = right.getAsFunctionTypeReference();
			if (rightFunctionType != null) {
				return flags;
			}
			rightFunctionType = right.tryConvertToFunctionTypeReference((flags & RAW_TYPE) != 0);
			if (rightFunctionType != null) {
				int result = doIsConformant(leftFunctionType, rightFunctionType, flags);
				if ((result & SUCCESS) != 0) {
					return result | DEMAND_CONVERSION;
				}
			}
		} else {
			FunctionTypeReference rightFunctionType = right.getAsFunctionTypeReference();
			if (rightFunctionType != null) {
				leftFunctionType = left.tryConvertToFunctionTypeReference((flags & RAW_TYPE) != 0);
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
	
	private static final int PRIMITIVE_NONE = -1;
	private static final int PRIMITIVE_BOOLEAN = 0;
	private static final int PRIMITIVE_INT = 1;
	private static final int PRIMITIVE_LONG = 2;
	private static final int PRIMITIVE_DOUBLE = 3;
	private static final int PRIMITIVE_CHAR = 4;
	private static final int PRIMITIVE_BYTE = 5;
	private static final int PRIMITIVE_SHORT = 6;
	private static final int PRIMITIVE_FLOAT = 7;
	private static final int PRIMITIVE_VOID = 8;
	
	private int internalGetPrimitiveKind(ParameterizedTypeReference typeReference) {
		JvmType type = typeReference.getType();
		EClass eClass = type.eClass();
		if (eClass == TypesPackage.Literals.JVM_PRIMITIVE_TYPE) {
			if (type.eIsProxy())
				return PRIMITIVE_NONE;
			String name = type.getSimpleName();
			switch (name.length()) {
				case 3:
					if ("int".equals(name)) {
						return PRIMITIVE_INT;
					}
					break;
				case 4:
					if ("long".equals(name)) {
						return PRIMITIVE_LONG;
					} else if ("char".equals(name)) {
						return PRIMITIVE_CHAR;
					} else if ("byte".equals(name)) {
						return PRIMITIVE_BYTE;
					}
					break;
				case 5:
					if ("short".equals(name)) {
						return PRIMITIVE_SHORT;
					} else if ("float".equals(name)) {
						return PRIMITIVE_FLOAT;
					}
					break;
				case 6:
					if ("double".equals(name)) {
						return PRIMITIVE_DOUBLE;
					}
					break;
				case 7:
					if ("boolean".equals(name)) {
						return PRIMITIVE_BOOLEAN;
					}
					break;
			}
		} else if (eClass == TypesPackage.Literals.JVM_VOID) {
			if (type.eIsProxy())
				return PRIMITIVE_NONE;
			return PRIMITIVE_VOID;
		}
		return PRIMITIVE_NONE;
	}
	
	private int internalGetPrimitiveKindFromWrapper(ParameterizedTypeReference typeReference) {
		JvmType type = typeReference.getType();
		if (type == null || type.eIsProxy()) {
			return PRIMITIVE_NONE; 
		}
		EClass eClass = type.eClass();
		if (eClass != TypesPackage.Literals.JVM_GENERIC_TYPE) {
			if (eClass == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
				return internalGetPrimitiveKindFromWrapper((JvmTypeParameter)type, null);
			}
			return PRIMITIVE_NONE;
		}
		return internalGetPrimitiveKindFromWrapper((JvmGenericType)type);
	}

	protected int internalGetPrimitiveKindFromWrapper(JvmGenericType type) {
		String name = type.getIdentifier();
		switch (name.length()) {
			case 17:
				if ("java.lang.Integer".equals(name)) {
					return PRIMITIVE_INT;
				} else if ("java.lang.Boolean".equals(name)) {
					return PRIMITIVE_BOOLEAN;
				}
				break;
			case 14:
				if ("java.lang.Long".equals(name)) {
					return PRIMITIVE_LONG;
				} else if ("java.lang.Byte".equals(name)) {
					return PRIMITIVE_BYTE;
				} else if ("java.lang.Void".equals(name)) {
					return PRIMITIVE_VOID;
				}
				break;
			case 15:
				if ("java.lang.Short".equals(name)) {
					return PRIMITIVE_SHORT;
				} else if ("java.lang.Float".equals(name)) {
					return PRIMITIVE_FLOAT;
				}
				break;
			case 16:
				if ("java.lang.Double".equals(name)) {
					return PRIMITIVE_DOUBLE;
				}
				break;
			case 19:
				if ("java.lang.Character".equals(name)) {
					return PRIMITIVE_CHAR;
				}
				break;
		}
		return PRIMITIVE_NONE;
	}
	
	/* @Nullable */
	private int internalGetPrimitiveKindFromWrapper(JvmTypeParameter type, /* @Nullable */ RecursionGuard<JvmTypeParameter> guard) {
		if (type.eIsProxy())
			return PRIMITIVE_NONE;
		for(JvmTypeConstraint constraint: type.getConstraints()) {
			if (constraint.eClass() == TypesPackage.Literals.JVM_UPPER_BOUND) {
				JvmTypeReference upperBound = constraint.getTypeReference();
				if (upperBound != null) {
					JvmType upperBoundType = upperBound.getType();
					if (upperBoundType == null) {
						return PRIMITIVE_NONE;
					}
					EClass eClass = upperBoundType.eClass();
					if (eClass == TypesPackage.Literals.JVM_GENERIC_TYPE) {
						return internalGetPrimitiveKindFromWrapper((JvmGenericType) upperBoundType);
					}
					if (type == upperBoundType) {
						return PRIMITIVE_NONE;
					}
					// guard against recursive deps
					if (eClass == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
						JvmTypeParameter upperBoundTypeParameter = (JvmTypeParameter) upperBoundType;
						if (guard == null) {
							guard = new RecursionGuard<JvmTypeParameter>();
							guard.tryNext(type);
						}
						if (guard.tryNext(upperBoundTypeParameter)) {
							return internalGetPrimitiveKindFromWrapper(upperBoundTypeParameter, guard);
						}
						return PRIMITIVE_NONE;
					}
				}
			}
		}
		return PRIMITIVE_NONE;
	}
	
	private boolean isWideningConversion(int leftPrimitiveKind, int rightPrimitiveKind) {
		switch (rightPrimitiveKind) {
			case PRIMITIVE_BYTE :
				switch (leftPrimitiveKind) {
					case PRIMITIVE_BOOLEAN:
					case PRIMITIVE_VOID:
					case PRIMITIVE_BYTE:
						return false;
					default:
						return true;
				}
			case PRIMITIVE_SHORT :
			case PRIMITIVE_CHAR :
				switch (leftPrimitiveKind) { 
					case PRIMITIVE_BOOLEAN:
					case PRIMITIVE_VOID:
					case PRIMITIVE_BYTE:
					case PRIMITIVE_SHORT:
					case PRIMITIVE_CHAR:
						return false;
					default:
						return true;
				}
			case PRIMITIVE_INT :
				switch (leftPrimitiveKind) { 
					case PRIMITIVE_LONG:
					case PRIMITIVE_FLOAT:
					case PRIMITIVE_DOUBLE:
						return true;
					default:
						return false;
				}
			case PRIMITIVE_LONG :
				switch (leftPrimitiveKind) { 
					case PRIMITIVE_FLOAT:
					case PRIMITIVE_DOUBLE:
						return true;
					default:
						return false;
				}
			case PRIMITIVE_FLOAT :
				return leftPrimitiveKind == PRIMITIVE_DOUBLE;
			default :
				return false;
		}
	}
	
	/**
	 * This is a hook for the {@link TypeConformanceComputer} to implement the type argument check.
	 */
	protected int doIsConformantTypeArguments(LightweightTypeReference left, LightweightTypeReference right, int flags) {
		if (left.isRawType() != right.isRawType()) {
			return flags | SUCCESS | RAW_TYPE_CONVERSION;	
		}
		return flags | SUCCESS;
	}
	
	/**
	 * This is a hook for the {@link TypeConformanceComputer} to provide the resolved super type.
	 */
	protected LightweightTypeReference getSuperType(ParameterizedTypeReference current, JvmType type) {
		return current.getRawSuperType(type);
	}
	
}
