/*******************************************************************************
 * __  ___            _
 * \ \/ / |_ _____  __ |_
 *  \  /| __/ _ \ \/ / __|
 *  /  \| |_  __/>  <| |_
 * /_/\_\\__\___/_/\_\\__|
 *
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;

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
	
	/**
	 * copies contents of a resource set into a new one
	 */
	public static <T extends ResourceSet> T clone(T target, ResourceSet source) {
		EList<Resource> resources = source.getResources();
		EcoreUtil.Copier copier = new EcoreUtil.Copier();
		for (Resource resource : resources) {
			Resource resource2 = target.createResource(resource.getURI());
			resource2.getContents().addAll(copier.copyAll(resource.getContents()));
		}
		copier.copyReferences();
		return target;
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

	public static <T> List<T> typeSelect(List<?> elements, Class<T> clazz) {
		List<T> result = new ArrayList<T>();
		for (Object ele : elements) {
			if (ele != null && clazz.isAssignableFrom(ele.getClass())) {
				result.add(clazz.cast(ele));
			}
		}
		return result;
	}

	public static <T> List<T> collect(Collection<? extends EObject> instances, int featureId, Class<T> type) {
		final List<T> result = new ArrayList<T>(instances.size());
		for (EObject obj : instances) {
			if (obj == null)
				throw new NullPointerException("obj may not be null");
			final EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureId);
			if (feature == null)
				throw new NullPointerException("feature may not be null");
			final Object object = obj.eGet(feature);
			if (object!=null)
				result.add(type.cast(object));
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

	public static List<EObject> eAllContentsAsList(Resource resource) {
		List<EObject> result = new ArrayList<EObject>();
		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		return result;
	}

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

//	public static void saveEPackage(final EPackage ePackage, String path) throws IOException {
//		URI uri = URI.createFileURI(path + "/" + ePackage.getName() + ".ecore");
//		Resource metaModelResource = new XMIResourceFactoryImpl().createResource(uri);
//		Map<?, ?> options = Collections.singletonMap(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl() {
//			URI originalBaseURI;
//			@Override
//			public void setBaseURI(URI uri) {
//				this.originalBaseURI = uri;
//				// fake the base uri
//			    super.setBaseURI(URI.createURI(ePackage.getNsURI()));
//			}
//
//			@Override
//			public URI deresolve(URI uri) {
//				if (uri.trimFragment().equals(baseURI))
//					return super.deresolve(uri);
//				if (uri.trimFragment().equals(originalBaseURI))
//					return deresolve(URI.createURI(baseURI.toString() + '#' + uri.fragment()));
//				return uri;
//			}
//		});
//		metaModelResource.getContents().add(ePackage);
//		metaModelResource.save(options);
//	}

	public static String getURIFragment(EObject eObject) {
		Resource resource = eObject.eResource();
		String fragment = resource.getURIFragment(eObject);
		return fragment;
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
		boolean result = f1.getName().equals(f2.getName());
		result &= f1.isMany() == f2.isMany();
		if (f1 instanceof EReference && f2 instanceof EReference)
			result &= ((EReference) f1).isContainment() == ((EReference) f2).isContainment();
		return result;
	}

	public static boolean isFeatureSemanticallyEqualTo(EStructuralFeature f1, EStructuralFeature f2) {
		boolean result = isFeatureSemanticallyEqualApartFromType(f1, f2);
		if (f1 instanceof EReference && f2 instanceof EReference) {
			EClass f1Type = (EClass) f1.getEType();
			EClass f2Type = (EClass) f2.getEType();
			result &= f1Type.isSuperTypeOf(f2Type);
		} else
			result &= f1.getEType().equals(f2.getEType());
		return result;
	}

	public enum FindResult {
		FeatureDoesNotExist, FeatureExists, DifferentFeatureWithSameNameExists
	}

	public static EStructuralFeature findFeatureByName(Collection<EStructuralFeature> features, String name) {
		if (name == null)
			return null;
		for (EStructuralFeature feature : features)
			if (name.equals(feature.getName()))
				return feature;

		return null;
	}
	
	
	public static boolean containsCompatibleFeature(EClass clazz, String name, boolean isMulti, EClassifier type) {
		EStructuralFeature existingFeature = clazz.getEStructuralFeature(name);
		if (existingFeature!=null) {
			boolean many = existingFeature.isMany();
			if (many == isMulti) {
				if (type instanceof EClass && existingFeature.getEType() instanceof EClass) {
					EClass expected = (EClass) type;
					EClass actual = (EClass) existingFeature.getEType();
					return actual.equals(expected) || actual.isSuperTypeOf(expected);
				} else if (type instanceof EDataType && existingFeature.getEType() instanceof EDataType) {
					EDataType expected = (EDataType) type;
					EDataType actual = (EDataType) existingFeature.getEType();
					return actual.equals(expected) || getObjectType(actual.getInstanceClass()).isAssignableFrom(getObjectType(expected.getInstanceClass()));
				}
			}
		}
		return false;
	}
	
	private static Class<?> getObjectType(Class<?> clazzA) {
		if (clazzA.isPrimitive())
        {
          if (clazzA == Boolean.TYPE)
          {
            return Boolean.class;
          }
          else if (clazzA == Integer.TYPE)
          {
            return Integer.class;
          }
          else if (clazzA == Float.TYPE)
          {
            return Float.class;
          }
          else if (clazzA == Byte.TYPE)
          {
            return Byte.class;
          }
          else if (clazzA == Character.TYPE)
          {
            return Character.class;
          }
          else if (clazzA == Double.TYPE)
          {
            return Double.class;
          }
          else if (clazzA == Short.TYPE)
          {
            return Short.class;
          }
          else if (clazzA == Long.TYPE)
          {
            return Long.class;
          }
        }
		return clazzA;
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

	private static void collectAllSuperTypes(Set<EClass> collectedTypes, EClass eClass) {
		for (EClass superType : eClass.getESuperTypes())
			if (collectedTypes.add(superType)) {
				collectAllSuperTypes(collectedTypes, superType);
			}
	}

	/**
	 * In addition to {@link org.eclipse.xtext.xtext.ecoreInference.EClassifierInfos#getAllEClassInfos()} this implementation can
	 * deal with cycles in type hierarchy
	 */
	public static Collection<EClass> getAllSuperTypes(EClass eClass) {
		Set<EClass> allSuperTypes = new HashSet<EClass>();
		collectAllSuperTypes(allSuperTypes, eClass);
		return Collections.unmodifiableSet(allSuperTypes);
	}

	public static boolean isAssignableFrom(EClass target, EClass candidate) {
		return (target.equals(candidate) || target.isSuperTypeOf(candidate));
	}

	public static boolean isAssignableFrom(EClass target, EObject candidate) {
		return isAssignableFrom(target, candidate.eClass());
	}

	@SuppressWarnings("unchecked")
	public static List<EObject> getAllReferencedObjects(EObject referer, EReference reference) {
		if (reference.getUpperBound() == 1) {
			EObject eObject = (EObject) referer.eGet(reference);
			if (null != eObject)
				return Collections.singletonList(eObject);
			return Collections.<EObject>emptyList();
		}
		return (List<EObject>) referer.eGet(reference);
	}

}
