/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.index.EPackageDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EPackageDescriptorImpl implements EPackageDescriptor {

	private long indexingDate;

	private String nsURI;

	private String name;

	protected EPackageDescriptorImpl(EPackage ePackage, long indexingDate) {
		this.indexingDate = indexingDate;
		this.nsURI = ePackage.getNsURI();
		this.name = ePackage.getName();
	}

	public long getIndexingDate() {
		return indexingDate;
	}

	public String getName() {
		return name;
	}

	public String getNsURI() {
		return nsURI;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EPackageDescriptor) {
			return this.hashCode() == obj.hashCode()
					&& this.nsURI.equals(((EPackageDescriptor) obj).getNsURI());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return nsURI.hashCode();
	}

	public static class Factory implements EPackageDescriptor.Factory {

		public EPackageDescriptor createDescriptor(EPackage ePackage, long indexingDate) {
			return new EPackageDescriptorImpl(ePackage, indexingDate);
		}

		public boolean isFactoryFor(EPackage ePackage) {
			return true;
		}

	}
}
