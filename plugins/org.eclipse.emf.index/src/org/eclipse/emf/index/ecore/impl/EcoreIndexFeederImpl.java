/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ecore.impl;

import static org.eclipse.emf.index.util.CollectionUtils.toList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.impl.Logger;
import org.eclipse.emf.index.util.MultiMap;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EcoreIndexFeederImpl implements EcoreIndexFeeder {

	private IIndexStore index;

	public EcoreIndexFeederImpl(IIndexStore index) {
		this.index = index;
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
			ePackageDescriptor = new EPackageDescriptorImpl(ePackage, System.currentTimeMillis());
			index.ePackageDAO().store(ePackageDescriptor);
		}
		return ePackageDescriptor;
	}

	protected List<EClassDescriptor> internalIndexEPackageContents(EPackage ePackage,
			EPackageDescriptor ePackageDescriptor) {
		List<EClassDescriptor> oldEClassDescriptors = toList(index.eClassDAO().createQueryEClassesInPackage(
				ePackageDescriptor).executeListResult());
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
					Logger.logError("Cannot index superclass " + danglingSuperClass.getName());
				}
			}
			if (isSuperClassesAdded) {
				index.eClassDAO().delete(subClassDescriptor);
				subClassDescriptor = new EClassDescriptorImpl(subClassDescriptor.getName(), ePackageDescriptor,
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
		EClassDescriptor typeDescriptor = new EClassDescriptorImpl(eClass, ePackageDescriptor, superClassDescriptors);
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
			Logger.logError("EClass " + eClass.getName() + " does not have a package");
			return null;
		}
		else {
			EPackageDescriptor ePackageDescriptor = internalIndexEPackage(ePackage);
			// don't store superclasses
			EClassDescriptor typeDescriptor = new EClassDescriptorImpl(eClass, ePackageDescriptor, null);
			index.eClassDAO().store(typeDescriptor);
			return typeDescriptor;
		}
	}

}
