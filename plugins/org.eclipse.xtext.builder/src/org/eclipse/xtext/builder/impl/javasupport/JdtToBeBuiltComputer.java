/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
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
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.builder.impl.ToBeBuiltComputer;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.util.IJdtHelper;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

public class JdtToBeBuiltComputer extends ToBeBuiltComputer {
	
	private final static Logger log = Logger.getLogger(JdtToBeBuiltComputer.class);

	@Inject
	private TypeURIHelper typeURIHelper;
	
	@Inject
	private QueuedBuildData queuedBuildData;
	
	@Inject
	private ModificationStampCache modificationStampCache;
	
	@Inject
	private IJdtHelper jdtHelper;
	
	@Inject
	private UriValidator uriValidator; 
	
	@Inject
	private Storage2UriMapperJavaImpl storage2UriMapperJavaImpl;
	
	@Singleton
	public static class ModificationStampCache {
		protected Map<String, Long> projectToModificationStamp = Maps.newHashMap();
	}
	
	@Override
	public ToBeBuilt removeProject(IProject project, IProgressMonitor monitor) {
		ToBeBuilt toBeBuilt = super.removeProject(project, monitor);
		if (toBeBuilt.getToBeDeleted().isEmpty() && toBeBuilt.getToBeUpdated().isEmpty())
			return toBeBuilt;
		modificationStampCache.projectToModificationStamp.clear();
		return toBeBuilt;
	}
	
	@Override
	public ToBeBuilt updateProject(final IProject project, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		final ToBeBuilt toBeBuilt = super.updateProject(project, progress.newChild(1));
		if (!project.isAccessible() || progress.isCanceled())
			return toBeBuilt;
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject.exists()) {
			IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
			progress.setWorkRemaining(roots.length);
			final Map<String, Long> updated = Maps.newHashMap();
			for (final IPackageFragmentRoot root : roots) {
				if (progress.isCanceled())
					return toBeBuilt;
				if (shouldHandle(root)) {
					Map<URI, IStorage> rootData = storage2UriMapperJavaImpl.getAllEntries(root);
					toBeBuilt.getToBeDeleted().addAll(rootData.keySet());
					toBeBuilt.getToBeUpdated().addAll(rootData.keySet());
				}
				progress.worked(1);
			}
			synchronized (modificationStampCache) {
				modificationStampCache.projectToModificationStamp.putAll(updated);
			}
		}
		return toBeBuilt;
	}

	/**
	 * Handle all fragment roots that are on the classpath and not a source folder.
	 */
	private boolean shouldHandle(IPackageFragmentRoot root) {
		try {
			boolean result = !JavaRuntime.newDefaultJREContainerPath().isPrefixOf(root.getRawClasspathEntry().getPath());
			result &= (root.isArchive() || root.isExternal()); 
			return result;
		} catch (JavaModelException ex) {
			if (!ex.isDoesNotExist())
				log.error(ex.getMessage(), ex);
			return false;
		}
	}

	@Override
	public boolean removeStorage(IProgressMonitor monitor, ToBeBuilt toBeBuilt, IStorage storage) {
		if (storage instanceof IFile && JavaCore.isJavaLikeFileName(storage.getFullPath().lastSegment())) {
			IJavaElement element = JavaCore.create(((IFile)storage).getParent());
			String fileName = storage.getFullPath().lastSegment();
			String typeName = fileName.substring(0, fileName.lastIndexOf('.'));
			if (element instanceof IPackageFragmentRoot) {
				queueJavaChange(typeName);
			} else if (element instanceof IPackageFragment) {
				IPackageFragment packageFragment = (IPackageFragment) element;
				queueJavaChange(packageFragment.getElementName() + "." + typeName);
			}
		} else {
			if (!isHandled(storage))
				return true;
			URI uri = getUri(storage);
			if (uri != null) {
				toBeBuilt.getToBeDeleted().add(uri);
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
		if (!uriValidator.isPossiblyManaged(resource))
			return false;
		return (resource instanceof IJarEntryResource) || super.isHandled(resource);
	}
	
	/**
	 * Ignores Java output folders when traversing a project.
	 * @return <code>false</code> if the folder is a java output folder. Otherwise <code>true</code>.
	 */
	@Override
	protected boolean isHandled(IFolder folder) {
		boolean result = super.isHandled(folder) && !jdtHelper.isFromOutputPath(folder);
		return result;
	}
}
