/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.naming;

import org.eclipse.emf.ecore.EObject;

/**
 * Service to provide a description of the selected object such as a fully qualified name for a class or the method
 * signature.
 * 
 * @author Anton Kosyakov - Initial contribution and API
 * @author Arne Deutsch - Moved/copied to new package and document
 * @since 2.14
 */
public interface ICopyQualifiedNameService {

	/**
	 * Compute a textual description of the selectedElement. Depending on context this might be different.
	 * 
	 * @param selectedElement
	 *            The element to calculate the description for.
	 * @param context
	 *            The context to consider when calculating the description.
	 * @return A textual description of the element. For a class this might be a fully qualified name such as
	 *         "com.mydomain.MyClass" whereas for a method the parameter types might be included such
	 *         "com.mydomain.MyClass.myMethod(String,int)".
	 */
	String getQualifiedName(EObject selectedElement, EObject context);

}
