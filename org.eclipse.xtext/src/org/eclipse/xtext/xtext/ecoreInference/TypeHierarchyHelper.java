/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.xtext.ecoreInference.EClassifierInfo.EClassInfo;
import org.eclipse.xtext.xtext.ecoreInference.EClassifierInfo.EClassInfo.FindResult;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class TypeHierarchyHelper {
	private final EClassifierInfos infos;
	private final Map<EClassInfo, Set<EClassInfo>> subTypesMap = Maps.newLinkedHashMap();
	private final Set<EClassInfo> rootInfos = Sets.newLinkedHashSet();
	private final Set<EClassInfo> traversedTypes = Sets.newLinkedHashSet();
	private final ErrorAcceptor errorAcceptor;
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
			result = Sets.newLinkedHashSet();
			subTypesMap.put(info, result);
		}
		return result;
	}

	public void liftUpFeaturesRecursively(Collection<EClassInfo> infos, Map<EClass, Collection<EStructuralFeature>> featuresToRemove) {
		traversedTypes.clear();
		for (EClassInfo info : infos)
			liftUpFeaturesInto(info, featuresToRemove);
	}

	// TODO has multiple inheritance been taken into account?
	@SuppressWarnings("unchecked")
	public void liftUpFeaturesInto(EClassInfo superType, Map<EClass, Collection<EStructuralFeature>> featuresToRemove) {
		// do not look at types twice (might happen due to multiple inheritance)
		if (!traversedTypes.add(superType))
			return;

		Collection<EClassInfo> subTypes = getSubTypesOf(superType);
		if (subTypes.isEmpty())
			return;

		// lift up features recursively, deepest first
		for (EClassInfo subType : subTypes) {
			liftUpFeaturesInto(subType, featuresToRemove);
		}

		// do not modify sealed types
		if (!superType.isGenerated())
			return;

		// only if all subtypes' compatible type is superType itself
		// features can be lifted into superType
		Collection<? extends EClassifierInfo> subTypesAsClassifiers = subTypes;
		if (superType.equals(infos.getCompatibleTypeOf((Collection<EClassifierInfo>) subTypesAsClassifiers))) {
			Collection<EStructuralFeature> commonFeatures = getCommonDirectFeatures(subTypes);
			Collection<EStructuralFeature> liftedFeatures = joinFeaturesInto(commonFeatures, superType);
			for (EClassInfo subClassInfo : subTypes)
				// XXX: we may not remove features at this point, because a subtype may have many supertypes
				//      and a feature may be lifted up into more than supertype
				removeFeatures(subClassInfo, liftedFeatures, featuresToRemove);
		}
	}

	private void removeFeatures(EClassInfo info, Collection<EStructuralFeature> features, Map<EClass, Collection<EStructuralFeature>> featuresToRemove) {
		EClass clazz = info.getEClass();
		Collection<EStructuralFeature> featuresToBeModified = clazz.getEStructuralFeatures();
		Collection<EStructuralFeature> removeUs = Sets.newLinkedHashSet();
		for (Iterator<EStructuralFeature> iterator = featuresToBeModified.iterator(); iterator.hasNext();) {
			EStructuralFeature feature = iterator.next();
			if (info.containsSemanticallyEqualFeature(features, feature) == FindResult.FeatureExists)
				removeUs.add(feature);
		}
		if (!removeUs.isEmpty() ) {
			Collection<EStructuralFeature> prevRemoveUs = featuresToRemove.get(clazz);
			if (prevRemoveUs == null) {
				featuresToRemove.put(clazz, removeUs);
			} else {
				prevRemoveUs.addAll(removeUs);
			}
		}

	}

	private Collection<EStructuralFeature> joinFeaturesInto(Collection<EStructuralFeature> commonFeatures,
			EClassInfo info) {
		Collection<EStructuralFeature> result = Sets.newLinkedHashSet();
		for (EStructuralFeature feature : commonFeatures) {
			FindResult findResult = info.containsSemanticallyEqualFeature(feature);
			if (findResult == FindResult.FeatureDoesNotExist) {
				info.addFeature(feature);
				result.add(feature);
			} else if (findResult == FindResult.FeatureExists) {
				result.add(feature);
			}
		}
		return result;
	}

	private Collection<EStructuralFeature> getCommonDirectFeatures(Collection<EClassInfo> infos) {
		Collection<EStructuralFeature> result = Sets.newLinkedHashSet();

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
		Collection<EStructuralFeature> result = Sets.newLinkedHashSet();

		for (EStructuralFeature f : features) {
			if (info.containsSemanticallyEqualFeature(f) == FindResult.FeatureExists) {
				EStructuralFeature equalFeature = info.getEClass().getEStructuralFeature(f.getName());
				SourceAdapter otherAdapter = SourceAdapter.find(equalFeature);
				if (otherAdapter != null) {
					for(EObject source: otherAdapter.getSources()) {
						SourceAdapter.adapt(f, source);
					}	
				}
				result.add(f);
			}
		}

		return result;
	}

	public void liftUpFeaturesRecursively() {
		traversedTypes.clear();
		final Map<EClass, Collection<EStructuralFeature>> featuresToRemove = Maps.newLinkedHashMap();
		liftUpFeaturesRecursively(rootInfos, featuresToRemove);
		for(Map.Entry<EClass, Collection<EStructuralFeature>> entry: featuresToRemove.entrySet()) {
			entry.getKey().getEStructuralFeatures().removeAll(entry.getValue());
		}
		traversedTypes.clear();
		pushFeaturesUp(infos.getAllEClassInfos());
	}

	private void pushFeaturesUp(Collection<EClassInfo> infos) {
		Set<EClass> traversedClasses = Sets.newLinkedHashSet();
		for(EClassInfo info: infos)
			pushFeaturesUp(info, traversedClasses);
	}

	private void pushFeaturesUp(EClassInfo info, Collection<EClass> traversedClasses) {
		EClass eClass = info.getEClass();
		if (info.isGenerated()) {
			if (traversedClasses.add(eClass)) {
				if (eClass.getESuperTypes().isEmpty())
					return;
				for(EClass superType: eClass.getESuperTypes()) {
					EClassInfo superInfo = (EClassInfo) infos.getInfoOrNull(superType);
					pushFeaturesUp(superInfo, traversedClasses);
				}
				Map<String, EStructuralFeature> allFeatures = Maps.newLinkedHashMap();
				Set<String> skippedNames = Sets.newLinkedHashSet();
				for(EStructuralFeature feature: eClass.getEAllStructuralFeatures()) {
					if (feature.getEContainingClass() != eClass) {
						if (allFeatures.containsKey(feature.getName())) {
							allFeatures.remove(feature.getName());
						} else if (skippedNames.add(feature.getName())) {
							allFeatures.put(feature.getName(), feature);
						}
					}
				}
				Iterator<EStructuralFeature> iter = eClass.getEStructuralFeatures().iterator();
				while(iter.hasNext()) {
					EStructuralFeature declared = iter.next();
					EStructuralFeature existing = allFeatures.get(declared.getName());
					if (existing != null) {
						EClassifier compatibleType = EcoreUtil2.getCompatibleType(declared.getEType(), existing.getEType(), grammar);
						if (compatibleType != null) {
							iter.remove();
							existing.setEType(compatibleType);
						}
					}
				}
			}
		}
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
			if (anySuperTypeContainsSemanticallyEqualFeature(classInfo, iterator.next()))
				iterator.remove();
	}

	private boolean anySuperTypeContainsSemanticallyEqualFeature(EClassInfo classInfo, EStructuralFeature feature) {
		Collection<EStructuralFeature> allSupertypesFeatures = Sets.newLinkedHashSet();
		for (EClass superType : classInfo.getEClass().getEAllSuperTypes())
			allSupertypesFeatures.addAll(superType.getEAllStructuralFeatures());

		return classInfo.containsSemanticallyEqualFeature(allSupertypesFeatures, feature) == FindResult.FeatureExists;
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

}
