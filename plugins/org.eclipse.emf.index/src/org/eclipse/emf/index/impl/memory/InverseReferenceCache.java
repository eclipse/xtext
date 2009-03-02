/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.util.CollectionUtils;

/**
 * A multimap for following inverse references.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class InverseReferenceCache<TargetDesc, SourceDesc> {

	private Map<TargetDesc, Set<SourceDesc>> resultMap = new HashMap<TargetDesc, Set<SourceDesc>>();

	public void put(SourceDesc sourceDescriptor) {
		List<TargetDesc> targetDescriptors = targets(sourceDescriptor);
		for (TargetDesc targetDescriptor : targetDescriptors) {
			Set<SourceDesc> sources = resultMap.get(targetDescriptor);
			if (sources == null) {
				sources = new HashSet<SourceDesc>();
				resultMap.put(targetDescriptor, sources);
			}
			sources.add(sourceDescriptor);
		}
	}

	public void remove(SourceDesc sourceDescriptor) {
		List<TargetDesc> targetDescriptors = targets(sourceDescriptor);
		for (TargetDesc targetDescriptor : targetDescriptors) {
			Set<SourceDesc> sources = resultMap.get(targetDescriptor);
			if (sources != null) {
				sources.remove(sourceDescriptor);
				if (sources.isEmpty()) {
					resultMap.remove(targetDescriptor);
				}
			}
		}
	}

	protected abstract List<TargetDesc> targets(SourceDesc source);

	public Collection<SourceDesc> lookup(TargetDesc targetDescriptor) {
		return resultMap.get(targetDescriptor);
	}

	public Collection<SourceDesc> lookup(TargetDesc parentScopeDescriptor, IGenericQuery<TargetDesc> parentScopeQuery) {
		Collection<SourceDesc> queryScope = null;
		boolean isScopeDefined = false;
		if (parentScopeDescriptor != null) {
			queryScope = lookup(parentScopeDescriptor);
			isScopeDefined = true;
		}
		if (parentScopeQuery != null) {
			isScopeDefined = true;
			Collection<TargetDesc> parentScopes = parentScopeQuery.executeListResult();
			if (parentScopes != null) {
				for (TargetDesc parentScope : parentScopes) {
					queryScope = CollectionUtils.union(queryScope, lookup(parentScope));
				}
			}
		}
		return (isScopeDefined && queryScope == null) ? Collections.<SourceDesc> emptyList() : queryScope;
	}

	public IGenericQuery<SourceDesc> createQuery(TargetDesc targetDescriptor) {
		return new Query(targetDescriptor);
	}

	protected class Query implements IGenericQuery<SourceDesc> {

		private TargetDesc target;

		protected Query(TargetDesc target) {
			this.target = target;
		}

		public Collection<SourceDesc> executeListResult() {
			return CollectionUtils.copyOrNull(lookup(target));
		}

		public SourceDesc executeSingleResult() {
			Collection<SourceDesc> result = lookup(target);
			if (result != null && !result.isEmpty()) {
				return result.iterator().next();
			}
			return null;
		}
	}
}
