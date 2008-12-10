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
public interface IDeclaredMetamodelAccess {

	/**
	 * @return the referenced package or <code>null<code>
	 */
	EPackage getPackage();
	
	/**
	 * @return the classifiers, that are contained in the metamodel. May never return <code>null</code>
	 */
	Iterable<EClassifier> getEClassifiers();
	
	/**
	 * @param name the name of the classifier
	 * @return the found classifier or <code>null</code>
	 */
	EClassifier getEClassifier(String name);
}
