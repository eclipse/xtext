/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.builder.impl.StorageUtil;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JdtStorageUtil extends StorageUtil {

	private static final String DELIMITER = ":";
	private static final String JARENTRY_PREFIX = "jarentry:";
	private static final Logger log = Logger.getLogger(JdtStorageUtil.class);
	
	@Override
	public String toExternalString(IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			IJarEntryResource entry = (IJarEntryResource) storage;
			return JARENTRY_PREFIX + entry.getPackageFragmentRoot().getJavaProject().getElementName() + DELIMITER
					+ entry.getPackageFragmentRoot().getElementName() + DELIMITER + entry.getFullPath();
		}
		return super.toExternalString(storage);
	}

	@Override
	public IStorage getStorage(String externalString) {
		IWorkspaceRoot ws = workspaceRoot();
		if (externalString.startsWith(JARENTRY_PREFIX)) {
			try {
				String[] fragments = externalString.split(DELIMITER);
				IJavaProject javaProject = findAccesibleJavaProject(ws, fragments[1]);
				if (!javaProject.exists())
					return null;
				IPackageFragmentRoot root = findPackageFragmentRoot(fragments[2], javaProject);
				if (!root.exists())
					return null;
				
				final String path = fragments[3];
				final ThreadLocal<IJarEntryResource> found = new ThreadLocal<IJarEntryResource>();
				new JarWalker() {
					@Override
					protected void handle(IJarEntryResource jarEntry) {
						if (path.equals(jarEntry.getFullPath().toString()))
							found.set(jarEntry);
					}
				}.traverse(root);
				return found.get();
			} catch (CoreException e) {
				log.error(e.getMessage());
			}
		}
		return super.getStorage(externalString);
	}

	protected IJavaProject findAccesibleJavaProject(IWorkspaceRoot ws, String projectName) throws CoreException {
		IProject project = ws.getProject(projectName);
		if (!project.exists())
			return null;
		if (!project.isOpen())
			project.open(new NullProgressMonitor());
		IJavaProject javaProject = JavaCore.create(project);
		if (!javaProject.exists())
			return null;
		if (!javaProject.isOpen()) {
			javaProject.open(null);
		}
		return javaProject;
	}

	protected IPackageFragmentRoot findPackageFragmentRoot(String name, IJavaProject javaProject)
			throws JavaModelException {
		IPackageFragmentRoot root = null;
		IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
		for (IPackageFragmentRoot iPackageFragmentRoot : roots) {
			if (name.equals(iPackageFragmentRoot.getElementName())) {
				root = iPackageFragmentRoot;
			}
		}
		return root;
	}

	protected IJarEntryResource findIJarEntry(String path, Object[] resources) {
		for (Object object : resources) {
			if (object instanceof IJarEntryResource) {
				IJarEntryResource res = (IJarEntryResource) object;
				if (path.equals(res.getFullPath().toString()))
					return res;
			}
		}
		return null;
	}

}
