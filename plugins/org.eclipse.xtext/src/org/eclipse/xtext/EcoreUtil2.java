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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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

		return null;
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
		List<EClass> ca = new ArrayList<EClass>(classA.getEAllSuperTypes());
		ca.add(classA);
		List<EClass> cb = new ArrayList<EClass>(classB.getEAllSuperTypes());
		cb.add(classB);
		cb.retainAll(ca);
		ca.retainAll(cb);

		List<EClass> intersection = ca;
		Collections.sort(intersection, new EClassTypeHierarchyComparator());

		return intersection;
	}
}
