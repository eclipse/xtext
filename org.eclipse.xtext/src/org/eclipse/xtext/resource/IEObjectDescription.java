/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * An abstract description of an {@link EObject}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public interface IEObjectDescription {
	
	/**
	 * @return the name, this element can be accessed by.
	 */
	QualifiedName getName();

	/**
	 * @return the qualified name of the element. 
	 */
	QualifiedName getQualifiedName();
	
	/**
	 * @return the actual element or a proxy.
	 */
	EObject getEObjectOrProxy();
	
	/**
	 * @return the full URI to the described element
	 */
	URI getEObjectURI();
	
	/**
	 * @return the EClass of the described element.
	 */
	EClass getEClass();
	
	/**
	 * Access to specific user data.
	 * @param key the user data key. May not be <code>null</code>. Unknown keys yield <code>null</code>.
	 * @return the value. May be <code>null</code>.
	 */
	String getUserData(String key);
	
	/**
	 * @return all available user data keys. Never <code>null</code>. 
	 */
	String[] getUserDataKeys();
	
}
