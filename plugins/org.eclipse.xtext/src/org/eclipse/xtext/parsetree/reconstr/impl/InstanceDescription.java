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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;

public class InstanceDescription implements IInstanceDescription {

	/**
	 * 
	 */
	public AbstractParseTreeConstructor parseTreeConstr;

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parsetree.impl.IInstanceDescription#isInstanceOf(java.lang.String)
	 */
	public boolean isInstanceOf(String string) {
		EClass class1 = this.parseTreeConstr.getFactory().getEClass(string);
		return class1 != null && class1.isSuperTypeOf(getDelegate().eClass());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parsetree.impl.IInstanceDescription#isOfType(java.lang.String)
	 */
	public boolean isOfType(String string) {
		EClass class1 = this.parseTreeConstr.getFactory().getEClass(string);
		return class1 != null && class1.equals(getDelegate().eClass());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parsetree.impl.IInstanceDescription#getDelegate()
	 */
	public EObject getDelegate() {
		return described;
	}

	public EObject described;
	public Map<String, Integer> featureConsumedCounter = new HashMap<String, Integer>();

	public InstanceDescription(AbstractParseTreeConstructor abstractInternalParseTreeConstructor, EObject described) {
		super();
		this.parseTreeConstr = abstractInternalParseTreeConstructor;
		if (described == null)
			throw new NullPointerException("described");
		this.described = described;
		EList<EStructuralFeature> features = described.eClass().getEAllStructuralFeatures();
		for (EStructuralFeature f : features) {
			Integer integer = 0;
			if (described.eIsSet(f)) {
				if (f.isMany()) {
					integer = ((List<?>) described.eGet(f)).size();
				} else {
					integer = 1;
				}
			}
			featureConsumedCounter.put(f.getName(), integer);
		}
	}

	private InstanceDescription(AbstractParseTreeConstructor abstractInternalParseTreeConstructor, EObject described, Map<String, Integer> featureConsumedCounter) {
		super();
		this.parseTreeConstr = abstractInternalParseTreeConstructor;
		this.described = described;
		this.featureConsumedCounter = featureConsumedCounter;
	}


	
	@Override
	public String toString() {
		List<String> l = new ArrayList<String>();
		for (Entry<String, Integer> i : featureConsumedCounter.entrySet()) {
			EStructuralFeature f = described.eClass().getEStructuralFeature(
					i.getKey());
			Object v = described.eGet(f);
			@SuppressWarnings("unchecked")
			int count = (v instanceof Collection) ? ((Collection) v).size() : 1;
			l.add(i.getKey() + ":" + i.getValue() + "/" + count);
		}
		return hashCode() + "/" + described.eClass().getName() + ":"
				+ described.hashCode() + ":" + l;
	}

	/**
	 * consumes a value in the given feature and marks it as consumed. For
	 * multiple values (i.e. EStructuralFeature.isMultiple()==true) the values
	 * are consumed reverse starting with the last value in the list.
	 * 
	 * @param feature
	 * @return the consumed value
	 * @throws IllegalStateException
	 *             if the feature is not consumable
	 */
	public Object consume(String feature) {
		if (!isConsumable(feature))
			throw new IllegalStateException(feature + " is not consumable");
		Integer counter = lazyGet(feature);
		EStructuralFeature f = getFeature(feature);
		Object get = described.eGet(f);
		if (f.isMany()) {
			List<?> list = (List<?>) get;
			get = list.get(counter - 1);
		}
		featureConsumedCounter.put(feature, counter - 1);
		return get;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parsetree.impl.IInstanceDescription#get(java.lang.String)
	 */
	public Object get(String feature) {
		Integer counter = lazyGet(feature);
		EStructuralFeature f = getFeature(feature);
		Object get = described.eGet(f);
		if (f.isMany()) {
			List<?> list = (List<?>) get;
			get = list.get(counter);
		}
		return get;
	}

	public boolean checkConsume(String feature) {
		if (!isConsumable(feature))
			return false;
		Integer counter = lazyGet(feature);
		EStructuralFeature f = getFeature(feature);
		Object get = described.eGet(f);
		if (f.isMany()) {
			List<?> list = (List<?>) get;
			get = list.get(counter - 1);
		}
		featureConsumedCounter.put(feature, counter - 1);
		return true;
	}

	private Integer lazyGet(String feature) {
		Integer integer = featureConsumedCounter.get(feature);
		if (integer == null) {
			return 0;
		}
		return integer;
	}

	private EStructuralFeature getFeature(String feature) {
		return described.eClass().getEStructuralFeature(feature);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parsetree.impl.IInstanceDescription#isConsumable(java.lang.String)
	 */
	public boolean isConsumable(String feature) {
		return lazyGet(feature) > 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parsetree.impl.IInstanceDescription#isConsumed()
	 */
	public boolean isConsumed() {
		for (Integer i : featureConsumedCounter.values()) {
			if (i > 0)
				return false;
		}
		return true;
	}

	public IInstanceDescription createClone() {
		return new InstanceDescription(this.parseTreeConstr, described, new HashMap<String, Integer>(featureConsumedCounter));
	}

	public int getConsumed(String feature) {
		EStructuralFeature feature2 = described.eClass().getEStructuralFeature(feature);
		if (feature2.isMany()) {
			return ((Collection<?>)described.eGet(feature2)).size()-featureConsumedCounter.get(feature);
		}
		return 1-featureConsumedCounter.get(feature); 
	}
	
	public String uniqueStateString() {
		StringBuffer buff = new StringBuffer();
		buff.append(getDelegate());
		List<String> features = new ArrayList<String>(featureConsumedCounter.keySet());
		Collections.sort(features);
		for (String f : features) {
			buff.append(f).append(featureConsumedCounter.get(f));
		}
		return buff.toString();
	}

}