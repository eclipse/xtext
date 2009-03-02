/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.IIndexFeeder;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.IndexingException;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.util.MultiMap;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IndexFeederImpl implements IIndexFeeder {

	protected EPackageDescriptor.Factory packageFactory = new EPackageDescriptorImpl.Factory();
	protected EClassDescriptor.Factory typeFactory = new EClassTypeDescriptorImpl.Factory();

	protected List<ResourceDescriptor.Factory> resourceFactories = new ArrayList<ResourceDescriptor.Factory>();
	protected List<EObjectDescriptor.Factory> elementFactories = new ArrayList<EObjectDescriptor.Factory>();
	protected List<ECrossReferenceDescriptor.Factory> crossRefFactories = new ArrayList<ECrossReferenceDescriptor.Factory>();

	protected IIndexStore index;

	public IndexFeederImpl(IIndexStore index) {
		elementFactories.add(new EObjectDescriptorImpl.Factory());
		resourceFactories.add(new ResourceDescriptorImpl.Factory());
		crossRefFactories.add(new CrossReferenceDescriptorImpl.Factory());
		setIndex(index);
	}

	public void setIndex(IIndexStore index) {
		this.index = index;
	}

	public void registerCrossReferenceDescriptorFactory(ECrossReferenceDescriptor.Factory factory) {
		crossRefFactories.add(0, factory);
	}

	public void registerElementDescriptorFactory(EObjectDescriptor.Factory factory) {
		elementFactories.add(0, factory);
	}

	public void registerResourceDescriptorFactory(ResourceDescriptor.Factory factory) {
		resourceFactories.add(0, factory);
	}

	public List<EObjectDescriptor> index(Resource resource, boolean isResolveProxies) {
		ResourceDescriptor resourceDescriptor = internalIndexResource(resource);
		return internalIndexResourceContents(resource, isResolveProxies, resourceDescriptor);
	}

	public List<EClassDescriptor> index(EPackage ePackage, boolean isRecurseSubpackages) {
		EPackageDescriptor ePackageDescriptor = internalIndexEPackage(ePackage);
		List<EClassDescriptor> typeDescriptors = internalIndexEPackageContents(ePackage, ePackageDescriptor);
		if (isRecurseSubpackages) {
			for (EPackage subPackage : ePackage.getESubpackages())
				// don't follow cross-resource references
				if (ePackage.eResource() == null || subPackage.eResource() == ePackage.eResource())
					typeDescriptors.addAll(index(subPackage, isRecurseSubpackages));
		}
		// TODO Handle removed sub packages?
		return typeDescriptors;
	}

	protected EPackageDescriptor internalIndexEPackage(EPackage ePackage) {
		EPackageDescriptor ePackageDescriptor = index.ePackageDAO().createQueryEPackage(ePackage).executeSingleResult();
		if (ePackageDescriptor == null) {
			ePackageDescriptor = packageFactory.createDescriptor(ePackage, System.currentTimeMillis());
			index.ePackageDAO().store(ePackageDescriptor);
		}
		return ePackageDescriptor;
	}

	protected List<EClassDescriptor> internalIndexEPackageContents(EPackage ePackage,
			EPackageDescriptor ePackageDescriptor) {
		Collection<EClassDescriptor> oldEClassDescriptors = index.eClassDAO().createQueryEClassesInPackage(
				ePackageDescriptor).executeListResult();
		List<EClassDescriptor> newEClassDescriptors = new ArrayList<EClassDescriptor>();
		MultiMap<EClassDescriptor, EClass> forwardSuperClassMap = new MultiMap<EClassDescriptor, EClass>();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass)
				newEClassDescriptors.add(internalIndexEClass((EClass) eClassifier, ePackageDescriptor,
						oldEClassDescriptors, forwardSuperClassMap));
		}
		for (Entry<EClassDescriptor, Set<EClass>> danglingSuperClassEntry : forwardSuperClassMap.entrySet()) {
			boolean isSuperClassesAdded = false;
			List<EClassDescriptor> superClassDescriptors = new ArrayList<EClassDescriptor>();
			EClassDescriptor subClassDescriptor = danglingSuperClassEntry.getKey();
			EClassDescriptor[] existingSuperClasses = subClassDescriptor.getSuperClasses();
			if (existingSuperClasses != null)
				superClassDescriptors.addAll(Arrays.asList(existingSuperClasses));
			for (EClass danglingSuperClass : danglingSuperClassEntry.getValue()) {
				EClassDescriptor superClassDescriptor = internalIndexSingleEClass(danglingSuperClass);
				if (superClassDescriptor != null) {
					isSuperClassesAdded = true;
					superClassDescriptors.add(superClassDescriptor);
				}
				else {
					error("Cannot index superclass " + danglingSuperClass.getName());
				}
			}
			if (isSuperClassesAdded) {
				index.eClassDAO().delete(subClassDescriptor);
				subClassDescriptor = typeFactory.createDescriptor(subClassDescriptor.getName(), ePackageDescriptor,
						superClassDescriptors.toArray(new EClassDescriptor[superClassDescriptors.size()]));
				index.eClassDAO().store(subClassDescriptor);
			}
		}
		if (oldEClassDescriptors != null)
			for (EClassDescriptor staleClassDescriptor : oldEClassDescriptors) {
				index.eClassDAO().delete(staleClassDescriptor);
			}
		return newEClassDescriptors;
	}

	protected EClassDescriptor internalIndexEClass(EClass eClass, EPackageDescriptor ePackageDescriptor,
			Collection<EClassDescriptor> oldEClassDescriptors, MultiMap<EClassDescriptor, EClass> forwardSuperClassMap) {
		List<EClassDescriptor> indexedSuperClasses = null;
		Set<EClass> forwardSuperClasses = null;
		for (EClass superType : eClass.getEAllSuperTypes()) {
			EClassDescriptor superClassDescriptor = index.eClassDAO().createQueryEClass(superType)
					.executeSingleResult();
			if (superClassDescriptor == null) {
				if (forwardSuperClasses == null)
					forwardSuperClasses = new HashSet<EClass>();
				forwardSuperClasses.add(superType);
			}
			else {
				if (indexedSuperClasses == null)
					indexedSuperClasses = new ArrayList<EClassDescriptor>();
				indexedSuperClasses.add(superClassDescriptor);
			}
		}
		EClassDescriptor[] superClassDescriptors = (indexedSuperClasses == null) ? null : indexedSuperClasses
				.toArray(new EClassDescriptor[indexedSuperClasses.size()]);
		EClassDescriptor typeDescriptor = typeFactory.createDescriptor(eClass, ePackageDescriptor,
				superClassDescriptors);
		if (oldEClassDescriptors == null || !oldEClassDescriptors.remove(typeDescriptor))
			index.eClassDAO().store(typeDescriptor);
		if (forwardSuperClasses != null)
			forwardSuperClassMap.put(typeDescriptor, forwardSuperClasses);
		return typeDescriptor;
	}

	/**
	 * Only for superclasses whose package has not been indexed.
	 * 
	 * @param eClass
	 * @return
	 */
	protected EClassDescriptor internalIndexSingleEClass(EClass eClass) {
		EClassDescriptor existingEClassDescriptor = index.eClassDAO().createQueryEClass(eClass).executeSingleResult();
		if (existingEClassDescriptor != null) {
			return existingEClassDescriptor;
		}
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == null) {
			error("EClass does not have a package");
			return null;
		}
		else {
			EPackageDescriptor ePackageDescriptor = internalIndexEPackage(ePackage);
			// don't store superclasses
			EClassDescriptor typeDescriptor = typeFactory.createDescriptor(eClass, ePackageDescriptor, null);
			index.eClassDAO().store(typeDescriptor);
			return typeDescriptor;
		}
	}

	protected ResourceDescriptor internalIndexResource(Resource resource) {
		ResourceDescriptor resourceDescriptor = index.resourceDAO().createQueryResource(resource).executeSingleResult();
		if (resourceDescriptor == null) {
			for (ResourceDescriptor.Factory resourceDescriptorFactory : resourceFactories) {
				if (resourceDescriptorFactory.isFactoryFor(resource)) {
					resourceDescriptor = resourceDescriptorFactory.createDescriptor(resource, System
							.currentTimeMillis());
					index.resourceDAO().store(resourceDescriptor);
					break;
				}
			}
		}
		if (resourceDescriptor == null) {
			throw new IndexingException("No IResource.Factory for resource ", resource);
		}
		return resourceDescriptor;
	}

	protected List<EObjectDescriptor> internalIndexResourceContents(Resource resource, boolean resolveProxies,
			ResourceDescriptor resourceDescriptor) {
		Collection<EObjectDescriptor> existingElementDescriptors = index.eObjectDAO().createQueryEObjectsInResource(
				resourceDescriptor).executeListResult();
		List<EObjectDescriptor> elementDescriptors = new ArrayList<EObjectDescriptor>();
		for (TreeIterator<EObject> allContents = EcoreUtil.getAllProperContents(resource, resolveProxies); allContents
				.hasNext();) {
			EObject eObject = allContents.next();
			EObjectDescriptor elementDescriptor = internalIndex(eObject, resourceDescriptor, existingElementDescriptors);
			internalIndexCrossReferences(eObject, elementDescriptor);
			elementDescriptors.add(elementDescriptor);
		}
		if (existingElementDescriptors != null) {
			for (EObjectDescriptor staleElementDescriptor : existingElementDescriptors) {
				index.eObjectDAO().delete(staleElementDescriptor);
			}
		}
		return elementDescriptors;
	}

	protected EObjectDescriptor internalIndex(EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource != null) {
			ResourceDescriptor resourceDescriptor = internalIndexResource(resource);
			return internalIndex(eObject, resourceDescriptor, Collections.<EObjectDescriptor> emptyList());
		}
		return null;
	}

	protected EObjectDescriptor internalIndex(EObject eObject, ResourceDescriptor resourceDescriptor,
			Collection<EObjectDescriptor> existingElementDescriptors) {
		if (eObject.eResource() == null)
			return null;
		EClass eClass = eObject.eClass();
		EObjectDescriptor elementDescriptor = index.eObjectDAO().createQueryEObjectInResource(eObject,
				resourceDescriptor).executeSingleResult();
		if (elementDescriptor == null) {
			EClassDescriptor typeDescriptor = index.eClassDAO().createQueryEClass(eClass).executeSingleResult();
			for (EObjectDescriptor.Factory elementFactory : elementFactories) {
				if (elementFactory.isFactoryFor(eClass)) {
					elementDescriptor = elementFactory.createDescriptor(eObject, resourceDescriptor, typeDescriptor);
					if (existingElementDescriptors != null)
						existingElementDescriptors.remove(elementDescriptor);
					index.eObjectDAO().store(elementDescriptor);
					break;
				}
			}
		}
		return elementDescriptor;
	}

	protected void internalIndexCrossReferences(EObject source, EObjectDescriptor sourceDesc) {
		EClass eClass = source.eClass();
		System.out.println(sourceDesc);
		for (ECrossReferenceDescriptor.Factory crossRefFactory : crossRefFactories) {
			if (crossRefFactory.isFactoryFor(eClass)) {
				List<EReference> crossRefs = crossRefFactory.crossReferencesForIndex(eClass);
				if (crossRefs != null)
					for (EReference reference : crossRefs) {
						Collection<ECrossReferenceDescriptor> existingCrossRefDescs = index.eCrossReferenceDAO()
								.createQueryCrossReference(sourceDesc, reference).executeListResult();
						if (!reference.isMany()) {
							EObject target = (EObject) source.eGet(reference);
							if (target != null)
								internalIndexCrossReference(crossRefFactory, sourceDesc, reference, target,
										existingCrossRefDescs);
						}
						else if (source.eIsSet(reference)) {
							List<?> targets = (List<?>) source.eGet(reference);
							for (Iterator<?> i = targets.iterator(); i.hasNext();) {
								EObject target = (EObject) i.next();
								if (target != null)
									internalIndexCrossReference(crossRefFactory, sourceDesc, reference, target,
											existingCrossRefDescs);
							}
						}
						if (existingCrossRefDescs != null)
							for (ECrossReferenceDescriptor staleCrossRefDesc : existingCrossRefDescs)
								index.eCrossReferenceDAO().delete(staleCrossRefDesc);
					}
			}
		}
	}

	protected void internalIndexCrossReference(ECrossReferenceDescriptor.Factory crossRefFactory,
			EObjectDescriptor sourceDesc, EReference reference, EObject target,
			Collection<ECrossReferenceDescriptor> existingCrossRefDescs) {
		if (target.eResource() != null) {
			EObjectDescriptor referencedElementDescriptor = internalIndex(target);
			if (referencedElementDescriptor != null) {
				if (existingCrossRefDescs == null || !existingCrossRefDescs.remove(referencedElementDescriptor)) {
					ECrossReferenceDescriptor crossReferenceDescriptor = crossRefFactory
							.createCrossReferenceDescriptor(sourceDesc, reference.getName(),
									referencedElementDescriptor);
					index.eCrossReferenceDAO().store(crossReferenceDescriptor);
				}
			}
		}
	}

	private void error(String string) {
		// TODO implement platform independent logging strategy
	}
}
