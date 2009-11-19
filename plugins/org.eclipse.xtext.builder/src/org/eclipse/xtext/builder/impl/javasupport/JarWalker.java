/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class JarWalker {

	public void traverseAllJars(IProject project) throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject.exists()) {
			IPackageFragmentRoot[] fragmentRoots = javaProject.getAllPackageFragmentRoots();
			for (IPackageFragmentRoot packRoot : fragmentRoots) {
				if (packRoot.isArchive()) {
					traverse(packRoot);
				}
			}
		}
	}

	public void traverse(IPackageFragmentRoot root) throws JavaModelException {
		IJavaElement[] children = root.getChildren();
		for (IJavaElement iJavaElement : children) {
			if (iJavaElement instanceof IPackageFragment) {
				traverse((IPackageFragment) iJavaElement);
			}
		}
		Object[] resources = root.getNonJavaResources();
		for (Object object : resources) {
			if (object instanceof IJarEntryResource) {
				traverse((IJarEntryResource) object);
			}
		}
	}

	private void traverse(IPackageFragment pack) throws JavaModelException {
		IJavaElement[] children = pack.getChildren();
		for (IJavaElement iJavaElement : children) {
			if (iJavaElement instanceof IPackageFragment) {
				traverse((IPackageFragment) iJavaElement);
			}
		}
		Object[] resources = pack.getNonJavaResources();
		for (Object object : resources) {
			if (object instanceof IJarEntryResource) {
				traverse((IJarEntryResource) object);
			}
		}
	}

	protected void traverse(IJarEntryResource jarEntry) {
		if (jarEntry.isFile()) {
			handle(jarEntry);
		} else {
			IJarEntryResource[] children = jarEntry.getChildren();
			for (IJarEntryResource child : children) {
				traverse(child);
			}
		}
	}

	protected abstract void handle(IJarEntryResource jarEntry);

}
