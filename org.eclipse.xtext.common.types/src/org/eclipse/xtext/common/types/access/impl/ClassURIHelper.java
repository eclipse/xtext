/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.lang.reflect.Type;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassURIHelper implements URIHelperConstants {

	private StringBuilder createURIBuilder() {
		StringBuilder builder = new StringBuilder(48);
		builder.append(URIHelperConstants.PROTOCOL);
		builder.append(':');
		return builder;
	}

	private URI createURI(StringBuilder uriBuilder) {
		return URI.createURI(uriBuilder.toString());
	}

	public URI getFullURI(Type type) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(type, uriBuilder);
		uriBuilder.append('#');
		createFragment(type, uriBuilder);
		return createURI(uriBuilder);
	}
	
	private void createFragment(Type type, StringBuilder uriBuilder) {
		if (type instanceof Class<?>) {
			Class<?> clazz = (Class<?>) type;
			createFragmentForClass(clazz, uriBuilder);
		}
		else {
			throw new IllegalArgumentException("Unexpected type: " + type);
		}
	}

	private void createFragmentForClass(Class<?> clazz, StringBuilder uriBuilder) {
		if (clazz.isArray()) {
			createFragmentForClass(clazz.getComponentType(), uriBuilder);
			uriBuilder.append("[]");
		}
		else {
			uriBuilder.append(clazz.getName());
		}
	}

	private void createResourceURI(Type type, StringBuilder uriBuilder) {
		if (type instanceof Class<?>) {
			Class<?> clazz = (Class<?>) type;
			createResourceURIForClass(clazz, uriBuilder);
		} else {
			throw new IllegalArgumentException("unexpected type: " + type);
		}
	}

	private void createResourceURIForClass(Class<?> clazz, StringBuilder uriBuilder) {
		if (clazz.isArray()) {
			createResourceURIForClass(clazz.getComponentType(), uriBuilder);
		}
		else if (clazz.isMemberClass()) {
			createResourceURIForClass(clazz.getDeclaringClass(), uriBuilder);
		}
		else if (clazz.isPrimitive()) {
			uriBuilder.append(URIHelperConstants.PRIMITIVES);
		}
		else {
			uriBuilder.append(URIHelperConstants.OBJECTS).append(clazz.getName());
		}
	}

}
