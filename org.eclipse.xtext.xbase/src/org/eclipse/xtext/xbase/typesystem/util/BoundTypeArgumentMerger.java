/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString, performance, noise in the gc
 */
@Singleton
public class BoundTypeArgumentMerger {
	
	@Inject
	private TypeConformanceComputer conformanceComputer;
	
	/* @Nullable */
	public LightweightMergedBoundTypeArgument merge(Collection<LightweightBoundTypeArgument> allArguments, ITypeReferenceOwner owner) {
		if (allArguments.isEmpty())
			return null;
		if (allArguments.size() == 1) {
			LightweightBoundTypeArgument argument = Iterables.getOnlyElement(allArguments);
			return getSingleArgumentAsMergedArgument(argument);
		}
		List<LightweightTypeReference> invariantTypes = Lists.newArrayListWithCapacity(0);
		List<VarianceInfo> invariantVariances = Lists.newArrayListWithCapacity(0);
		List<LightweightTypeReference> invariantTypesFromOut = Lists.newArrayListWithCapacity(0);
		List<VarianceInfo> invariantVariancesFromOut = Lists.newArrayListWithCapacity(0);
		List<LightweightTypeReference> outTypes = Lists.newArrayListWithCapacity(0);
		List<LightweightTypeReference> constraintOutTypes = Lists.newArrayListWithCapacity(0);
		List<VarianceInfo> outVariances = Lists.newArrayListWithCapacity(0);
		List<LightweightTypeReference> inTypes = Lists.newArrayListWithCapacity(0);
		List<VarianceInfo> inVariances = Lists.newArrayListWithCapacity(0);
		Set<Object> seenOrigin = Sets.newHashSet();
		for(LightweightBoundTypeArgument boundTypeArgument: allArguments) {
			Object origin = boundTypeArgument.getOrigin();
			switch(boundTypeArgument.getDeclaredVariance()) {
				case INVARIANT:
					processBoundTypeArgument(boundTypeArgument, invariantTypes, invariantVariances, origin, seenOrigin);
					break;
				case OUT:
					BoundTypeArgumentSource source = boundTypeArgument.getSource();
					if (invariantTypes.isEmpty() && isTransitiveHintFromReslved(boundTypeArgument, origin, source)) {
						invariantTypesFromOut.add(boundTypeArgument.getTypeReference());
						if (seenOrigin.add(origin)) {
							invariantVariancesFromOut.add(VarianceInfo.INVARIANT);
						}
					} 
					if (source == BoundTypeArgumentSource.CONSTRAINT) {
						constraintOutTypes.add(boundTypeArgument.getTypeReference());
					} else {
						outTypes.add(boundTypeArgument.getTypeReference());
					}
					addVariance(boundTypeArgument, outVariances, origin, seenOrigin);
					break;
				case IN:
					processBoundTypeArgument(boundTypeArgument, inTypes, inVariances, origin, seenOrigin);
					break;
			}
		}
		LightweightTypeReference type = null;
		VarianceInfo variance = null;
		if (outTypes.isEmpty() && inTypes.isEmpty()) {
			outTypes = constraintOutTypes;
		}
		if (!invariantTypes.isEmpty()) {
			type = invariantTypes.get(0);
			variance = VarianceInfo.INVARIANT.mergeDeclaredWithActuals(invariantVariances);
			if (variance == null && invariantVariances.contains(VarianceInfo.IN) && invariantTypes.size() > 1) {
				type = getCommonSuperTypes(invariantTypes, owner);
			} else if (!invariantTypesFromOut.isEmpty()) {
				LightweightTypeReference fromOut = invariantTypesFromOut.get(0);
				if (fromOut.isAssignableFrom(type)) {
					type = fromOut;
					variance = VarianceInfo.INVARIANT;
				}
			}
			if (!outVariances.isEmpty()) {
				VarianceInfo outVariance = VarianceInfo.OUT.mergeDeclaredWithActuals(outVariances);
				variance = VarianceInfo.OUT.mergeInvariance(variance, outVariance);
			} else if (!inVariances.isEmpty()) {
				VarianceInfo inVariance = VarianceInfo.IN.mergeDeclaredWithActuals(inVariances);
				variance = VarianceInfo.IN.mergeInvariance(variance, inVariance);
			}
		} else if (!outTypes.isEmpty()) {
			type = getCommonSuperTypes(outTypes, owner);
			variance = VarianceInfo.OUT.mergeDeclaredWithActuals(outVariances);
			if (!inVariances.isEmpty()) {
				LightweightTypeReference inType = getMostSpecialType(inTypes);
				boolean conformant = type.isAssignableFrom(inType, new TypeConformanceComputationArgument(false, true, false, false, true, false));
				if (conformant) {
					VarianceInfo inVariance = VarianceInfo.IN.mergeDeclaredWithActuals(inVariances);
					variance = VarianceInfo.IN.mergeWithOut(variance, inVariance, conformant);
				} else {
					boolean reverseConformant = inType.isAssignableFrom(type, new TypeConformanceComputationArgument(false, false, false, false, true, false));
					if (reverseConformant && variance == VarianceInfo.INVARIANT && VarianceInfo.IN.mergeDeclaredWithActuals(inVariances) == VarianceInfo.INVARIANT) {
						if (VarianceInfo.IN.mergeDeclaredWithActuals(outVariances) != null) {
							type = inType;
							variance = VarianceInfo.OUT;
						}
					} else {
						VarianceInfo inVariance = VarianceInfo.IN.mergeDeclaredWithActuals(inVariances);
						variance = VarianceInfo.IN.mergeWithOut(variance, inVariance, conformant);
					}
				}
			}
		} else if (!inTypes.isEmpty()) {
			type = getMostSpecialType(inTypes);
			variance = VarianceInfo.IN.mergeDeclaredWithActuals(inVariances);
		}
		return new LightweightMergedBoundTypeArgument(type, variance);
	}

	private LightweightTypeReference getCommonSuperTypes(List<LightweightTypeReference> types, ITypeReferenceOwner owner) {
		// use the given type list as-is
		TypeConformanceComputer conformanceComputer = owner.getServices().getTypeConformanceComputer();
		LightweightTypeReference type = conformanceComputer.getCommonSuperType(types, owner);
		if (type == null) {
			// failed - remove void if any
			List<LightweightTypeReference> filteredOutTypes = Lists.newArrayListWithCapacity(types.size());
			for(LightweightTypeReference outType: types) {
				if (!outType.isPrimitiveVoid()) {
					filteredOutTypes.add(outType);
				}
			}
			// and try again to compute the common super types
			if (!filteredOutTypes.isEmpty() && filteredOutTypes.size() != types.size()) {
				type = conformanceComputer.getCommonSuperType(filteredOutTypes, owner);
			}
			// still no success - use the first non-void type in the list or void if all are void
			if (type == null) {
				type = filteredOutTypes.isEmpty() ? types.get(0) : filteredOutTypes.get(0);
			}
		}
		return type;
	}

	private boolean isTransitiveHintFromReslved(LightweightBoundTypeArgument boundTypeArgument, Object origin, BoundTypeArgumentSource source) {
		return (origin instanceof LightweightBoundTypeArgument && ((LightweightBoundTypeArgument) origin).getSource() == BoundTypeArgumentSource.RESOLVED) && source == BoundTypeArgumentSource.INFERRED && boundTypeArgument.getActualVariance() == VarianceInfo.OUT;
	}

	private void processBoundTypeArgument(LightweightBoundTypeArgument boundTypeArgument, List<LightweightTypeReference> types, List<VarianceInfo> variances,
			Object origin, Set<Object> seenOrigin) {
		types.add(boundTypeArgument.getTypeReference());
		addVariance(boundTypeArgument, variances, origin, seenOrigin);
	}

	private void addVariance(LightweightBoundTypeArgument boundTypeArgument, List<VarianceInfo> result, Object origin, Set<Object> seenOrigin) {
		if (seenOrigin.add(origin) || origin == null || boundTypeArgument.isValidVariancePair()) {
			result.add(boundTypeArgument.getActualVariance());
		}
	}

	protected LightweightMergedBoundTypeArgument getSingleArgumentAsMergedArgument(LightweightBoundTypeArgument argument) {
		LightweightTypeReference typeReference = argument.getTypeReference();
		VarianceInfo varianceInfo = argument.getDeclaredVariance().mergeDeclaredWithActual(argument.getActualVariance());
		if (argument.getDeclaredVariance() == VarianceInfo.IN && varianceInfo == VarianceInfo.INVARIANT) {
			if (typeReference.getKind() == LightweightTypeReference.KIND_WILDCARD_TYPE_REFERENCE) {
				typeReference = typeReference.getInvariantBoundSubstitute();
			}
		}
		return new LightweightMergedBoundTypeArgument(typeReference, varianceInfo);
	}
	
	public boolean isPossibleMergeResult(List<LightweightBoundTypeArgument> allArguments, LightweightTypeReference candidate) {
		if (allArguments.isEmpty())
			return false;
		
		if (allArguments.size() == 1 && !candidate.isWildcard()) {
			LightweightBoundTypeArgument singleArgument = allArguments.get(0);
			if (VarianceInfo.OUT.equals(singleArgument.getActualVariance()) && singleArgument.getActualVariance().equals(singleArgument.getDeclaredVariance())) {
				LightweightTypeReference singleReference = singleArgument.getTypeReference();
				if (singleReference.isResolved())
					return candidate.isAssignableFrom(singleReference, TypeConformanceComputationArgument.DEFAULT);
			}
		}
		LightweightMergedBoundTypeArgument merged = merge(allArguments, candidate.getOwner());
		if (merged == null)
			return false;
		VarianceInfo variance = merged.getVariance();
		LightweightTypeReference type = merged.getTypeReference();
		if (variance == null || type == null) {
			return false;
		}
		switch(variance) {
			case INVARIANT: {
				int result = candidate.internalIsAssignableFrom(type, new TypeConformanceComputationArgument(false, true, true, true, false, false));
				if ((result & ConformanceFlags.SUCCESS) != 0 && (result & ConformanceFlags.RAW_TYPE_CONVERSION) == 0) {
					return true;
				}
				return false;
			}
			case OUT: return type.isAssignableFrom(candidate, TypeConformanceComputationArgument.DEFAULT);
			case IN: return candidate.isAssignableFrom(type, TypeConformanceComputationArgument.DEFAULT);
			default: throw new IllegalStateException("Unknown variance info: " + variance);
		}
	}

	protected LightweightTypeReference getMostSpecialType(List<LightweightTypeReference> candidates) {
		LightweightTypeReference type = conformanceComputer.getMostSpecialType(candidates);
		if (type == null)
			type = candidates.get(0);
		return type;
	}

}
