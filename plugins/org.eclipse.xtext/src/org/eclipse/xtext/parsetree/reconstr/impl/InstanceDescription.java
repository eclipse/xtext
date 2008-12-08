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
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class InstanceDescription implements IInstanceDescription {

	private int[] next;

	private EObject described;

	private AbstractParseTreeConstructor astSer;

	private BitSet multiFeatures;

	public InstanceDescription(AbstractParseTreeConstructor astSerializer,
			EObject desc) {
		described = desc;
		astSer = astSerializer;
		EList<EStructuralFeature> features = described.eClass()
				.getEAllStructuralFeatures();
		next = new int[features.size()];
		for (int id = 0; id < features.size(); id++) {
			EStructuralFeature f = features.get(id);
			if (f.isMany() && astSer.getTVService().isMixedList(desc, f)) {
				if (multiFeatures == null)
					multiFeatures = new BitSet();
				multiFeatures.set(f.getFeatureID());
				next[id] = firstID(f);
			} else if (!astSer.getTVService().isTransient(described, f, -1)) {
				next[id] = firstID(f);
			} else
				next[id] = -1;
		}
	}

	private int firstID(EStructuralFeature f) {
		return nextID(f, f.isMany() ? ((List<?>) described.eGet(f)).size() : 1);
	}

	private int nextID(EStructuralFeature f, int lastID) {
		if (f.isMany() && multiFeatures != null
				&& multiFeatures.get(f.getFeatureID())) {
			lastID--;
			ITransientValueService ts = astSer.getTVService();
			while (lastID >= 0 && ts.isTransient(described, f, lastID))
				lastID--;
			return lastID;
		} else
			return lastID - 1;
	}

	private InstanceDescription(
			AbstractParseTreeConstructor abstractInternalParseTreeConstructor,
			EObject described, int[] next, BitSet multi) {
		super();
		this.astSer = abstractInternalParseTreeConstructor;
		this.described = described;
		this.next = next;
		this.multiFeatures = multi;
	}

	public IInstanceDescription cloneAndConsume(String feature) {
		EStructuralFeature f = getFeature(feature);
		int[] con = new int[next.length];
		System.arraycopy(next, 0, con, 0, next.length);
		con[f.getFeatureID()] = nextID(f, con[f.getFeatureID()]);
		return new InstanceDescription(astSer, described, con, multiFeatures);
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

	public boolean isConsumable(EStructuralFeature f, boolean allowDefault) {
		return next[f.getFeatureID()] > ((allowDefault && !f.isMany()) ? -2
				: -1);
	}

	public boolean isConsumedWithLastConsumtion(String feature) {
		EStructuralFeature f = getFeature(feature);
		int id = f.getFeatureID();
		for (int i = 0; i < next.length; i++)
			if (((i == id) ? nextID(f, next[i]) : next[i]) > -1)
				return false;
		return true;
	}

	public boolean isInstanceOf(String string) {
		EClass class1 = this.astSer.getFactory().getEClass(string);
		return class1 != null && class1.isSuperTypeOf(getDelegate().eClass());
	}

	@Override
	public String toString() {
		List<String> l = new ArrayList<String>();
		for (EStructuralFeature f : described.eClass()
				.getEAllStructuralFeatures()) {
			Object v = described.eGet(f);
			@SuppressWarnings("unchecked")
			int count = (v instanceof Collection) ? ((Collection) v).size() : 1;
			l.add(f.getName() + ":" + next[f.getFeatureID()] + "/" + count);
		}
		return hashCode() + "/" + described.eClass().getName() + ":"
				+ described.hashCode() + ":" + l;
	}

}