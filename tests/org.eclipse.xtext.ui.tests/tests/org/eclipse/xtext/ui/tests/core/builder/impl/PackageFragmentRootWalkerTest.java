/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.builder.impl;

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.resource.PackageFragmentRootWalker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PackageFragmentRootWalkerTest extends Assert {
	
	@After
	public void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}
	
	@Test public void testTraversePackageFragmentRoot() throws Exception {
		IJavaProject project = createJavaProject("foo");
		String jarName = "JarWalkerTest.jar";
		IFile file = project.getProject().getFile(jarName);
		file.create(getClass().getResourceAsStream(jarName), true, new NullProgressMonitor());
		addJarToClasspath(project, file);
		
		final Set<IPath> pathes = new HashSet<IPath>();
		PackageFragmentRootWalker<Void> walker = new PackageFragmentRootWalker<Void>() {
			@Override
			protected Void handle(IJarEntryResource jarEntry, TraversalState state) {
				pathes.add(jarEntry.getFullPath());
				return null;
			}
		};
		for (IPackageFragmentRoot root : project.getPackageFragmentRoots()) {
			if (root.getElementName().equals(jarName))
				walker.traverse(root,false);
		}
		assertEquals(3,pathes.size());
	}

}
