/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import java.util.HashMap;

import org.eclipse.xtext.common.types.access.impl.AbstractClassFinder;
import org.eclipse.xtext.common.types.access.impl.Primitives;

/**
 * Small helper class that allows to find types by their source names,
 * e.g. {@code java.lang.String[]} or {@code int}. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinaryClassFinder extends AbstractClassFinder<BinaryClass> {
	
	private static final BinaryClass NULL_CLASS = new BinaryClass(null, null);

	@SuppressWarnings("serial")
	private static class Cache extends HashMap<String, BinaryClass> {
		public Cache() {
			super(500);
			for (Class<?> primitiveType : Primitives.ALL_PRIMITIVE_TYPES) {
				put(primitiveType.getName(), new BinaryClass.Primitive(primitiveType));
			}
		}
	}
	
	public BinaryClassFinder(ClassLoader classLoader) {
		super(classLoader, NULL_CLASS, new Cache());
	}

	@Override
	protected BinaryClass forName(String binaryName, ClassLoader classLoader) throws ClassNotFoundException {
		return BinaryClass.forName(binaryName, classLoader);
	}

}
