/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.AbstractEObjectDescription;

public class StringScopeElement extends AbstractEObjectDescription {

	private final String name;

	public StringScopeElement(String name) {
		this.name = name;
	}

	public Object additionalInformation() {
		return null;
	}

	public EObject getEObjectOrProxy() {
		return null;
	}

	public String name() {
		return name;
	}

	public URI getEObjectURI() {
		return null;
	}
	
	public EClass getEClass() {
		return null;
	}

}