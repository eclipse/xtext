/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.IScopedElement;

public class StringScopeElement implements IScopedElement {

	private final String name;

	public StringScopeElement(String name) {
		this.name = name;
	}

	public Object additionalInformation() {
		return null;
	}

	public EObject element() {
		return null;
	}

	public String name() {
		return name;
	}

}