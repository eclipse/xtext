/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PackageBasedMetamodelAccess implements IDeclaredMetamodelAccess {

	private final EPackage pack;
	
	PackageBasedMetamodelAccess(EPackage pack) {
		if (pack == null)
			throw new NullPointerException("pack may not be null");
		this.pack = pack;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.metamodel.AbstractMetamodelAccess#getEClassifier(java.lang.String)
	 */
	public EClassifier getEClassifier(String name) {
		return pack.getEClassifier(name);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.metamodel.AbstractMetamodelAccess#getEClassifiers()
	 */
	public Iterable<EClassifier> getEClassifiers() {
		return pack.getEClassifiers();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.metamodel.AbstractMetamodelAccess#getPackage()
	 */
	public EPackage getPackage() {
		return pack;
	}

}
