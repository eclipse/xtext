/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Heiko Behrens
 */
public class EcoreUtil2 extends EcoreUtil {

	private static Logger log = Logger.getLogger(EcoreUtil2.class);

	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getContainerOfType(EObject ele, Class<T> type) {
		if (type.isAssignableFrom(ele.getClass()))
			return (T) ele;
		if (ele.eContainer() != null)
			return getContainerOfType(ele.eContainer(), type);
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> getAllContentsOfType(EObject ele, Class<T> type) {
		List<T> result = new ArrayList<T>();
		TreeIterator<EObject> allContents = ele.eAllContents();
		while (allContents.hasNext()) {
			EObject object = allContents.next();
			if (type.isAssignableFrom(object.getClass())) {
				result.add((T) object);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> typeSelect(List<?> elements, Class<T> clazz) {
		List<T> result = new ArrayList<T>();
		for (Object ele : elements) {
			if (ele != null && clazz.isAssignableFrom(ele.getClass())) {
				result.add((T) ele);
			}
		}
		return result;
	}

	public static List<EObject> eAllContentsAsList(EObject ele) {
		List<EObject> result = new ArrayList<EObject>();
		TreeIterator<EObject> iterator = ele.eAllContents();
		while (iterator.hasNext())
			result.add(iterator.next());
		return result;
	}

	/**
     */
	public static final EPackage loadEPackage(String uriAsString, ClassLoader classLoader) {
		if (EPackage.Registry.INSTANCE.containsKey(uriAsString))
			return EPackage.Registry.INSTANCE.getEPackage(uriAsString);
		URI uri = URI.createURI(uriAsString);
		uri = new ClassloaderClasspathUriResolver().resolve(classLoader, uri);
		Resource resource = new ResourceSetImpl().getResource(uri, true);
		for (TreeIterator<EObject> allContents = resource.getAllContents(); allContents.hasNext();) {
			EObject next = allContents.next();
			if (next instanceof EPackage) {
				EPackage ePackage = (EPackage) next;
				// if (ePackage.getNsURI() != null &&
				// ePackage.getNsURI().equals(uriAsString)) {
				return ePackage;
				// }
			}
		}
		log.error("Could not load EPackage with nsURI" + uriAsString);
		return null;
	}

	public static void saveEPackage(EPackage ePackage, String path) throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		URI uri = URI.createFileURI(path + "/" + ePackage.getName() + ".ecore");
		Resource metaModelResource = new ResourceSetImpl().createResource(uri);
		metaModelResource.getContents().add(ePackage);
		metaModelResource.save(null);
	}

	public static String getURIFragment(EObject eObject) {
		Resource resource = eObject.eResource();
		String fragment = resource.getURIFragment(eObject);
		return fragment;
	}

	public static EList<EObject> loadModel(String string, ClassLoader classLoader) {
		URI uri = URI.createURI(string);
		XtextResourceSet xtextResourceSet = new XtextResourceSet();
		xtextResourceSet.setClasspathURIContext(classLoader);
		Resource resource = xtextResourceSet.getResource(uri, true);
		return resource.getContents();
	}

	public static EClassifier getCompatibleType(EClassifier typeA, EClassifier typeB) {
		if (typeA.equals(typeB))
			return typeA;
		// no common type for simple datatypes available
		if (!(typeA instanceof EClass && typeB instanceof EClass))
			return null;

		List<EClass> sortedCandidates = getSortedCommonCompatibleTypeCandidates((EClass) typeA, (EClass) typeB);
		for (EClass candidate : sortedCandidates)
			if (isCommonCompatibleType(candidate, sortedCandidates))
				return candidate;

		return EcorePackage.Literals.EOBJECT;
	}

	private static class EClassTypeHierarchyComparator implements Comparator<EClass> {

		public int compare(EClass classA, EClass classB) {
			if (classA.getEAllSuperTypes().contains(classB))
				return -1;
			if (classB.getEAllSuperTypes().contains(classA))
				return 1;
			else
				return 0;
		}
	}

	private static boolean isLooslyCompatibleWith(EClass classA, EClass classB) {
		return classA.equals(classB) || classA.getEAllSuperTypes().contains(classB)
				|| classB.getEAllSuperTypes().contains(classA);
	}

	private static boolean isCommonCompatibleType(EClass candidate, List<EClass> candidates) {
		for (EClass otherCandidate : candidates)
			if (!isLooslyCompatibleWith(candidate, otherCandidate))
				return false;
		return true;
	}

	private static List<EClass> getSortedCommonCompatibleTypeCandidates(EClass classA, EClass classB) {
		List<EClass> result = getCompatibleTypesOf(classA);
		List<EClass> compatibleTypesOfB = getCompatibleTypesOf(classB);
		result.retainAll(compatibleTypesOfB);

		Collections.sort(result, new EClassTypeHierarchyComparator());

		return result;
	}

	public static List<EClass> getCompatibleTypesOf(EClass eClass) {
		List<EClass> ca = new ArrayList<EClass>(eClass.getEAllSuperTypes());
		ca.add(eClass);
		return ca;
	}
	
	public static boolean isFeatureSemanticallyEqualApartFromType(EStructuralFeature f1, EStructuralFeature f2) {
		boolean result = f1.getName().equals(f1.getName());
		result &= f1.getLowerBound() == f2.getLowerBound();
		result &= f1.getUpperBound() == f2.getUpperBound();
		if (f1 instanceof EReference && f2 instanceof EReference)
			result &= ((EReference) f1).isContainment() == ((EReference) f2).isContainment();
		return result;
	}

	public static boolean isFeatureSemanticallyEqualTo(EStructuralFeature f1, EStructuralFeature f2) {
		boolean result = isFeatureSemanticallyEqualApartFromType(f1, f2);
		result &= f1.getEType().equals(f2.getEType());
		return result;
	}

	public enum FindResult {
		FeatureDoesNotExist, FeatureExists, DifferentFeatureWithSameNameExists
	}
	
	public static EStructuralFeature findFeatureByName(Collection<EStructuralFeature> features, String name) {
		for (EStructuralFeature feature : features)
			if(feature.getName().equals(name))
				return feature;
		
		return null;
	}
	
	public static FindResult containsSemanticallyEqualFeature(EClass eClass, EStructuralFeature feature) {
		return containsSemanticallyEqualFeature(eClass.getEAllStructuralFeatures(), feature);
	}

	public static FindResult containsSemanticallyEqualFeature(Collection<EStructuralFeature> features,
			EStructuralFeature feature) {
		EStructuralFeature potentiallyEqualFeature = findFeatureByName(features, feature.getName());
		if (potentiallyEqualFeature == null)
			return FindResult.FeatureDoesNotExist;
		else if (isFeatureSemanticallyEqualTo(potentiallyEqualFeature, feature))
			return FindResult.FeatureExists;
		else
			return FindResult.DifferentFeatureWithSameNameExists;
	}

	public static EStructuralFeature createFeatureAsCloneOf(EStructuralFeature prototype) {
		EStructuralFeature result;
		if (prototype instanceof EReference) {
			EReference prototypeAsReference = (EReference) prototype;
			EReference resultAsReference = EcoreFactory.eINSTANCE.createEReference();
			resultAsReference.setContainment(prototypeAsReference.isContainment());
			result = resultAsReference;
		}
		else if (prototype instanceof EAttribute)
			result = EcoreFactory.eINSTANCE.createEAttribute();
		else
			throw new IllegalArgumentException("Unsupported feature type " + prototype);

		result.setName(prototype.getName());
		result.setEType(prototype.getEType());
		result.setLowerBound(prototype.getLowerBound());
		result.setUpperBound(prototype.getUpperBound());

		return result;
	}

}
