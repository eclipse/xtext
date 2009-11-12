/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.AbstractEObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class ScopedElement extends AbstractEObjectDescription {

	protected ScopedElement(String name, EObject element, Map<String, String> userData) {
		this.name = name;
		this.element = element;
		this.userData = userData;
	}

	public static IEObjectDescription create(String name, EObject element, Map<String, String> userData) {
		return new ScopedElement(name, element, userData);
	}
	
	public static IEObjectDescription create(String name, EObject element) {
		return create(name, element, Collections.<String,String>emptyMap());
	}

	private final Map<String, String> userData;
	private final String name;
	private final EObject element;

	public EObject getEObjectOrProxy() {
		return element;
	}

	public URI getEObjectURI() {
		return EcoreUtil.getURI(element);
	}

	public String name() {
		return name;
	}
	
	@Override
	public String getUserData(String name) {
		return userData.get(name);
	}
	
	@Override
	public String[] getUserDataKeys() {
		return userData.keySet().toArray(new String[userData.size()]);
	}

	public EClass getEClass() {
		return element.eClass();
	}

}
