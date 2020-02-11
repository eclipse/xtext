/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EObjectConsumer implements IEObjectConsumer {

	// private final AbstractParseTreeConstructor astSer;

	private final ITransientValueService transientValueService;

	private final EObject described;

	private BitSet multiFeatures;

	private final int[] nextFeatureId;

	public EObjectConsumer(ITransientValueService transientValueService, EObject described) {
		this.described = described;
		this.transientValueService = transientValueService;
		EList<EStructuralFeature> features = described.eClass().getEAllStructuralFeatures();
		nextFeatureId = new int[features.size()];
		for (int featureId = 0; featureId < features.size(); featureId++) {
			EStructuralFeature feature = features.get(featureId);
			if (feature.isMany() && transientValueService.isCheckElementsIndividually(described, feature)) {
				if (multiFeatures == null)
					multiFeatures = new BitSet();
				multiFeatures.set(featureId);
				nextFeatureId[featureId] = firstID(feature);
			}
			else if (!transientValueService.isTransient(described, feature, -1)) {
				nextFeatureId[featureId] = firstID(feature);
			}
			else
				nextFeatureId[featureId] = -1;
			// System.out.println(id + ":" + f.getName() + " -> " + next[id]);
		}
		// System.out.println("x");
	}

	private EObjectConsumer(ITransientValueService tv, EObject described, int[] next, BitSet multi) {
		super();
		this.transientValueService = tv;
		this.described = described;
		this.nextFeatureId = next;
		this.multiFeatures = multi;
	}

	@Override
	public IEObjectConsumer cloneAndConsume(String featureName) {
		EStructuralFeature feature = getFeature(featureName);
		int[] consumedFeatureId = new int[nextFeatureId.length];
		System.arraycopy(nextFeatureId, 0, consumedFeatureId, 0, nextFeatureId.length);
		int featureId = described.eClass().getFeatureID(feature);
		consumedFeatureId[featureId] = nextID(feature, consumedFeatureId[featureId]);
		return new EObjectConsumer(transientValueService, described, consumedFeatureId, multiFeatures);
	}

	private int firstID(EStructuralFeature feature) {
		return nextID(feature, feature.isMany() ? ((List<?>) described.eGet(feature)).size() : 1);
	}

	@Override
	public Object getConsumable(String featureName, boolean allowDefault) {
		EStructuralFeature feature = getFeature(featureName);
		if (feature != null && isConsumable(feature, allowDefault)) {
			Object get = described.eGet(feature);
			if (feature.isMany()) {
				List<?> list = (List<?>) get;
				get = list.get(nextFeatureId[described.eClass().getFeatureID(feature)]);
			}
			return get;
		}
		return null;
	}

	@Override
	public EObject getEObject() {
		return described;
	}

	private EStructuralFeature getFeature(String feature) {
		return described.eClass().getEStructuralFeature(feature);
	}

	@Override
	public Map<EStructuralFeature, Integer> getUnconsumed() {
		Map<EStructuralFeature, Integer> feature2FeatureId = new LinkedHashMap<EStructuralFeature, Integer>();
		EList<EStructuralFeature> features = described.eClass().getEAllStructuralFeatures();
		for (int id = 0; id < features.size(); id++) {
			if (nextFeatureId[id] > -1)
				feature2FeatureId.put(features.get(id), nextFeatureId[id] + 1);
		}
		return feature2FeatureId;
	}

	public boolean isConsumable(EStructuralFeature feature, boolean allowDefault) {
		return nextFeatureId[described.eClass().getFeatureID(feature)] > ((allowDefault && !feature.isMany()) ? -2 : -1);
	}

	@Override
	public boolean isConsumed() {
		for (int i = 0; i < nextFeatureId.length; i++)
			if (nextFeatureId[i] > -1)
				return false;
		return true;
	}

	@Override
	public boolean isConsumedWithLastConsumtion(String featureName) {
		EStructuralFeature feature = getFeature(featureName);
		int featureId = described.eClass().getFeatureID(feature);
		for (int i = 0; i < nextFeatureId.length; i++)
			if (((i == featureId) ? nextID(feature, nextFeatureId[i]) : nextFeatureId[i]) > -1)
				return false;
		return true;
	}

	@Override
	public boolean isInstanceOf(EClassifier classifier) {
		if (!(classifier instanceof EClass))
			return false;
		if (classifier == EcorePackage.Literals.EOBJECT)
			return true;
		return ((EClass) classifier).isSuperTypeOf(getEObject().eClass());
	}
	
	private int nextID(EStructuralFeature feature, int lastId) {
		int myLastId = lastId;
		if (feature.isMany()) {
			if (multiFeatures != null && multiFeatures.get(described.eClass().getFeatureID(feature))) {
				myLastId--;
				while (myLastId >= 0 && transientValueService.isTransient(described, feature, myLastId))
					myLastId--;
				return myLastId;
			}
		}
		else if (lastId == 0)
			return -2;
		return myLastId - 1;
	}

	@Override
	public String toString() {
		List<String> featureNameAndValues = new ArrayList<String>();
		for (Entry<EStructuralFeature, Integer> feature2IdEntry : getUnconsumed().entrySet()) {
			// Object v = described.eGet(f);
			// @SuppressWarnings("unchecked")
			// int count = (v instanceof Collection) ? ((Collection) v).size() :
			// 1;
			// l.add(f.getName() + ":" + next[f.getFeatureID()] + "/" + count);
			featureNameAndValues.add(feature2IdEntry.getKey().getName() + ":" + feature2IdEntry.getValue().intValue());
		}
		return /* hashCode() + "/" + */described.eClass().getName() + ":" + described.hashCode()
				+ (featureNameAndValues.size() > 0 ? (":" + featureNameAndValues) : "");
	}

}