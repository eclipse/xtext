/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.eclipse.xtext.crossref.IScopedElement;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * @param <T>
 */
public class ScopedElement<T> implements IScopedElement<T>{
	
	public static <T> IScopedElement<T> create(String name, T element, Object additionalInformation) {
		return new ScopedElement<T>(name,element,additionalInformation);
	}
	
	public static <T> IScopedElement<T> create(String name, T element) {
		return create(name,element,null);
	}
	
	private ScopedElement(String name, T element, Object additionalInformation) {
		super();
		this.name = name;
		this.element = element;
		this.additionalInformation = additionalInformation;
	}

	private String name;
	private T element;
	private Object additionalInformation;

	public Object additionalInformation() {
		return additionalInformation;
	}

	public T element() {
		return element;
	}

	public String name() {
		return name;
	}

}
