/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassLoaderFromJar extends URLClassLoader {

	public ClassLoaderFromJar() {
		super(new URL[] { jar() }, createFilteredParent());
	}

	private static URL jar() {
		return ClassLoaderFromJar.class.getClassLoader().getResource("org/eclipse/xtext/common/types/testSetups/testData.jar");
	}
	
	private static ClassLoader createFilteredParent() {
		ClassLoader parent = ClasspathTypeProvider.class.getClassLoader();
		// filtering only necessary when run as plain unit test but doesn't harm in OSGi either.
		ClassLoader filteringParent = new ClassLoader(parent) {
			@Override
			public URL getResource(String name) {
				if (name.startsWith("org/eclipse/xtext/common/types/testSetups")) {
					return null;
				}
				return super.getResource(name);
			}
			@Override
			protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
				if (name.startsWith("org.eclipse.xtext.common.types.testSetups.")) {
					throw new ClassNotFoundException(name);
				}
				return super.loadClass(name, resolve);
			}
		};
		return filteringParent;
	}
	
}
