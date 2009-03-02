/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.mocks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IIndexFeeder;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.EPackageDescriptor.DAO;
import org.eclipse.emf.index.ResourceDescriptor.Query;
import org.eclipse.emf.index.impl.IndexFeederImpl;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class MockIndexStore implements IIndexStore {

	public final List<ECrossReferenceDescriptor> addedCrossRefDescriptors = new ArrayList<ECrossReferenceDescriptor>();
	public final List<ECrossReferenceDescriptor> removedCrossRefDescriptors = new ArrayList<ECrossReferenceDescriptor>();
	public final List<EObjectDescriptor> addedEObjectDescriptors = new ArrayList<EObjectDescriptor>();
	public final List<EObjectDescriptor> removedEObjectDescriptors = new ArrayList<EObjectDescriptor>();
	public final List<EClassDescriptor> addedEClassDescriptors = new ArrayList<EClassDescriptor>();
	public final List<EClassDescriptor> removedEClassDescriptors = new ArrayList<EClassDescriptor>();
	public final List<EPackageDescriptor> addedEPackageDescriptors = new ArrayList<EPackageDescriptor>();
	public final List<EPackageDescriptor> removedEPackageDescriptors = new ArrayList<EPackageDescriptor>();
	public final List<ResourceDescriptor> addedResourceDescriptors = new ArrayList<ResourceDescriptor>();
	public final List<ResourceDescriptor> removedResourceDescriptors = new ArrayList<ResourceDescriptor>();
	
	protected IIndexFeeder indexFeeder;
	
	public MockIndexStore() {
		 indexFeeder = new IndexFeederImpl(this);
	}
	
	public ECrossReferenceDescriptor.DAO eCrossReferenceDAO() {
		return new ECrossReferenceDescriptor.DAO() {

			public ECrossReferenceDescriptor.Query createQuery() {
				return null;
			}

			public void store(ECrossReferenceDescriptor descriptor) {
				addedCrossRefDescriptors.add(descriptor);
			}

			public void delete(ECrossReferenceDescriptor descriptor) {
				removedCrossRefDescriptors.add(descriptor);
			}

			public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(EObject target) {
				return new MockQuery<ECrossReferenceDescriptor>();
			}

			public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReference(
					org.eclipse.emf.index.EObjectDescriptor sourceDescriptor, EReference reference) {
				return new MockQuery<ECrossReferenceDescriptor>();
			}

			public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesFrom(
					EObjectDescriptor sourceDescriptor) {
				return null;
			}

			public IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(
					EObjectDescriptor targetDescriptor) {
				return null;
			}
		};
	}

	public EObjectDescriptor.DAO eObjectDAO() {
		return new EObjectDescriptor.DAO() {
			public EObjectDescriptor.Query createQuery() {
				return null;
			}

			public void store(EObjectDescriptor descriptor) {
				addedEObjectDescriptors.add(descriptor);
			}

			public void delete(EObjectDescriptor descriptor) {
				removedEObjectDescriptors.add(descriptor);
			}

			public IGenericQuery<org.eclipse.emf.index.EObjectDescriptor> createQueryEObjectsByType(EClass class1) {
				return new MockQuery<EObjectDescriptor>();
			}

			public IGenericQuery<org.eclipse.emf.index.EObjectDescriptor> createQueryEObjectByURI(URI fragmentURI) {
				return new MockQuery<EObjectDescriptor>();
			}

			public IGenericQuery<org.eclipse.emf.index.EObjectDescriptor> createQueryEObjectInResource(EObject object,
					org.eclipse.emf.index.ResourceDescriptor resourceDescriptor) {
				return new MockQuery<EObjectDescriptor>();
			}

			public IGenericQuery<org.eclipse.emf.index.EObjectDescriptor> createQueryEObjectsInResource(
					org.eclipse.emf.index.ResourceDescriptor resourceDescriptor) {
				return new MockQuery<EObjectDescriptor>();
			}

			public IGenericQuery<EObjectDescriptor> createQueryEObjectsByType(EClassDescriptor eClassDescriptor) {
				return new MockQuery<EObjectDescriptor>();
			}
		};
	}

	public EClassDescriptor.DAO eClassDAO() {
		return new EClassDescriptor.DAO() {
			public EClassDescriptor.Query createQuery() {
				return null;
			}

			public IGenericQuery<EClassDescriptor> createQueryEClass(EClass eClass) {
				return new MockQuery<EClassDescriptor>();
			}

			public void store(EClassDescriptor descriptor) {
				addedEClassDescriptors.add(descriptor);
			}

			public void delete(EClassDescriptor descriptor) {
				removedEClassDescriptors.add(descriptor);
			}

			public IGenericQuery<EClassDescriptor> createQueryEClassesInPackage(EPackageDescriptor ePackageDescriptor) {
				return new MockQuery<EClassDescriptor>();
			}
		};
	}

	public ResourceDescriptor.DAO resourceDAO() {
		return new ResourceDescriptor.DAO() {
			public ResourceDescriptor.Query createQuery() {
				return (Query) new MockQuery<ResourceDescriptor>();
			}

			public IGenericQuery<ResourceDescriptor> createQueryResource(final Resource resource) {
				for (ResourceDescriptor desc : addedResourceDescriptors) {
					if (desc.getURI().equals(resource.getURI().toString()))
						return new MockQuery<ResourceDescriptor>(desc);
				}
				return new MockQuery<ResourceDescriptor>();
			}

			public void store(org.eclipse.emf.index.ResourceDescriptor resourceDescriptor) {
				addedResourceDescriptors.add(resourceDescriptor);
			}

			public void delete(org.eclipse.emf.index.ResourceDescriptor resourceDescriptor) {
				removedResourceDescriptors.remove(resourceDescriptor);
			}
		};
	}

	public DAO ePackageDAO() {
		
		return new EPackageDescriptor.DAO(){
		
			public void delete(EPackageDescriptor element) {
				removedEPackageDescriptors.add(element);
			}
		
			public void store(EPackageDescriptor element) {
				addedEPackageDescriptors.add(element);
			}
		
			public IGenericQuery<EPackageDescriptor> createQueryEPackage(EPackage ePackage) {
				return new MockQuery<EPackageDescriptor>();
			}
		
			public org.eclipse.emf.index.EPackageDescriptor.Query createQuery() {
				return null;
			}
		};
	}
	
	public IIndexFeeder indexFeeder() {
		return indexFeeder;
	}
}
