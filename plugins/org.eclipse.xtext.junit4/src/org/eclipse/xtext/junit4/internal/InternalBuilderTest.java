/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.internal;

import static org.junit.Assert.*;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
public class InternalBuilderTest {

	@Test
	public void test() throws CoreException {
		System.out.println("Build started");
		ResourcesPlugin.getWorkspace().build(
				IncrementalProjectBuilder.FULL_BUILD,  new NullProgressMonitor());
		System.out.println("Build done");
		assertTrue(
				"Problems found",
				ResourcesPlugin.getWorkspace().getRoot().findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE).length == 0);
	}

}
