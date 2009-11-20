/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.builder.impl.ResourceIndexer;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class JdtResourceIndexer extends ResourceIndexer {

	@Override
	protected String getContainerName(IStorage storage) {
		if (!isOnJavaProject(storage))
			return super.getContainerName(storage);
		
		IPackageFragmentRoot packageFragmentRoot = getPackageFragmentRoot(storage);
		return "java:"+packageFragmentRoot.getElementName();
	}

	private IPackageFragmentRoot getPackageFragmentRoot(IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			return ((IJarEntryResource)storage).getPackageFragmentRoot();
		} else if (storage instanceof IResource) {
			return getPackageFragmentRoot(getJavaProject(storage), (IResource) storage);
		}
		throw new IllegalArgumentException("Couldn't handle "+storage);
	}

	@Override
	protected String getProjectName(IStorage storage) {
		if (!isOnJavaProject(storage))
			return super.getProjectName(storage);
		return getJavaProject(storage).getElementName();
	}

	private boolean isOnJavaProject(IStorage storage) {
		return getJavaProject(storage)!=null;
	}

	private IJavaProject getJavaProject(IStorage storage) {
		if (storage instanceof IResource) {
			IProject project = ((IResource) storage).getProject();
			IJavaProject javaProject = JavaCore.create(project);
			if (javaProject.exists() && getPackageFragmentRoot(javaProject, (IResource)storage)!=null)
				return javaProject;
		} else if (storage instanceof IJarEntryResource) {
			return ((IJarEntryResource)storage).getPackageFragmentRoot().getJavaProject();
		}
		throw new IllegalArgumentException("Couldn't handle storage : "+storage);
	}

	@SuppressWarnings("cast")
	private IPackageFragmentRoot getPackageFragmentRoot(IJavaProject jp, IResource resource) {
		try {
			IPackageFragmentRoot[] roots = jp.getPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
					IResource resource2 = root.getUnderlyingResource();
					if (resource2.contains((IResource) resource))
						return root;
				}
			}
		} catch (JavaModelException jme) {
			throw new WrappedException(jme);
		}
		return null;
	}
}
