/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import static org.eclipse.emf.index.util.CollectionUtils.union;
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
public abstract class InverseReferenceCache<TargetType, SourceDescType> {

	private Map<TargetType, Set<SourceDescType>> resultMap = new HashMap<TargetType, Set<SourceDescType>>();

	public void put(SourceDescType sourceDescriptor) {
		List<TargetType> targetDescriptors = targets(sourceDescriptor);
		for (TargetType targetDescriptor : targetDescriptors) {
			Set<SourceDescType> sources = resultMap.get(targetDescriptor);
			if (sources == null) {
				sources = new HashSet<SourceDescType>();
				resultMap.put(targetDescriptor, sources);
			}
			sources.add(sourceDescriptor);
		}
	}

	public void remove(SourceDescType sourceDescriptor) {
		List<TargetType> targetDescriptors = targets(sourceDescriptor);
		for (TargetType targetDescriptor : targetDescriptors) {
			Set<SourceDescType> sources = resultMap.get(targetDescriptor);
			if (sources != null) {
				sources.remove(sourceDescriptor);
				if (sources.isEmpty()) {
					resultMap.remove(targetDescriptor);
				}
			}
		}
	}

	protected abstract List<TargetType> targets(SourceDescType source);

	public Collection<SourceDescType> lookup(TargetType targetDescriptor) {
		return resultMap.get(targetDescriptor);
	}

	public Collection<SourceDescType> lookup(TargetType parentScopeDescriptor, IGenericQuery<TargetType> parentScopeQuery) {
		Collection<SourceDescType> queryScope = null;
		boolean isScopeDefined = false;
		if (parentScopeDescriptor != null) {
			queryScope = lookup(parentScopeDescriptor);
			isScopeDefined = true;
		}
		if (parentScopeQuery != null) {
			isScopeDefined = true;
			Iterable<TargetType> parentScopes = parentScopeQuery.executeListResult();
			if (parentScopes != null) {
				for (TargetType parentScope : parentScopes) {
					queryScope = union(queryScope, lookup(parentScope));
				}
			}
		}
		return (isScopeDefined && queryScope == null) ? Collections.<SourceDescType> emptyList() : queryScope;
	}
	
	public IGenericQuery<SourceDescType> createQuery(TargetType targetDescriptor) {
		return new Query(targetDescriptor);
	}

	protected class Query implements IGenericQuery<SourceDescType> {

		private TargetType target;

		protected Query(TargetType target) {
			this.target = target;
		}

		public Collection<SourceDescType> executeListResult() {
			return CollectionUtils.copyOrNull(lookup(target));
		}

		public SourceDescType executeSingleResult() {
			Collection<SourceDescType> result = lookup(target);
			if (result != null && !result.isEmpty()) {
				return result.iterator().next();
			}
			return null;
		}
	}
}
