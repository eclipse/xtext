/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ecore.impl;

import java.io.Serializable;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.index.ecore.EPackageDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EPackageDescriptorImpl implements EPackageDescriptor, Serializable {

	private static final long serialVersionUID = -1515497757095678663L;

	private long indexingDate;

	private String nsURI;

	private String name;
	
	private transient EPackage instance;

	protected EPackageDescriptorImpl(EPackage ePackage, long indexingDate) {
		this.instance = ePackage;
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

	public EPackage getEPackage() {
		if(instance == null) 
			instance = EPackage.Registry.INSTANCE.getEPackage(nsURI);
		return instance;
	}
	
	@Override
	public String toString() {
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

}
