/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import junit.framework.TestCase;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MockJavaProjectProviderTest extends TestCase {

	public void testClasspathResolved() throws JavaModelException {
		IJavaProject javaProject = new MockJavaProjectProvider().getJavaProject(null);
		javaProject.getResolvedClasspath(false);
	}
	
}
