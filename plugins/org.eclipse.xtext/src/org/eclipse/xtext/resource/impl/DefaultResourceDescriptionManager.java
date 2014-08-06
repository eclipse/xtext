/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import static com.google.common.collect.Lists.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategyExtension;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Default implementation of the {@link org.eclipse.xtext.resource.IResourceDescription.Manager}. Customize by binding another
 * {@link IDefaultResourceDescriptionStrategy}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 * @author Jan Koehnlein
 */
@Singleton
public class DefaultResourceDescriptionManager implements IResourceDescription.Manager, IResourceDescription.ManagerExtension {

	@Inject
	private IDefaultResourceDescriptionStrategy strategy;
	
	@Inject
	private IContainer.Manager containerManager;
	
	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;
	
	@Inject
	private DescriptionUtils descriptionUtils;
	
	private static final String CACHE_KEY = DefaultResourceDescriptionManager.class.getName() + "#getResourceDescription";
	
	public IResourceDescription getResourceDescription(final Resource resource) {
		return cache.get(CACHE_KEY, resource, new Provider<IResourceDescription>() {
			public IResourceDescription get() {
				return internalGetResourceDescription(resource, strategy);
			}
		});
	}
	
	public Delta createDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new DefaultResourceDescriptionDelta(oldDescription, newDescription);
	}

	protected IResourceDescription internalGetResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		return new DefaultResourceDescription(resource, strategy, cache);
	}
	
	public IContainer.Manager getContainerManager() {
		return containerManager;
	}
	
	public void setContainerManager(IContainer.Manager containerManager) {
		this.containerManager = containerManager;
	}
	
	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}
	
	public IResourceScopeCache getCache() {
		return cache;
	}
	
	public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		if (!hasChanges(delta, candidate))
			return false;
		Set<QualifiedName> names = Sets.newHashSet();
		addExportedNames(names,delta.getOld());
		addExportedNames(names,delta.getNew());
		return !Collections.disjoint(names, getImportedNames(candidate));
	}

	protected Collection<QualifiedName> getImportedNames(IResourceDescription candidate) {
		return Sets.newHashSet(candidate.getImportedNames());
	}

	protected void addExportedNames(Set<QualifiedName> names, IResourceDescription resourceDescriptor) {
		if (resourceDescriptor==null)
			return;
		Iterable<IEObjectDescription> iterable = resourceDescriptor.getExportedObjects();
		for (IEObjectDescription ieObjectDescription : iterable) {
			names.add(ieObjectDescription.getName().toLowerCase());
		}
	}
	
    public boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate, IResourceDescriptions context) {
        Set<URI> outgoingReferences = descriptionUtils.collectOutgoingReferences(candidate);
        if (!outgoingReferences.isEmpty()) {
	        for (IResourceDescription.Delta delta : deltas)
	            if (hasChanges(delta, candidate) && outgoingReferences.contains(delta.getUri()))
	                return true;
        }
        // this is a tradeoff - we could either check whether a given delta uri is contained
        // in a reachable container and check for intersecting names afterwards, or we can do
        // the other way round
        // unfortunately there is no way to decide reliably which algorithm scales better
        // note that this method is called for each description so we have something like a 
        // number of deltas x number of resources which is not really nice
        List<IContainer> containers = null;
        Collection<QualifiedName> importedNames = getImportedNames(candidate);
        for (IResourceDescription.Delta delta : deltas) {
			if (hasChanges(delta, candidate)) {
				// not a java resource - delta's resource should be contained in a visible container
				// as long as we did not delete the resource
				URI uri = delta.getUri();
				if ((uri.isPlatform() || uri.isArchive()) && delta.getNew() != null) { 
					if (containers == null)
						containers = containerManager.getVisibleContainers(candidate, context);
					boolean descriptionIsContained = false;
					for(int i = 0; i < containers.size() && !descriptionIsContained; i++) {
						descriptionIsContained = containers.get(i).hasResourceDescription(uri);
					}
					if (!descriptionIsContained)
						return false;
				}
				if (isAffected(importedNames, delta.getNew()) || isAffected(importedNames, delta.getOld())) {
					return true;
				}
			}
        }
        return false;
    }

	/**
	 * Whether the given delta is considered to have changed from the candidate's perspective. By default this will just call
	 * {@link org.eclipse.xtext.resource.IResourceDescription.Delta#haveEObjectDescriptionsChanged() Delta#haveEObjectDescriptionsChanged()}. 
	 * But in some cases even "internal" changes (that are not visible in the EObjectDescriptions) could be interesting. 
	 * @since 2.7
	 */
	protected boolean hasChanges(IResourceDescription.Delta delta, IResourceDescription candidate) {
		return delta.haveEObjectDescriptionsChanged();
	}

	protected boolean isAffected(Collection<QualifiedName> importedNames, IResourceDescription description) {
		if (description != null) {
		    for (IEObjectDescription desc : description.getExportedObjects())
		        if (importedNames.contains(desc.getName().toLowerCase()))
		            return true;
		}
		return false;
	}
	
	public DescriptionUtils getDescriptionUtils() {
		return descriptionUtils;
	}
	
	public void setDescriptionUtils(DescriptionUtils descriptionUtils) {
		this.descriptionUtils = descriptionUtils;
	}
	
	public void setStrategy(IDefaultResourceDescriptionStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * @since 2.7
	 */
	public IResourceDescription getIndexingResourceDescription(Resource resource) {
		return internalGetIndexingResourceDescription(resource, strategy);
	}

	/**
	 * @since 2.7
	 */
	protected IResourceDescription internalGetIndexingResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy2) {
		return new IndexingResourceDescription(resource, strategy);
	}
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * @since 2.7
	 * 
	 */
	public static class IndexingResourceDescription extends DefaultResourceDescription {
		
		private final static Logger log = Logger.getLogger(IndexingResourceDescription.class);
		
		private IDefaultResourceDescriptionStrategy strategy;

		public IndexingResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
			super(resource, strategy);
			this.strategy = strategy;
		}

		@Override
		public Iterable<QualifiedName> getImportedNames() {
			throw new UnsupportedOperationException("Should never be called, as this is an IndexingResourceDescription");
		}

		@Override
		public Iterable<IReferenceDescription> getReferenceDescriptions() {
			throw new UnsupportedOperationException("Should never be called, as this is an IndexingResourceDescription");
		}

		@Override
		protected List<IEObjectDescription> computeExportedObjects() {
			if (!getResource().isLoaded()) {
				try {
					getResource().load(null);
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					return Collections.<IEObjectDescription> emptyList();
				}
			}
			final List<IEObjectDescription> exportedEObjects = newArrayList();
			IAcceptor<IEObjectDescription> acceptor = new IAcceptor<IEObjectDescription>() {
				public void accept(IEObjectDescription eObjectDescription) {
					exportedEObjects.add(eObjectDescription);
				}
			};
			TreeIterator<EObject> allProperContents = getAllProperContents();
			if (strategy instanceof IDefaultResourceDescriptionStrategyExtension) {
				IDefaultResourceDescriptionStrategyExtension strategyExtension = (IDefaultResourceDescriptionStrategyExtension) strategy;
				while (allProperContents.hasNext()) {
					EObject content = allProperContents.next();
					if (!strategyExtension.createIndexingEObjectDescriptions(content, acceptor))
						allProperContents.prune();
				}
			} else {
				while (allProperContents.hasNext()) {
					EObject content = allProperContents.next();
					if (!strategy.createEObjectDescriptions(content, acceptor))
						allProperContents.prune();
				}
			}
			return exportedEObjects;
		}
	}
}
