/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.IScopedElement;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class ScopedElement extends AbstractScopedElement {
	
	public static  IScopedElement create(String name, EObject element, Object additionalInformation) {
		return new ScopedElement(name,element,additionalInformation);
	}
	
	public static  IScopedElement create(String name, EObject element) {
		return create(name,element,null);
	}
	
	private ScopedElement(String name, EObject element, Object additionalInformation) {
		super();
		this.name = name;
		this.element = element;
		this.additionalInformation = additionalInformation;
	}

	private final String name;
	private final EObject element;
	private final Object additionalInformation;

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
