/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassURIHelper {

	public static final String PRIMITIVES = "/Primitives";
	public static final String OBJECTS = "/Objects/";
	public static final String PROTOCOL = "java";
	
	public URI createResourceURI(Class<?> clazz) {
		if (clazz.isArray())
			return createResourceURI(clazz.getComponentType());
		if (clazz.isMemberClass())
			return createResourceURI(clazz.getDeclaringClass());
		if (clazz.isPrimitive()) {
			return createResourceURI(ClassURIHelper.PRIMITIVES); 
		}
		return createResourceURI(ClassURIHelper.OBJECTS + clazz.getName());
	}

	public URI createResourceURI(String fqn) {
		return URI.createURI(ClassURIHelper.PROTOCOL + ":" + fqn);
	}

	public String getFragment(Class<?> clazz) {
		if (clazz.isArray()) {
			return getFragment(clazz.getComponentType()) + "[]";
		}
		return clazz.getName();
	}

}
