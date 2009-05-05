/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtend.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.IScopedElement;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class ScopedElement implements IScopedElement {
	
	private String name;
	private EObject element;
	private Object additionalInformation;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setElement(EObject element) {
		this.element = element;
	}
	
	public void setAdditionalInformation(Object additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public Object additionalInformation() {
		return additionalInformation;
	}

	public EObject element() {
		return element;
	}

	public String name() {
		return name;
	}

}
