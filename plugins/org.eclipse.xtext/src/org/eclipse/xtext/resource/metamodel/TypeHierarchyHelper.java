/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.resource.metamodel.EClassifierInfo.EClassInfo;

/**
 * @author Heiko Behrens - Initial contribution and API
 * 
 */
public class TypeHierarchyHelper {
	private EClassifierInfos infos;
	private Map<EClassInfo, Set<EClassInfo>> subTypesMap = new HashMap<EClassInfo, Set<EClassInfo>>();
	private Set<EClassInfo> rootInfos = new HashSet<EClassInfo>();
	private Set<EClassInfo> traversedTypes = new HashSet<EClassInfo>();

	public TypeHierarchyHelper(EClassifierInfos infos) {
		super();
		this.infos = infos;
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
			for (EClassInfo superInfo : infos.getSuperTypeInfos(classInfo))
				registerSubType(superInfo, classInfo);
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

	public void liftUpFeaturesOf(Collection<EClassInfo> infos) {
		for (EClassInfo info : infos)
			liftUpFeaturesInto(info);
	}

	public void liftUpFeaturesInto(EClassInfo superType) {
		// do not look at types twice (might happen due to multiple inheritance)
		if (traversedTypes.contains(superType))
			return;
		traversedTypes.add(superType);

		Collection<EClassInfo> subTypes = getSubTypesOf(superType);
		if(subTypes.isEmpty())
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
		if (infos.getCompatibleTypeOf(subTypes).equals(superType)) {
			Collection<EStructuralFeature> commonFeatures = getCommonFeatures(subTypes);
			Collection<EStructuralFeature> liftedFeatures = joinFeaturesInto(commonFeatures, superType);
			for (EClassInfo subClassInfo : subTypes)
				removeFeatures(subClassInfo, liftedFeatures);
		}
	}

	private void removeFeatures(EClassInfo info, Collection<EStructuralFeature> features) {
		Collection<EStructuralFeature> featuresToBeRemoved = new HashSet<EStructuralFeature>();
		for (EStructuralFeature feature : info.getEClass().getEStructuralFeatures()) 
			if(containsEqualFeature(features, feature))
				featuresToBeRemoved.add(feature);
		
		info.getEClass().getEStructuralFeatures().removeAll(featuresToBeRemoved);
	}

	private Collection<EStructuralFeature> joinFeaturesInto(Collection<EStructuralFeature> commonFeatures,
			EClassInfo info) {
		Collection<EStructuralFeature> result = new HashSet<EStructuralFeature>();
		for (EStructuralFeature feature : commonFeatures) {
			if (containsEqualFeature(info.getEClass().getEStructuralFeatures(), feature))
				// feature already exists, feature can be lifted, nothing to do
				result.add(feature);
			else if (info.getEClass().getEStructuralFeature(feature.getName()) == null) {
				info.addFeature(feature);
				result.add(feature);
			}

		}
		return result;
	}

	private Collection<EStructuralFeature> getCommonFeatures(Collection<EClassInfo> infos) {
		Collection<EStructuralFeature> result = new HashSet<EStructuralFeature>();

		Iterator<EClassInfo> iterator = infos.iterator();
		if (iterator.hasNext()) {
			EClass eClass = iterator.next().getEClass();
			result.addAll(eClass.getEStructuralFeatures());
		}

		while (iterator.hasNext()) {
			EList<EStructuralFeature> features = iterator.next().getEClass().getEStructuralFeatures();
			result = getCommonFeatures(result, features);
		}

		return result;
	}

	public Collection<EStructuralFeature> getCommonFeatures(Collection<EStructuralFeature> setA,
			EList<EStructuralFeature> setB) {
		Collection<EStructuralFeature> result = new HashSet<EStructuralFeature>();

		for (EStructuralFeature f : setA)
			if (containsEqualFeature(setB, f))
				result.add(f);

		return result;
	}

	private boolean containsEqualFeature(Collection<EStructuralFeature> features, EStructuralFeature feature) {
		for (EStructuralFeature otherFeature : features) {
			if (isFeatureEqualTo(feature, otherFeature))
				return true;
		}
		return false;
	}

	private boolean isFeatureEqualTo(EStructuralFeature f1, EStructuralFeature f2) {
		// TODO make comparison more precise
		// TODO extract into a common place, e.g. EcoreUtil2
		return f1.getName().equals(f2.getName()) && f1.getEType().equals(f2.getEType()) && f1.getLowerBound() == f2.getLowerBound()
				&& f1.getUpperBound() == f2.getUpperBound();
	}

	public void liftUpFeatures() {
		liftUpFeaturesOf(rootInfos);
	}

}
