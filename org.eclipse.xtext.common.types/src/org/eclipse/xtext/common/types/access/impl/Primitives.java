/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.Collection;

import com.google.common.collect.ImmutableList;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Primitives {

	public static Class<?> forName(String name) {
		for(Class<?> candidate: ALL_PRIMITIVE_TYPES) {
			if (name.equals(candidate.getName()))
				return candidate;
		}
		return null;
	}
	
	public static final Collection<Class<?>> ALL_PRIMITIVE_TYPES = ImmutableList.of(
		Boolean.TYPE,
		Integer.TYPE,
		Float.TYPE,
		Byte.TYPE,
		Character.TYPE,
		Double.TYPE,
		Short.TYPE,
		Long.TYPE,
		Void.TYPE
	);
	
}
