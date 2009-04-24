/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ECrossReferenceDescriptor.Query;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class DefaultQueryTool {

	public static EObjectDescriptor.Query createQueryEObjectsInResource(EObjectDescriptor.DAO dao, EObject eObject,
			ResourceDescriptor resourceDescriptor) {
		Resource resource = eObject.eResource();
		if (resource != null) {
			URI resourceURI = resource.getURI();
			if (resourceURI != null) {
				String fragment = resource.getURIFragment(eObject);
				return dao.createQuery().resource(resourceDescriptor).fragment(fragment);
			}
		}
		return null;
	}

	public static EClassDescriptor.Query createQueryEClass(EClassDescriptor.DAO dao, EClass eClass) {
		String name = eClass.getName();
		if (name != null) {
			EPackage ePackage = eClass.getEPackage();
			if (ePackage != null) {
				String nsURI = ePackage.getNsURI();
				if (nsURI != null) {
					EClassDescriptor.Query eClassQuery = dao.createQuery().name(name);
					eClassQuery.name(name).ePackage().nsURI(nsURI);
					return eClassQuery;
				}
			}
		}
		return null;
	}

	public static ECrossReferenceDescriptor.Query createQueryECrossReferencesTo(ECrossReferenceDescriptor.DAO dao,
			EObject target) {
		Resource resource = target.eResource();
		if(resource != null) {
			String targetFragment = resource.getURIFragment(target);
			if(targetFragment != null) {
				Query crossRefQuery = dao.createQuery().targetFragment(targetFragment);
				crossRefQuery.targetResource().uri(resource.getURI().toString());
				return crossRefQuery;
			}
		}
		return null;
	}

	public static ResourceDescriptor.Query createQueryResource(ResourceDescriptor.DAO dao, Resource resource) {
		if (resource != null && resource.getURI() != null) {
			return dao.createQuery().uri(resource.getURI().toString());
		}
		return null;
	}

	public static EObjectDescriptor.Query createQueryEObjectsInResource(EObjectDescriptor.DAO dao,
			ResourceDescriptor resourceDescriptor) {
		return dao.createQuery().resource(resourceDescriptor);
	}

	public static IGenericQuery<EClassDescriptor> createQueryEClassesInPackage(EClassDescriptor.DAO dao,
			EPackageDescriptor ePackageDescriptor) {
		return dao.createQuery().ePackage(ePackageDescriptor);
	}

	public static IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesFrom(
			ECrossReferenceDescriptor.DAO dao, URI sourceURI) {
		Query query = dao.createQuery().sourceFragment(sourceURI.fragment());
		query.sourceResource().uri(sourceURI.trimFragment().toString());
		return query;
	}

	public static IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(
			ECrossReferenceDescriptor.DAO dao, URI targetURI) {
		Query query = dao.createQuery().targetFragment(targetURI.fragment());
		query.targetResource().uri(targetURI.trimFragment().toString());
		return query;
	}

	public static IGenericQuery<EPackageDescriptor> createQueryEPackage(EPackageDescriptor.DAO dao, EPackage ePackage) {
		return dao.createQuery().nsURI(ePackage.getNsURI());
	}

	public static IGenericQuery<EObjectDescriptor> createQueryEObjectsByType(EObjectDescriptor.DAO dao, EClass eClass) {
		EObjectDescriptor.Query eObjectQuery = dao.createQuery();
		eObjectQuery.eClass().name(eClass.getName()).ePackage().nsURI(eClass.getEPackage().getNsURI());
		return eObjectQuery;
	}

	public static IGenericQuery<EObjectDescriptor> createQueryEObjectByURI(EObjectDescriptor.DAO dao, URI fragmentUri) {
		EObjectDescriptor.Query eObjectQuery = dao.createQuery();
		eObjectQuery.fragment(fragmentUri.fragment()).resource().uri(fragmentUri.trimFragment().toString());
		return eObjectQuery;
	}

	public static IGenericQuery<EObjectDescriptor> createQueryEObjectsByType(EObjectDescriptor.DAO dao,
			EClassDescriptor eClassDescriptor) {
		return dao.createQuery().eClass(eClassDescriptor);
	}
}
