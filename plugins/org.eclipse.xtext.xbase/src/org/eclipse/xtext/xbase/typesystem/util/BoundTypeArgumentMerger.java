/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceResult;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

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
		List<LightweightTypeReference> invariantTypes = Lists.newArrayListWithCapacity(3);
		List<VarianceInfo> invariantVariances = Lists.newArrayListWithCapacity(3);
		List<LightweightTypeReference> outTypes = Lists.newArrayListWithCapacity(3);
		List<LightweightTypeReference> constraintOutTypes = Lists.newArrayListWithCapacity(3);
		List<VarianceInfo> outVariances = Lists.newArrayListWithCapacity(3);
		List<LightweightTypeReference> inTypes = Lists.newArrayListWithCapacity(3);
		List<VarianceInfo> inVariances = Lists.newArrayListWithCapacity(3);
		Set<Object> seenOrigin = Sets.newHashSet();
		for(LightweightBoundTypeArgument boundTypeArgument: allArguments) {
			Object origin = boundTypeArgument.getOrigin();
			switch(boundTypeArgument.getDeclaredVariance()) {
				case INVARIANT:
					invariantTypes.add(boundTypeArgument.getTypeReference());
					if (seenOrigin.add(origin) || origin == null || boundTypeArgument.isValidVariancePair()) {
						invariantVariances.add(boundTypeArgument.getActualVariance());
					}
					break;
				case OUT:
					if (boundTypeArgument.getSource() == BoundTypeArgumentSource.CONSTRAINT) {
						constraintOutTypes.add(boundTypeArgument.getTypeReference());
					} else {
						outTypes.add(boundTypeArgument.getTypeReference());
					}
					if (seenOrigin.add(origin) || origin == null || boundTypeArgument.isValidVariancePair()) {
						outVariances.add(boundTypeArgument.getActualVariance());
					}
					break;
				case IN:
					inTypes.add(boundTypeArgument.getTypeReference());
					if (seenOrigin.add(origin) || origin == null || boundTypeArgument.isValidVariancePair()) {
						inVariances.add(boundTypeArgument.getActualVariance());
					}
					break;
			}
		}
		LightweightTypeReference type = null;
		VarianceInfo variance = null;
		if (outTypes.isEmpty()) {
			outTypes.addAll(constraintOutTypes);
		}
		if (!invariantTypes.isEmpty()) {
			type = invariantTypes.get(0);
			variance = VarianceInfo.INVARIANT.mergeDeclaredWithActuals(invariantVariances);
			if (variance == null && invariantVariances.contains(VarianceInfo.IN) && invariantTypes.size() > 1) {
				TypeConformanceComputer conformanceComputer = owner.getServices().getTypeConformanceComputer();
				type = conformanceComputer.getCommonSuperType(invariantTypes, owner);
			}
			if (!outVariances.isEmpty()) {
				VarianceInfo outVariance = VarianceInfo.OUT.mergeDeclaredWithActuals(outVariances);
				variance = VarianceInfo.OUT.mergeInvariance(variance, outVariance);
			} else if (!inVariances.isEmpty()) {
				VarianceInfo inVariance = VarianceInfo.IN.mergeDeclaredWithActuals(inVariances);
				variance = VarianceInfo.IN.mergeInvariance(variance, inVariance);
			}
		} else if (!outTypes.isEmpty()) {
			TypeConformanceComputer conformanceComputer = owner.getServices().getTypeConformanceComputer();
			type = conformanceComputer.getCommonSuperType(outTypes, owner);
			if (type == null)
				throw new IllegalStateException("common super type may not be null");
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

	protected LightweightMergedBoundTypeArgument getSingleArgumentAsMergedArgument(LightweightBoundTypeArgument argument) {
		LightweightTypeReference typeReference = argument.getTypeReference();
		VarianceInfo varianceInfo = argument.getDeclaredVariance().mergeDeclaredWithActual(argument.getActualVariance());
		if (argument.getDeclaredVariance() == VarianceInfo.IN && varianceInfo == VarianceInfo.INVARIANT) {
			if (typeReference instanceof WildcardTypeReference) {
				typeReference = ((WildcardTypeReference) typeReference).getInvariantBoundSubstitute();
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
					return candidate.isAssignableFrom(singleReference, new TypeConformanceComputationArgument());
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
				TypeConformanceResult result = candidate.internalIsAssignableFrom(type, new TypeConformanceComputationArgument(false, true, true, true, false, false));
				if (result.isConformant() && !result.getConformanceHints().contains(ConformanceHint.RAWTYPE_CONVERSION)) {
					return true;
				}
				return false;
			}
			case OUT: return type.isAssignableFrom(candidate, new TypeConformanceComputationArgument());
			case IN: return candidate.isAssignableFrom(type, new TypeConformanceComputationArgument());
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
