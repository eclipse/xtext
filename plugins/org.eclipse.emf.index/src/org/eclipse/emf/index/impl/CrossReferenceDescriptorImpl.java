/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.ECrossReferenceDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class CrossReferenceDescriptorImpl implements ECrossReferenceDescriptor {

	private EObjectDescriptor source;
	private String referenceName;
	private EObjectDescriptor target;

	public CrossReferenceDescriptorImpl(EObjectDescriptor source, String referenceName, EObjectDescriptor target) {
		super();
		this.source = source;
		this.referenceName = referenceName;
		this.target = target;
	}

	public EObjectDescriptor getSource() {
		return source;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public EObjectDescriptor getTarget() {
		return target;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("(");
		b.append(source);
		b.append(" --");
		b.append(referenceName);
		b.append("--> ");
		b.append(target);
		b.append(")");
		return b.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ECrossReferenceDescriptor) {
			ECrossReferenceDescriptor crossRef = (ECrossReferenceDescriptor) obj;
			return crossRef.hashCode() == hashCode() && this.source.equals(crossRef.getSource())
					&& this.referenceName.equals(crossRef.getReferenceName())
					&& this.target.equals(crossRef.getTarget());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return referenceName.hashCode() + 31 * source.hashCode() + 67 * target.hashCode();
	}

	public static class Factory implements ECrossReferenceDescriptor.Factory {

		public ECrossReferenceDescriptor createCrossReferenceDescriptor(EObjectDescriptor source, String referenceName,
				EObjectDescriptor target) {
			return new CrossReferenceDescriptorImpl(source, referenceName, target);
		}

		public List<EReference> crossReferencesForIndex(EClass eClass) {
			List<EReference> crossReferences = null;
			for (EReference eReference : eClass.getEAllReferences()) {
				if (!eReference.isContainer() && !eReference.isContainment() && !eReference.isDerived()
						&& !eReference.isTransient()) {
					if (crossReferences == null) {
						crossReferences = new ArrayList<EReference>();
					}
					crossReferences.add(eReference);
				}
			}
			return crossReferences;
		}

		public boolean isFactoryFor(EClass eClass) {
			return true;
		}

	}

	/**
	 * Must be notified when a metamodel changes.
	 * 
	 * @author Jan Köhnlein - Initial contribution and API
	 */
	public static class CachingFactory extends Factory {

		private Map<EClass, List<EReference>> cache = new HashMap<EClass, List<EReference>>();;

		public void clearCache() {
			cache.clear();
		}

		public void clearCache(EClass eClass) {
			cache.remove(eClass);
		}

		public List<EReference> crossReferencesForIndex(EClass eClass) {
			List<EReference> crossReferences = cache.get(eClass);
			if (crossReferences == null) {
				crossReferences = super.crossReferencesForIndex(eClass);
				cache.put(eClass, crossReferences);
			}
			return crossReferences;
		}
	}

}
