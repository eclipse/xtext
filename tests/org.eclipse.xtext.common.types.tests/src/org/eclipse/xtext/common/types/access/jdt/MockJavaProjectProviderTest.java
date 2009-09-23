/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IParent;
import org.eclipse.jdt.internal.core.JavaElement;
import org.eclipse.xtext.common.types.access.scenarios.ParameterizedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class MockJavaProjectProviderTest extends TestCase {

	public void testClasspathResolved() throws CoreException {
		IJavaProject javaProject = new MockJavaProjectProvider().getJavaProject(null);
		javaProject.getResolvedClasspath(false);
		assertTrue(expandAndLookFor(javaProject, 0, ParameterizedTypes.class.getSimpleName()));
		
	}
	
	public boolean expandAndLookFor(IJavaElement javaElement, int tab, String input) throws CoreException {
		IJavaElement[] children = null;
		// force opening of element by getting its children
		if (javaElement instanceof IParent) {
			IParent parent = (IParent)javaElement;
			children = parent.getChildren();
		}
		StringBuffer buffer = new StringBuffer(16);
		((JavaElement)javaElement).toStringInfo(tab, buffer);
		System.out.println(buffer);
		boolean result = buffer.indexOf(input) >= 0;
		if (!result) {
			if (children != null) {
				for (int i = 0, length = children.length; i < length; i++) {
					result |= expandAndLookFor(children[i], tab + 1, input);
				}
			}
		}
		return result;
	}
	
}
