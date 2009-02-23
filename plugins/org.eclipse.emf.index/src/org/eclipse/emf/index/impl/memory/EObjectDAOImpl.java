/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.impl.DefaultQueryTool;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EObjectDAOImpl extends BasicMemoryDAOImpl<EObjectDescriptor> implements EObjectDescriptor.DAO {

	protected InverseReferenceCache<ResourceDescriptor, EObjectDescriptor> resourceScope;
	protected InverseReferenceCache<EClassDescriptor, EObjectDescriptor> eClassScope;
	
	public EObjectDAOImpl(IIndexStore indexStore) {
		super(indexStore);
		resourceScope = new InverseReferenceCache<ResourceDescriptor, EObjectDescriptor>() {
			@Override
			protected ResourceDescriptor target(EObjectDescriptor source) {
				return source.getResourceDescriptor();
			}
		};
		eClassScope = new InverseReferenceCache<EClassDescriptor, EObjectDescriptor>(){
			@Override
			protected EClassDescriptor target(EObjectDescriptor source) {
				return source.getEClassDescriptor();
			}
		};
	}
	
	@Override
	public void store(EObjectDescriptor element) {
		super.store(element);
		resourceScope.put(element);
		eClassScope.put(element);
	}
	
	@Override
	public void delete(EObjectDescriptor element) {
		super.delete(element);
		resourceScope.remove(element);
		eClassScope.remove(element);
	}

	public EObjectDescriptor.Query createQuery() {
		return new ElementQuery();
	}

	public IGenericQuery<EObjectDescriptor> createQueryEObjectsByType(EClass eClass) {
		return DefaultQueryTool.createQueryEObjectsByType(this, eClass);
	}

	public IGenericQuery<EObjectDescriptor> createQueryEObjectsByType(EClassDescriptor eClassDescriptor) {
		return eClassScope.createQuery(eClassDescriptor);
	}

	public IGenericQuery<EObjectDescriptor> createQueryEObjectByURI(URI fragmentURI) {
		return DefaultQueryTool.createQueryEObjectByURI(this, fragmentURI);
	}

	public EObjectDescriptor.Query createQueryEObjectInResource(EObject eObject, ResourceDescriptor resourceDescriptor) {
		return DefaultQueryTool.createQueryEObjectsInResource(this, eObject, resourceDescriptor);
	}

	public IGenericQuery<EObjectDescriptor> createQueryEObjectsInResource(ResourceDescriptor resourceDescriptor) {
		return resourceScope.createQuery(resourceDescriptor);
	}

	private class ElementQuery extends BasicMemoryDAOImpl<EObjectDescriptor>.Query implements EObjectDescriptor.Query {

		private ResourceDescriptor resourceDescriptor;
		private ResourceDescriptor.Query resourceQuery;
		private String fragmentPattern;
		private String namePattern;
		private EClassDescriptor typeDescriptor;
		private EClassDescriptor.Query typeQuery;
		private Map<String, String> userDataPatterns;

		public ElementQuery resource(ResourceDescriptor resourceDescriptor) {
			if (resourceQuery != null) {
				throw new IllegalArgumentException("ReourceQuery already configured");
			}
			this.resourceDescriptor = resourceDescriptor;
			return this;
		}

		public ResourceDescriptor.Query resource() {
			if (resourceDescriptor != null) {
				throw new IllegalArgumentException("ReourceQuery already configured");
			}
			ResourceDescriptor.Query resourceQuery = indexStore.resourceDAO().createQuery();
			return resourceQuery;
		}

		public ElementQuery fragment(String pattern) {
			fragmentPattern = pattern;
			return this;
		}

		public ElementQuery name(String pattern) {
			namePattern = pattern;
			return this;
		}

		public ElementQuery eClass(EClassDescriptor typeDescriptor) {
			this.typeDescriptor = typeDescriptor;
			return this;
		}

		public EClassDescriptor.Query eClass() {
			this.typeQuery = indexStore.eClassDAO().createQuery();
			return typeQuery;
		}
		
		public ElementQuery userData(String key, String pattern) {
			if (userDataPatterns == null) {
				userDataPatterns = new HashMap<String, String>();
			}
			userDataPatterns.put(key, pattern);
			return this;
		}

		public boolean matches(EObjectDescriptor elementDescriptor) {
			if (matchesGlobbing(elementDescriptor.getFragment(), fragmentPattern)
					&& matchesGlobbing(elementDescriptor.getName(), namePattern)
					&& (typeDescriptor == null || typeDescriptor.equals(elementDescriptor.getEClassDescriptor()))) {
				if (userDataPatterns != null) {
					for (Entry<String, String> userDataEntry : userDataPatterns.entrySet()) {
						if (!matchesGlobbing(elementDescriptor.getUserData(userDataEntry.getKey()), userDataEntry.getValue())) {
							return false;
						}
					}
				}
				return true;
			}
			return false;
		}

		@Override
		protected Collection<EObjectDescriptor> scope() {
			Collection<EObjectDescriptor> eObjectsByResource = resourceScope.lookup(resourceDescriptor, resourceQuery);
			Collection<EObjectDescriptor> eObjectsByEClass = eClassScope.lookup(typeDescriptor, typeQuery);
			Collection<EObjectDescriptor> mergedScopes = mergeScopes(eObjectsByResource, eObjectsByEClass);
			return (mergedScopes == null) ? super.scope() : mergedScopes;
		}

	}

}
