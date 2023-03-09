/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.HashMap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassFinder extends AbstractClassFinder<Class<?>> {

	private static final Class<?> NULL_CLASS;

	static {
		class Null {
		}
		NULL_CLASS = Null.class;
	}

	@SuppressWarnings("serial")
	private static class Cache extends HashMap<String, Class<?>> {
		public Cache() {
			super(500);
			for (Class<?> primitiveType : Primitives.ALL_PRIMITIVE_TYPES) {
				put(primitiveType.getName(), primitiveType);
			}
		}
	}

	public ClassFinder(ClassLoader classLoader) {
		super(classLoader, NULL_CLASS, new Cache());
	}

	@Override
	protected Class<?> forName(String name, ClassLoader classLoader) throws ClassNotFoundException {
		return Class.forName(name, false, classLoader);
	}

}
