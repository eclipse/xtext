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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.impl.DefaultQueryTool;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ECrossReferenceDAOImpl extends BasicMemoryDAOImpl<ECrossReferenceDescriptor> implements
		ECrossReferenceDescriptor.DAO {

	protected InverseReferenceCache<EObjectDescriptor, ECrossReferenceDescriptor> sourceScope;
	protected InverseReferenceCache<EObjectDescriptor, ECrossReferenceDescriptor> targetScope;

	public ECrossReferenceDAOImpl(IIndexStore indexStore) {
		super(indexStore);
		sourceScope = new InverseReferenceCache<EObjectDescriptor, ECrossReferenceDescriptor>() {
			@Override
			protected List<EObjectDescriptor> targets(ECrossReferenceDescriptor source) {
				return Collections.singletonList(source.getSource());
			}
		};
		targetScope = new InverseReferenceCache<EObjectDescriptor, ECrossReferenceDescriptor>() {
			@Override
			protected List<EObjectDescriptor> targets(ECrossReferenceDescriptor source) {
				return Collections.singletonList(source.getTarget());
			}
		};
	}

	@Override
	public void store(ECrossReferenceDescriptor element) {
		super.store(element);
		sourceScope.put(element);
		targetScope.put(element);
	}

	@Override
	public void delete(ECrossReferenceDescriptor element) {
		super.delete(element);
		sourceScope.remove(element);
		targetScope.remove(element);
	}

	public ECrossReferenceDescriptor.Query createQuery() {
		return new CrossRefQuery();
	}

	public ECrossReferenceDescriptor.Query createQueryCrossReference(EObjectDescriptor sourceDescriptor,
			EReference eReference) {
		return DefaultQueryTool.createQueryCrossReference(this, sourceDescriptor, eReference);
	}

	public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(EObject target) {
		return DefaultQueryTool.createQueryECrossReferencesTo(this, target);
	}

	public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesFrom(EObjectDescriptor sourceDescriptor) {
		return sourceScope.createQuery(sourceDescriptor);
	}

	public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(EObjectDescriptor targetDescriptor) {
		return targetScope.createQuery(targetDescriptor);
	}

	protected class CrossRefQuery extends BasicMemoryDAOImpl<ECrossReferenceDescriptor>.Query implements
			ECrossReferenceDescriptor.Query {

		private EObjectDescriptor.Query sourceQuery;
		private EObjectDescriptor.Query targetQuery;
		private EObjectDescriptor sourceDescriptor;
		private EObjectDescriptor targetDescriptor;
		private String referenceNamePattern;

		public EObjectDescriptor.Query source() {
			if (sourceDescriptor != null) {
				throw new IllegalStateException("SourceQuery already configured");
			}
			sourceQuery = indexStore.eObjectDAO().createQuery();
			return sourceQuery;
		}

		public CrossRefQuery source(EObjectDescriptor sourceDescriptor) {
			if (sourceQuery != null) {
				throw new IllegalStateException("SourceQuery already configured");
			}
			this.sourceDescriptor = sourceDescriptor;
			return this;
		}

		public EObjectDescriptor.Query target() {
			if (targetDescriptor != null) {
				throw new IllegalStateException("TargetQuery already configured");
			}
			targetQuery = indexStore.eObjectDAO().createQuery();
			return targetQuery;
		}

		public CrossRefQuery target(EObjectDescriptor targetDescriptor) {
			if (targetQuery != null) {
				throw new IllegalStateException("TargetQuery already configured");
			}
			this.targetDescriptor = targetDescriptor;
			return this;
		}

		public ECrossReferenceDescriptor.Query referenceName(String pattern) {
			referenceNamePattern = pattern;
			return this;
		}

		protected boolean matches(ECrossReferenceDescriptor crossRefDescriptor) {
			return matchesGlobbing(crossRefDescriptor.getReferenceName(), referenceNamePattern);
		}

		@Override
		protected Collection<ECrossReferenceDescriptor> scope() {
			Collection<ECrossReferenceDescriptor> eCrossReferencesBySource = sourceScope.lookup(sourceDescriptor, sourceQuery);
			Collection<ECrossReferenceDescriptor> eCrossReferencesByTarget = targetScope.lookup(targetDescriptor, targetQuery);
			Collection<ECrossReferenceDescriptor> mergedScopes = mergeScopes(eCrossReferencesBySource, eCrossReferencesByTarget);
			return mergedScopes == null ? super.scope() : mergedScopes;
		}
	}
}
