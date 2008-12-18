/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.EcoreUtil2.FindResult;
import org.eclipse.xtext.resource.metamodel.EClassifierInfo.EClassInfo;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class TypeHierarchyHelper {
	private EClassifierInfos infos;
	private Map<EClassInfo, Set<EClassInfo>> subTypesMap = new HashMap<EClassInfo, Set<EClassInfo>>();
	private Set<EClassInfo> rootInfos = new HashSet<EClassInfo>();
	private Set<EClassInfo> traversedTypes = new HashSet<EClassInfo>();
	private ErrorAcceptor errorAcceptor;
	private final Grammar grammar;

	public TypeHierarchyHelper(Grammar grammar, EClassifierInfos infos, ErrorAcceptor errorAcceptor) {
		super();
		this.grammar = grammar;
		this.infos = infos;
		this.errorAcceptor = errorAcceptor;
		collectTypeData();
	}

	private void registerSubType(EClassInfo superType, EClassInfo subType) {
		Set<EClassInfo> subTypes = getSubTypesOf(superType);
		subTypes.add(subType);
	}

	private void collectTypeData() {
		for (EClassInfo classInfo : infos.getAllEClassInfos()) {
				if (classInfo.getEClass().getESuperTypes().isEmpty())
					rootInfos.add(classInfo);
				try {
					for (EClassInfo superInfo : infos.getSuperTypeInfos(classInfo))
						registerSubType(superInfo, classInfo);
				} catch(UnexpectedClassInfoException ex) {
					reportError(ex.getSuperInfo(), ex.getErrorCode(), "Cannot inherit from DataType " + ex.getInfo().getEClassifier().getName());
				}
		}
	}

	public Set<EClassInfo> getSubTypesOf(EClassInfo info) {
		Set<EClassInfo> result = subTypesMap.get(info);
		if (result == null) {
			result = new HashSet<EClassInfo>();
			subTypesMap.put(info, result);
		}
		return result;
	}

	public void liftUpFeaturesRecursively(Collection<EClassInfo> infos) {
		traversedTypes.clear();
		for (EClassInfo info : infos)
			liftUpFeaturesInto(info);
	}

	@SuppressWarnings("unchecked")
	public void liftUpFeaturesInto(EClassInfo superType) {
		// do not look at types twice (might happen due to multiple inheritance)
		if (traversedTypes.contains(superType))
			return;
		traversedTypes.add(superType);

		Collection<EClassInfo> subTypes = getSubTypesOf(superType);
		if (subTypes.isEmpty())
			return;

		// lift up features recursively, deepest first
		for (EClassInfo subType : subTypes) {
			liftUpFeaturesInto(subType);
		}

		// do not modify sealed types
		if (!superType.isGenerated())
			return;

		// only if all subtypes' compatible type is superType itself
		// features can be lifted into superType
		Collection<? extends EClassifierInfo> subTypesAsClassifiers = subTypes;
		if (infos.getCompatibleTypeOf((Collection<EClassifierInfo>) subTypesAsClassifiers).equals(superType)) {
			Collection<EStructuralFeature> commonFeatures = getCommonDirectFeatures(subTypes);
			Collection<EStructuralFeature> liftedFeatures = joinFeaturesInto(commonFeatures, superType);
			for (EClassInfo subClassInfo : subTypes)
				removeFeatures(subClassInfo, liftedFeatures);
		}
	}

	private void removeFeatures(EClassInfo info, Collection<EStructuralFeature> features) {
		Collection<EStructuralFeature> featuresToBeModified = info.getEClass().getEStructuralFeatures();
		for (Iterator<EStructuralFeature> iterator = featuresToBeModified.iterator(); iterator.hasNext();)
			if (EcoreUtil2.containsSemanticallyEqualFeature(features, iterator.next()) == FindResult.FeatureExists)
				iterator.remove();

	}

	private Collection<EStructuralFeature> joinFeaturesInto(Collection<EStructuralFeature> commonFeatures,
			EClassInfo info) {
		Collection<EStructuralFeature> result = new HashSet<EStructuralFeature>();
		for (EStructuralFeature feature : commonFeatures) {
			switch (EcoreUtil2.containsSemanticallyEqualFeature(info.getEClass(), feature)) {
				case FeatureDoesNotExist:
					info.addFeature(feature);
				case FeatureExists:
					result.add(feature);
				default:
					break;
			}
		}
		return result;
	}

	private Collection<EStructuralFeature> getCommonDirectFeatures(Collection<EClassInfo> infos) {
		Collection<EStructuralFeature> result = new HashSet<EStructuralFeature>();

		Iterator<EClassInfo> iterator = infos.iterator();
		if (iterator.hasNext()) {
			EClass eClass = iterator.next().getEClass();
			result.addAll(eClass.getEStructuralFeatures());
		}

		while (iterator.hasNext())
			result = getCommonFeatures(iterator.next(), result);

		return result;
	}

	public Collection<EStructuralFeature> getCommonFeatures(EClassInfo info, Collection<EStructuralFeature> features) {
		Collection<EStructuralFeature> result = new HashSet<EStructuralFeature>();

		for (EStructuralFeature f : features)
			if (EcoreUtil2.containsSemanticallyEqualFeature(info.getEClass(), f) == FindResult.FeatureExists)
				result.add(f);

		return result;
	}

	public void liftUpFeaturesRecursively() {
		traversedTypes.clear();
		liftUpFeaturesRecursively(rootInfos);
	}

	public void removeDuplicateDerivedFeatures() {
		removeDuplicateDerivedFeaturesOf(infos.getAllEClassInfos());
	}

	private void removeDuplicateDerivedFeaturesOf(Collection<EClassInfo> classInfos) {
		for (EClassInfo classInfo : classInfos) {
			removeDuplicateDerivedFeaturesOf(classInfo);
		}
	}

	private void removeDuplicateDerivedFeaturesOf(EClassInfo classInfo) {
		// do not modify sealed types
		if (!classInfo.isGenerated())
			return;

		Collection<EStructuralFeature> features = classInfo.getEClass().getEStructuralFeatures();
		for (Iterator<EStructuralFeature> iterator = features.iterator(); iterator.hasNext();)
			if (anySuperTypeContainsSemanticallyEqualFeature(classInfo.getEClass(), iterator.next()))
				iterator.remove();
	}

	private boolean anySuperTypeContainsSemanticallyEqualFeature(EClass eClass, EStructuralFeature feature) {
		Collection<EStructuralFeature> allSupertypesFeatures = new HashSet<EStructuralFeature>();
		for (EClass superType : eClass.getEAllSuperTypes())
			allSupertypesFeatures.addAll(superType.getEAllStructuralFeatures());

		return EcoreUtil2.containsSemanticallyEqualFeature(allSupertypesFeatures, feature) == FindResult.FeatureExists;
	}

	public void detectEClassesWithCyclesInTypeHierachy() {
		for (EClassInfo info : infos.getAllEClassInfos()) {
			EClass eClass = info.getEClass();
			Collection<EClass> allSuperTypes = EcoreUtil2.getAllSuperTypes(eClass);
			if (allSuperTypes.contains(eClass)) {
				reportError(info, TransformationErrorCode.TypeWithCycleInHierarchy, "Type with cycle in hierarchy: " + eClass.getName());
			}
		}
	}

	private void reportError(EClassifierInfo info, TransformationErrorCode errorCode, String message) {
		if (grammar == null) {
			reportError(errorCode, message, null);
			return;
		}
		List<TypeRef> typeRefs = EcoreUtil2.getAllContentsOfType(grammar, TypeRef.class);
		for(TypeRef typeRef: typeRefs) {
			EClassifierInfo otherInfo = infos.getInfo(typeRef);
			if (otherInfo == info)
				reportError(errorCode, message, typeRef);
		}
	}

	private void reportError(TransformationErrorCode errorCode, String message, EObject object) {
		errorAcceptor.acceptError(errorCode, message, object);
	}

	public void detectDuplicatedFeatures() {
		for (EClassInfo info : infos.getAllEClassInfos()) {
			detectDuplicatedFeature(grammar, info);
		}
	}

	private void detectDuplicatedFeature(Grammar grammar, EClassInfo info) {
		EClass eClass = info.getEClass();
		Collection<EStructuralFeature> directFeatures = eClass.getEStructuralFeatures();
		Collection<EStructuralFeature> allFeatures = new ArrayList<EStructuralFeature>(eClass
				.getEAllStructuralFeatures());
		for (EStructuralFeature feature : directFeatures) {
			allFeatures.remove(feature);
			if (EcoreUtil2.findFeatureByName(allFeatures, feature.getName()) != null)
				reportError(info, TransformationErrorCode.MoreThanOneFeatureWithSameName, "Feature " + feature.getName()
						+ " exists more than once in type hierarchy of " + eClass.getName());
		}
	}

}
