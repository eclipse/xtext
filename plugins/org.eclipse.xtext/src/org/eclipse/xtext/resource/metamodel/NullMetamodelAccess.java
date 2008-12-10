/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.Collections;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class NullMetamodelAccess implements IDeclaredMetamodelAccess{

	static final IDeclaredMetamodelAccess INSTANCE = new NullMetamodelAccess();
	
	public EClassifier getEClassifier(String name) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.metamodel.AbstractMetamodelAccess#getEClassifiers()
	 */
	public Iterable<EClassifier> getEClassifiers() {
		return Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.metamodel.AbstractMetamodelAccess#getPackage()
	 */
	public EPackage getPackage() {
		return null;
	}

	
}
