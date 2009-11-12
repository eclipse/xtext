/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Stable;

/**
 * A description of an EObject.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Stable(since="0.7.0", subClass=AbstractEObjectDescription.class)
public interface IEObjectDescription {
	
	/**
	 * @return the name, this element can be accessed 
	 */
	String name();
	
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
	 * access to specific user data
	 */
	String getUserData(String name);
	
	/**
	 * @return all available user data keys 
	 */
	String[] getUserDataKeys();
}
