/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.EPackageDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EClassTypeDescriptorImpl implements EClassDescriptor {

	private EPackageDescriptor ePackageDescriptor;

	private String name;

	public EClassTypeDescriptorImpl(EClass eClass, EPackageDescriptor ePackageDescriptor) {
		this.ePackageDescriptor = ePackageDescriptor;
		name = eClass.getName();
	}

	public String getDisplayName() {
		return name + " (" + ePackageDescriptor.getNsURI() + ")";
	}

	public String getName() {
		return name;
	}

	public EPackageDescriptor getEPackageDescriptor() {
		return ePackageDescriptor;
	}
	
	@Override
	public String toString() {
		return getDisplayName();
	}

	public static class Factory implements EClassDescriptor.Factory {

		public EClassDescriptor createDescriptor(EClass eClass, EPackageDescriptor ePackageDescriptor) {
			return new EClassTypeDescriptorImpl(eClass, ePackageDescriptor);
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EClassDescriptor) {
			EClassDescriptor typeDescriptor = (EClassDescriptor) obj;
			return hashCode() == obj.hashCode() && name.equals(typeDescriptor.getName())
					&& ePackageDescriptor.equals(typeDescriptor.getEPackageDescriptor());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + 41 * ePackageDescriptor.hashCode();
	}
}
