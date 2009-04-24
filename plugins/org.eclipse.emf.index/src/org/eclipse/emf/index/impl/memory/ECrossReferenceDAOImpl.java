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
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.impl.DefaultQueryTool;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ECrossReferenceDAOImpl extends BasicMemoryDAOImpl<ECrossReferenceDescriptor> implements
		ECrossReferenceDescriptor.DAO {

	protected InverseReferenceCache<ResourceDescriptor, ECrossReferenceDescriptor> sourceResourceScope;
	protected InverseReferenceCache<ResourceDescriptor, ECrossReferenceDescriptor> targetResourceScope;

	public ECrossReferenceDAOImpl(IIndexStore indexStore) {
		super(indexStore);
		sourceResourceScope = new InverseReferenceCache<ResourceDescriptor, ECrossReferenceDescriptor>(){
			@Override
			protected List<ResourceDescriptor> targets(ECrossReferenceDescriptor source) {
				return Collections.singletonList(source.getSourceResourceDescriptor());
			}
		};
		targetResourceScope = new InverseReferenceCache<ResourceDescriptor, ECrossReferenceDescriptor>(){
			@Override
			protected List<ResourceDescriptor> targets(ECrossReferenceDescriptor source) {
				return Collections.singletonList(source.getTargetResourceDescriptor());
			}
		};
	}

	@Override
	public void store(ECrossReferenceDescriptor element) {
		super.store(element);
		sourceResourceScope.put(element);
		targetResourceScope.put(element);
	}

	@Override
	public void delete(ECrossReferenceDescriptor element) {
		super.delete(element);
		sourceResourceScope.remove(element);
		targetResourceScope.remove(element);
	}

	@Override
	protected boolean doModify(ECrossReferenceDescriptor element, ECrossReferenceDescriptor newValues) {
		throw new UnsupportedOperationException();
	}

	public ECrossReferenceDescriptor.Query createQuery() {
		return new CrossRefQuery();
	}

	public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(EObject target) {
		return DefaultQueryTool.createQueryECrossReferencesTo(this, target);
	}

	public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesFrom(URI sourceURI) {
		return DefaultQueryTool.createQueryCrossReferencesFrom(this, sourceURI);
	}

	public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(URI targetURI) {
		return DefaultQueryTool.createQueryCrossReferencesTo(this, targetURI);
	}

	protected class CrossRefQuery extends BasicMemoryDAOImpl<ECrossReferenceDescriptor>.Query implements
			ECrossReferenceDescriptor.Query {

		private String sourceFragmentPattern;
		private String targetFragmentPattern;
		private ResourceDescriptor sourceResourceDescriptor;
		private ResourceDescriptor targetResourceDescriptor;
		private ResourceDescriptor.Query sourceResourceQuery;
		private ResourceDescriptor.Query targetResourceQuery;
		private String referenceNamePattern;
		private int index;

		public CrossRefQuery sourceFragment(String pattern) {
			sourceFragmentPattern = pattern;
			return this;
		}
		
		public CrossRefQuery targetFragment(String pattern) {
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
		
		public CrossRefQuery sourceResource(ResourceDescriptor sourceResourceDescriptor) {
			if(sourceResourceQuery != null) {
				throw new IllegalStateException("SourceQuery already configured");				
			}
			this.sourceResourceDescriptor = sourceResourceDescriptor;
			return this;
		}
		
		public CrossRefQuery targetResource(ResourceDescriptor targetResourceDescriptor) {
			if(targetResourceQuery != null) {
				throw new IllegalStateException("TargetQuery already configured");				
			}
			this.targetResourceDescriptor = targetResourceDescriptor;
			return this;
		}

		public CrossRefQuery referenceName(String pattern) {
			referenceNamePattern = pattern;
			return this;
		}

		public CrossRefQuery index(int index) {
			this.index = index;
			return this;
		}

		protected boolean matches(ECrossReferenceDescriptor crossRefDescriptor) {
			return matchesGlobbing(crossRefDescriptor.getReferenceName(), referenceNamePattern)
					&& matchesGlobbing(crossRefDescriptor.getSourceFragment(), sourceFragmentPattern)
					&& matchesGlobbing(crossRefDescriptor.getTargetFragment(), targetFragmentPattern)
					&& (index != ECrossReferenceDescriptor.NO_INDEX && index == crossRefDescriptor.getIndex());
		}

		@Override
		protected Collection<ECrossReferenceDescriptor> scope() {
			Collection<ECrossReferenceDescriptor> eCrossReferencesBySourceResource = sourceResourceScope.lookup(sourceResourceDescriptor, sourceResourceQuery);
			Collection<ECrossReferenceDescriptor> eCrossReferencesByTargetResource = targetResourceScope.lookup(targetResourceDescriptor, targetResourceQuery);
			Collection<ECrossReferenceDescriptor> mergedScopes = mergeScopes(eCrossReferencesBySourceResource,
					eCrossReferencesByTargetResource);
			return mergedScopes == null ? super.scope() : mergedScopes;
		}
	}
}
