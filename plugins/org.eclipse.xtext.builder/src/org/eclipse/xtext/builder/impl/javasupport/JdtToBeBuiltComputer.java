/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.builder.impl.ToBeBuiltComputer;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.ui.resource.JarEntryLocator;
import org.eclipse.xtext.ui.resource.PackageFragmentRootWalker;

import com.google.inject.Inject;

public class JdtToBeBuiltComputer extends ToBeBuiltComputer {
	
	private final static Logger log = Logger.getLogger(JdtToBeBuiltComputer.class);

	@Inject
	private TypeURIHelper typeURIHelper;
	
	@Inject
	private QueuedBuildData queuedBuildData;
	
	@Override
	public ToBeBuilt updateProject(IProject project, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		final ToBeBuilt toBeBuilt = super.updateProject(project, progress.newChild(1));
		if (!project.isAccessible() || progress.isCanceled())
			return toBeBuilt;
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject.exists()) {
			IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
			progress.setWorkRemaining(roots.length);
			final JarEntryLocator locator = new JarEntryLocator();
			for (final IPackageFragmentRoot root : roots) {
				if (progress.isCanceled())
					return toBeBuilt;
				if (shouldHandle(root)) {
					try {
						new PackageFragmentRootWalker<Void>() {
							@Override
							protected Void handle(IJarEntryResource jarEntry, TraversalState state) {
								URI uri = locator.getURI(root, jarEntry, state);
								if (isValid(uri, jarEntry)) {
									toBeBuilt.getToBeDeleted().add(uri);
									toBeBuilt.getToBeUpdated().add(uri);
								}
								return null;
							}
						}.traverse(root,false);
					} catch (JavaModelException ex) {
						if (!ex.isDoesNotExist())
							log.error(ex.getMessage(), ex);
					}
				}
				progress.worked(1);
			}
		}
		return toBeBuilt;
	}

	private boolean shouldHandle(IPackageFragmentRoot root) {
		try {
			return (!"org.eclipse.jdt.launching.JRE_CONTAINER".equals(root.getRawClasspathEntry().getPath().toString()) && 
					(root.isArchive() || root.isExternal()));
		} catch (JavaModelException ex) {
			if (!ex.isDoesNotExist())
				log.error(ex.getMessage(), ex);
			return false;
		}
	}

	@Override
	public boolean removeStorage(IProgressMonitor monitor, ToBeBuilt toBeBuilt, IStorage storage) {
		if (!isHandled(storage))
			return true;
		URI uri = getUri(storage);
		if (uri != null) {
			toBeBuilt.getToBeDeleted().add(uri);
		} else {
			if (storage instanceof IFile && JavaCore.isJavaLikeFileName(storage.getFullPath().lastSegment())) {
				IJavaElement element = JavaCore.create(((IFile)storage).getParent());
				String fileName = storage.getFullPath().lastSegment();
				String typeName = fileName.substring(0, fileName.lastIndexOf('.'));
				if (element instanceof IPackageFragmentRoot) {
					queueJavaChange(typeName);
				} else {
					IPackageFragment packageFragment = (IPackageFragment) element;
					queueJavaChange(packageFragment.getElementName() + "." + typeName);
				}
			}
		}
		return true;
	}

	protected void queueJavaChange(String typeName) {
		URI typeURI = typeURIHelper.createResourceURIForFQN(typeName);
		TypeResourceDescription oldDescription = new TypeResourceDescription(typeURI, Collections.<IEObjectDescription>emptyList());
		Delta delta = new ChangedResourceDescriptionDelta(oldDescription, null);
		queuedBuildData.queueChanges(Collections.singleton(delta));
	}
	
	@Override
	protected boolean isHandled(IStorage resource) {
		return (resource instanceof IJarEntryResource) || super.isHandled(resource);
	}
}
