/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class InstanceDescription implements IInstanceDescription {

	// private final AbstractParseTreeConstructor astSer;

	private final ITransientValueService tv;

	private final EObject described;

	private BitSet multiFeatures;

	private final int[] next;

	public InstanceDescription(ITransientValueService t, EObject desc) {
		described = desc;
		tv = t;
		EList<EStructuralFeature> features = described.eClass()
				.getEAllStructuralFeatures();
		next = new int[features.size()];
		for (int id = 0; id < features.size(); id++) {
			EStructuralFeature f = features.get(id);
			if (f.isMany() && tv.isMixedList(desc, f)) {
				if (multiFeatures == null)
					multiFeatures = new BitSet();
				multiFeatures.set(f.getFeatureID());
				next[id] = firstID(f);
			} else if (!tv.isTransient(described, f, -1)) {
				next[id] = firstID(f);
			} else
				next[id] = -1;
			// System.out.println(id + ":" + f.getName() + " -> " + next[id]);
		}
		// System.out.println("x");
	}

	private InstanceDescription(ITransientValueService tv, EObject described,
			int[] next, BitSet multi) {
		super();
		this.tv = tv;
		this.described = described;
		this.next = next;
		this.multiFeatures = multi;
	}

	public IInstanceDescription cloneAndConsume(String feature) {
		EStructuralFeature f = getFeature(feature);
		int[] con = new int[next.length];
		System.arraycopy(next, 0, con, 0, next.length);
		con[f.getFeatureID()] = nextID(f, con[f.getFeatureID()]);
		return new InstanceDescription(tv, described, con, multiFeatures);
	}

	private int firstID(EStructuralFeature f) {
		return nextID(f, f.isMany() ? ((List<?>) described.eGet(f)).size() : 1);
	}

	public Object getConsumable(String feature, boolean allowDefault) {
		EStructuralFeature f = getFeature(feature);
		if (f != null && isConsumable(f, allowDefault)) {
			Object get = described.eGet(f);
			if (f.isMany()) {
				List<?> list = (List<?>) get;
				get = list.get(next[f.getFeatureID()]);
			}
			return get;
		}
		return null;
	}

	public EObject getDelegate() {
		return described;
	}

	private EStructuralFeature getFeature(String feature) {
		return described.eClass().getEStructuralFeature(feature);
	}

	public Map<EStructuralFeature, Integer> getUnconsumed() {
		Map<EStructuralFeature, Integer> m = new HashMap<EStructuralFeature, Integer>();
		EList<EStructuralFeature> features = described.eClass()
				.getEAllStructuralFeatures();
		for (int id = 0; id < features.size(); id++) {
			if (next[id] > -1)
				m.put(features.get(id), next[id] + 1);
		}
		return m;
	}

	public boolean isConsumable(EStructuralFeature f, boolean allowDefault) {
		return next[f.getFeatureID()] > ((allowDefault && !f.isMany()) ? -2
				: -1);
	}

	public boolean isConsumed() {
		for (int i = 0; i < next.length; i++)
			if (next[i] > -1)
				return false;
		return true;
	}

	public boolean isConsumedWithLastConsumtion(String feature) {
		EStructuralFeature f = getFeature(feature);
		int id = f.getFeatureID();
		for (int i = 0; i < next.length; i++)
			if (((i == id) ? nextID(f, next[i]) : next[i]) > -1)
				return false;
		return true;
	}

	public boolean isInstanceOf(EClassifier classifier) {
		if (!(classifier instanceof EClass))
			return false;
		return ((EClass) classifier).isSuperTypeOf(getDelegate().eClass());
	}

	private int nextID(EStructuralFeature f, int lastId) {
		int myLastId = lastId;
		if (f.isMany()) {
			if (multiFeatures != null && multiFeatures.get(f.getFeatureID())) {
				myLastId--;
				while (myLastId >= 0 && tv.isTransient(described, f, myLastId))
					myLastId--;
				return myLastId;
			}
		} else if (lastId == 0)
			return -2;
		return myLastId - 1;
	}

	@Override
	public String toString() {
		List<String> l = new ArrayList<String>();
		for (Entry<EStructuralFeature, Integer> f : getUnconsumed().entrySet()) {
			// Object v = described.eGet(f);
			// @SuppressWarnings("unchecked")
			// int count = (v instanceof Collection) ? ((Collection) v).size() :
			// 1;
			// l.add(f.getName() + ":" + next[f.getFeatureID()] + "/" + count);
			l.add(f.getKey().getName() + ":" + f.getValue().intValue());
		}
		return /* hashCode() + "/" + */described.eClass().getName() + ":"
				+ described.hashCode() + (l.size() > 0 ? (":" + l) : "");
	}

}