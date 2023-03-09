/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParameterizedResolvedFeatures implements IResolvedFeatures {

	private LightweightTypeReference type;
	private RawResolvedFeatures parent;

	public ParameterizedResolvedFeatures(LightweightTypeReference type, RawResolvedFeatures parent) {
		this.type = type;
		this.parent = parent;
	}
	
	@Override
	public List<JvmFeature> getAllFeatures(String simpleName) {
		List<JvmFeature> result = parent.getAllFeatures(simpleName);
		if (result.size() <= 1 || !type.hasTypeArguments()) {
			return result;
		}
		return computeAllFeatures(result);
	}
	
	@Override
	public List<JvmFeature> getAllFeatures() {
		List<JvmFeature> result = parent.getAllFeatures();
		if (result.size() <= 1 || !type.hasTypeArguments()) {
			return result;
		}
		return computeAllFeatures(result);
	}
	
	@Override
	public IResolvedFeatures getParameterizedView(LightweightTypeReference concrete) {
		return parent.getParameterizedView(concrete);
	}
	
	protected List<JvmFeature> computeAllFeatures(List<JvmFeature> unfiltered) {
		List<JvmFeature> result = Lists.newArrayListWithExpectedSize(unfiltered.size());
		Multimap<String, AbstractResolvedOperation> processed = HashMultimap.create();
		computeAllFeatures(unfiltered, processed, result);
		return Collections.unmodifiableList(result);
	}
	
	protected void computeAllFeatures(List<JvmFeature> unfiltered, Multimap<String, AbstractResolvedOperation> processedOperations, List<JvmFeature> result) {
		for(JvmFeature feature: unfiltered) {
			if (feature instanceof JvmOperation) {
				String simpleName = feature.getSimpleName();
				if (processedOperations.containsKey(simpleName)) {
					if (parent.isOverridden((JvmOperation) feature, processedOperations.get(simpleName))) {
						continue;
					}
				}
				BottomResolvedOperation resolvedOperation = parent.createResolvedOperation((JvmOperation) feature, type);
				processedOperations.put(simpleName, resolvedOperation);
				result.add(feature);
			} else {
				result.add(feature);
			}
		}
	}

}
