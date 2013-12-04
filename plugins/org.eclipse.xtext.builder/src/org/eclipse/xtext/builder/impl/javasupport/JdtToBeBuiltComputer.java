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
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspace.ProjectOrder;
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
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperJdtExtensions;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.util.IJdtHelper;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

public class JdtToBeBuiltComputer implements IToBeBuiltComputerContribution {
	
	private final static Logger log = Logger.getLogger(JdtToBeBuiltComputer.class);

	@Inject
	private TypeURIHelper typeURIHelper;
	
	@Inject
	private QueuedBuildData queuedBuildData;
	
	@Inject
	private IWorkspace workspace;
	
	@Inject
	private ModificationStampCache modificationStampCache;
	
	@Inject
	private IJdtHelper jdtHelper;
	
	@Inject
	private UriValidator uriValidator; 
	
	@Inject
	private IStorage2UriMapperJdtExtensions jdtUriMapperExtension;
	
	@Singleton
	public static class ModificationStampCache {
		protected Map<String, Long> projectToModificationStamp = Maps.newHashMap();
	}
	
	public void removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) {
		if (toBeBuilt.getToBeDeleted().isEmpty() && toBeBuilt.getToBeUpdated().isEmpty())
			return;
		modificationStampCache.projectToModificationStamp.clear();
	}
	
	public void updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		if (!project.isAccessible() || progress.isCanceled())
			return;
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject.exists()) {
			IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
			progress.setWorkRemaining(roots.length);
			final Map<String, Long> updated = Maps.newHashMap();
			ProjectOrder orderedProjects = workspace.computeProjectOrder(workspace.getRoot().getProjects());
			for (final IPackageFragmentRoot root : roots) {
				if (progress.isCanceled())
					return;
				if (shouldHandle(root) && !isBuiltByUpstream(root, project, orderedProjects.projects)) {
					Map<URI, IStorage> rootData = jdtUriMapperExtension.getAllEntries(root);
					for (Map.Entry<URI, IStorage> e : rootData.entrySet())
						if (uriValidator.canBuild(e.getKey(), e.getValue())) {
							toBeBuilt.getToBeDeleted().add(e.getKey());
							toBeBuilt.getToBeUpdated().add(e.getKey());
						}
				}
				progress.worked(1);
			}
			synchronized (modificationStampCache) {
				modificationStampCache.projectToModificationStamp.putAll(updated);
			}
		}
	}
	
	protected boolean isBuiltByUpstream(IPackageFragmentRoot root, IProject project, IProject[] projectsInCorrectBuildOrder) {
		for (IProject p : projectsInCorrectBuildOrder) {
			if (p.equals(project))
				return false;
			if (XtextProjectHelper.hasNature(p) && XtextProjectHelper.hasBuilder(p)) {
				IJavaProject javaProject = JavaCore.create(p);
				if (javaProject.exists()) {
					if (javaProject.isOnClasspath(root)) {
						if (log.isTraceEnabled())
							log.trace("Build of project '"+project.getName()+"' skips indexing classpath entry '"+root.getPath()+"' because it already indexed by "+javaProject.getElementName());
						return true;
					}
				}
			}
		}
		return false;
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

	public boolean removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		if (storage instanceof IFile && JavaCore.isJavaLikeFileName(storage.getName())) {
			IJavaElement element = JavaCore.create(((IFile)storage).getParent());
			String fileName = storage.getName();
			String typeName = fileName.substring(0, fileName.lastIndexOf('.'));
			if (element instanceof IPackageFragmentRoot) {
				queueJavaChange(typeName);
				return true;
			} else if (element instanceof IPackageFragment) {
				IPackageFragment packageFragment = (IPackageFragment) element;
				queueJavaChange(packageFragment.getElementName() + "." + typeName);
				return true;
			}
		}
		return false;
	}

	protected void queueJavaChange(String typeName) {
		URI typeURI = typeURIHelper.createResourceURIForFQN(typeName);
		TypeResourceDescription oldDescription = new TypeResourceDescription(typeURI, Collections.<IEObjectDescription>emptyList());
		Delta delta = new ChangedResourceDescriptionDelta(oldDescription, null);
		queuedBuildData.queueChange(delta);
	}

	public boolean isPossiblyHandled(IStorage resource) {
		return resource instanceof IJarEntryResource;
	}
	
	/**
	 * Ignores Java output folders when traversing a project.
	 * @return <code>true</code> if the folder is a java output folder. Otherwise <code>false</code>.
	 */
	public boolean isRejected(IFolder folder) {
		boolean result = jdtHelper.isFromOutputPath(folder);
		return result;
	}
}
