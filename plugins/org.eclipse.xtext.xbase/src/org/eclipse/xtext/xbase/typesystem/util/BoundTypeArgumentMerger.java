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

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputationArgument;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class BoundTypeArgumentMerger {
	
	@Inject
	private TypeConformanceComputer conformanceComputer;
	
	@Nullable
	public MergedBoundTypeArgument merge(Collection<BoundTypeArgument> allArguments) {
		if (allArguments.isEmpty())
			return null;
		if (allArguments.size() == 1) {
			BoundTypeArgument argument = Iterables.getOnlyElement(allArguments);
			return new MergedBoundTypeArgument(argument.getTypeReference(), 
					argument.getDeclaredVariance().mergeDeclaredWithActual(argument.getActualVariance()));
		}
		List<JvmTypeReference> invariantTypes = Lists.newArrayListWithCapacity(3);
		List<VarianceInfo> invariantVariances = Lists.newArrayListWithCapacity(3);
		List<JvmTypeReference> outTypes = Lists.newArrayListWithCapacity(3);
		List<VarianceInfo> outVariances = Lists.newArrayListWithCapacity(3);
		List<JvmTypeReference> inTypes = Lists.newArrayListWithCapacity(3);
		List<VarianceInfo> inVariances = Lists.newArrayListWithCapacity(3);
		Set<Object> seenOrigin = Sets.newHashSet();
		for(BoundTypeArgument boundTypeArgument: allArguments) {
			Object origin = boundTypeArgument.getOrigin();
			switch(boundTypeArgument.getDeclaredVariance()) {
				case INVARIANT:
					invariantTypes.add(boundTypeArgument.getTypeReference());
					if (seenOrigin.add(origin) || origin == null || boundTypeArgument.isValidVariancePair()) {
						invariantVariances.add(boundTypeArgument.getActualVariance());
					}
					break;
				case OUT:
					outTypes.add(boundTypeArgument.getTypeReference());
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
		JvmTypeReference type = null;
		VarianceInfo variance = null;
		if (!invariantTypes.isEmpty()) {
			type = invariantTypes.get(0);
			variance = VarianceInfo.INVARIANT.mergeDeclaredWithActuals(invariantVariances);
			if (!outVariances.isEmpty()) {
				VarianceInfo outVariance = VarianceInfo.OUT.mergeDeclaredWithActuals(outVariances);
				variance = VarianceInfo.OUT.mergeInvariance(variance, outVariance);
			} else if (!inVariances.isEmpty()) {
				VarianceInfo inVariance = VarianceInfo.IN.mergeDeclaredWithActuals(inVariances);
				variance = VarianceInfo.IN.mergeInvariance(variance, inVariance);
			}
		} else if (!outTypes.isEmpty()) {
			type = conformanceComputer.getCommonSuperType(outTypes);
			variance = VarianceInfo.OUT.mergeDeclaredWithActuals(outVariances);
			if (!inVariances.isEmpty()) {
				JvmTypeReference inType = getMostSpecialType(inTypes);
				boolean conformant = conformanceComputer.isConformant(type, inType, new TypeConformanceComputationArgument(false, true, false)).isConformant();
				VarianceInfo inVariance = VarianceInfo.IN.mergeDeclaredWithActuals(inVariances);
				variance = VarianceInfo.IN.mergeWithOut(variance, inVariance, conformant);
			}
		} else if (!inTypes.isEmpty()) {
			type = getMostSpecialType(inTypes);
			variance = VarianceInfo.IN.mergeDeclaredWithActuals(inVariances);
		}
		return new MergedBoundTypeArgument(type, variance);
	}

	protected JvmTypeReference getMostSpecialType(List<JvmTypeReference> candidates) {
		JvmTypeReference type;
		type = candidates.get(0);
		for(int i = 1; i < candidates.size(); i++) {
			JvmTypeReference candidate = candidates.get(i);
			if (conformanceComputer.isConformant(type, candidate)) {
				type = candidate;
			}
		}
		return type;
	}

}
