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
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.impl.DefaultQueryTool;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EReferenceDAOImpl extends BasicMemoryDAOImpl<EReferenceDescriptor> implements EReferenceDescriptor.DAO {

	private static final long serialVersionUID = -2728570457091998837L;

	protected transient InverseReferenceCache<ResourceDescriptor, EReferenceDescriptor> sourceResourceScope;
	protected transient InverseReferenceCache<ResourceDescriptor, EReferenceDescriptor> targetResourceScope;

	@Override
	public void store(EReferenceDescriptor element) {
		super.store(element);
		sourceResourceScope.put(element);
		targetResourceScope.put(element);
	}

	@Override
	public void delete(EReferenceDescriptor element) {
		super.delete(element);
		sourceResourceScope.remove(element);
		targetResourceScope.remove(element);
	}

	@Override
	public void initialize(IndexStore indexStore) {
		super.initialize(indexStore);
		sourceResourceScope = new InverseReferenceCache<ResourceDescriptor, EReferenceDescriptor>() {
			@Override
			protected List<ResourceDescriptor> targets(EReferenceDescriptor source) {
				return Collections.singletonList(source.getSourceResourceDescriptor());
			}
		};
		targetResourceScope = new InverseReferenceCache<ResourceDescriptor, EReferenceDescriptor>() {
			@Override
			protected List<ResourceDescriptor> targets(EReferenceDescriptor source) {
				return Collections.singletonList(source.getTargetResourceDescriptor());
			}
		};
		for (EReferenceDescriptor eReferenceDescriptor : store) {
			sourceResourceScope.put(eReferenceDescriptor);
			targetResourceScope.put(eReferenceDescriptor);
		}
	}

	@Override
	protected boolean doModify(EReferenceDescriptor element, Object modification) {
		throw new UnsupportedOperationException();
	}

	public EReferenceDescriptor.Query createQuery() {
		return new EReferenceQuery();
	}

	public IGenericQuery<EReferenceDescriptor> createQueryEReferencesTo(EObject target) {
		return DefaultQueryTool.createQueryEReferencesTo(this, target);
	}

	public IGenericQuery<EReferenceDescriptor> createQueryEReferencesFrom(URI sourceURI) {
		return DefaultQueryTool.createQueryEReferencesFrom(this, sourceURI);
	}

	public IGenericQuery<EReferenceDescriptor> createQueryEReferencesTo(URI targetURI) {
		return DefaultQueryTool.createQueryEReferencesTo(this, targetURI);
	}

	public IGenericQuery<EReferenceDescriptor> createQueryEReferencesFromResource(ResourceDescriptor resourceDescriptor) {
		return sourceResourceScope.createQuery(resourceDescriptor);
	}


	protected class EReferenceQuery extends BasicMemoryDAOImpl<EReferenceDescriptor>.Query implements
			EReferenceDescriptor.Query {

		private String sourceFragmentPattern;
		private String targetFragmentPattern;
		private ResourceDescriptor sourceResourceDescriptor;
		private ResourceDescriptor targetResourceDescriptor;
		private ResourceDescriptor.Query sourceResourceQuery;
		private ResourceDescriptor.Query targetResourceQuery;
		private String referenceNamePattern;
		private int index = EReferenceDescriptor.NO_INDEX;

		public EReferenceQuery sourceFragment(String pattern) {
			sourceFragmentPattern = pattern;
			return this;
		}

		public EReferenceQuery targetFragment(String pattern) {
			targetFragmentPattern = pattern;
			return this;
		}

		public ResourceDescriptor.Query sourceResource() {
			if (sourceResourceDescriptor != null) {
				throw new IllegalStateException("SourceQuery already configured");
			}
			sourceResourceQuery = indexStore.resourceDAO().createQuery();
			return sourceResourceQuery;
		}

		public ResourceDescriptor.Query targetResource() {
			if (targetResourceDescriptor != null) {
				throw new IllegalStateException("TargetQuery already configured");
			}
			targetResourceQuery = indexStore.resourceDAO().createQuery();
			return targetResourceQuery;
		}

		public EReferenceQuery sourceResource(ResourceDescriptor sourceResourceDescriptor) {
			if (sourceResourceQuery != null) {
				throw new IllegalStateException("SourceQuery already configured");
			}
			this.sourceResourceDescriptor = sourceResourceDescriptor;
			return this;
		}

		public EReferenceQuery targetResource(ResourceDescriptor targetResourceDescriptor) {
			if (targetResourceQuery != null) {
				throw new IllegalStateException("TargetQuery already configured");
			}
			this.targetResourceDescriptor = targetResourceDescriptor;
			return this;
		}

		public EReferenceQuery referenceName(String pattern) {
			referenceNamePattern = pattern;
			return this;
		}

		public EReferenceQuery index(int index) {
			this.index = index;
			return this;
		}

		protected boolean matches(EReferenceDescriptor eReferenceDescriptor) {
			return matchesGlobbing(eReferenceDescriptor.getReferenceName(), referenceNamePattern)
					&& matchesGlobbing(eReferenceDescriptor.getSourceFragment(), sourceFragmentPattern)
					&& matchesGlobbing(eReferenceDescriptor.getTargetFragment(), targetFragmentPattern)
					&& (index == EReferenceDescriptor.NO_INDEX || index == eReferenceDescriptor.getIndex());
		}

		@Override
		protected Collection<EReferenceDescriptor> scope() {
			Collection<EReferenceDescriptor> eReferencesBySourceResource = sourceResourceScope.lookup(
					sourceResourceDescriptor, sourceResourceQuery);
			Collection<EReferenceDescriptor> eReferencesByTargetResource = targetResourceScope.lookup(
					targetResourceDescriptor, targetResourceQuery);
			Collection<EReferenceDescriptor> mergedScopes = mergeScopes(eReferencesBySourceResource,
					eReferencesByTargetResource);
			return mergedScopes == null ? super.scope() : mergedScopes;
		}
	}
}
