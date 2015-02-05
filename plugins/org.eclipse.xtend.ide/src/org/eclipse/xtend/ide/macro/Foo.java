/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.macro;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.launching.IRuntimeClasspathEntry;
import org.eclipse.jdt.launching.JavaRuntime;

/**
 * @author meysholdt - Initial contribution and API
 */
public class Foo {
	public static String[] computeDefaultRuntimeClassPath(IJavaProject jproject) throws CoreException {
		IRuntimeClasspathEntry[] unresolved = JavaRuntime.computeUnresolvedRuntimeClasspath(jproject);
		// 1. remove bootpath entries
		// 2. resolve & translate to local file system paths
		List<String> resolved = new ArrayList<String>(unresolved.length);
		for (int i = 0; i < unresolved.length; i++) {
			IRuntimeClasspathEntry entry = unresolved[i];
			if (entry.getClasspathProperty() == IRuntimeClasspathEntry.USER_CLASSES) {
				IRuntimeClasspathEntry[] entries = JavaRuntime.resolveRuntimeClasspathEntry(entry, jproject);
				for (int j = 0; j < entries.length; j++) {
					long t = System.nanoTime();
					String location = entries[j].getLocation();
					long d = System.nanoTime() - t;
					System.out.println("  getLocation(" + entries[j].getPath() + ") --> " + (((double) d) / 1000000)
							+ "ms");
					if (location != null) {
						resolved.add(location);
					}
				}
			}
		}
		return resolved.toArray(new String[resolved.size()]);
	}

}
