/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspace.ProjectOrder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ClasspathEntry;
import org.eclipse.jdt.internal.core.ExternalFoldersManager;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.ui.notification.NameBasedEObjectDescription;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperJdtExtensions;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@SuppressWarnings("restriction")
public class JdtToBeBuiltComputer implements IToBeBuiltComputerContribution {
	
	private final static Logger log = Logger.getLogger(JdtToBeBuiltComputer.class);

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
	
	/**
	 * @since 2.19
	 */
	@Inject
	private SimpleProjectDependencyGraph projectDependencyGraph;
	
	@Singleton
	public static class ModificationStampCache {
		protected Map<String, Long> projectToModificationStamp = Maps.newHashMap();
	}
	
	@Override
	public void removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) {
		if (toBeBuilt.getToBeDeleted().isEmpty() && toBeBuilt.getToBeUpdated().isEmpty())
			return;
		modificationStampCache.projectToModificationStamp.clear();
	}
	
	@Override
	public void updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		if (progress.isCanceled()) {
			throw new OperationCanceledException();
		}
		if (!project.isAccessible())
			return;
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject.exists()) {
			IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
			progress.setWorkRemaining(roots.length);
			final Map<String, Long> updated = Maps.newHashMap();
			ProjectOrder orderedProjects = workspace.computeProjectOrder(workspace.getRoot().getProjects());
			for (final IPackageFragmentRoot root : roots) {
				if (progress.isCanceled())
					throw new OperationCanceledException();
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
	 * By default, handle all fragment roots that are on the class-path, not from the JRE and not a source folder.
	 * 
	 * @see IStorage2UriMapperJdtExtensions#shouldHandle(IPackageFragmentRoot)
	 * @since 2.23
	 */
	protected boolean shouldHandle(IPackageFragmentRoot root) {
		return this.jdtUriMapperExtension.shouldHandle(root);
	}

	@Override
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
	
	@Override
	public boolean updateStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		// nothing to do
		// structural java changes will be queued in a fine grained fashion by the JavaChangeQueueFiller
		return false;
	}
	
	protected void queueJavaChange(String typeName) {
		URI typeURI = URIHelperConstants.OBJECTS_URI.appendSegment(typeName);
		QualifiedName qualifiedName = QualifiedName.create(Strings.split(typeName, '.'));
		NameBasedEObjectDescription nameBasedEObjectDescription = new NameBasedEObjectDescription(qualifiedName);
		TypeResourceDescription oldDescription = new TypeResourceDescription(typeURI, Collections.<IEObjectDescription>singletonList(nameBasedEObjectDescription));
		Delta delta = new ChangedResourceDescriptionDelta(oldDescription, null);
		queuedBuildData.queueChange(delta);
	}

	@Override
	public boolean isPossiblyHandled(IStorage resource) {
		return resource instanceof IJarEntryResource;
	}
	
	/**
	 * Ignores Java output folders when traversing a project.
	 * @return <code>true</code> if the folder is a java output folder. Otherwise <code>false</code>.
	 */
	@Override
	public boolean isRejected(IFolder folder) {
		boolean result = jdtHelper.isFromOutputPath(folder);
		return result;
	}
	
	/**
	 * @since 2.19
	 */
	@Override
	public void addInterestingProjects(IProject thisProject, Set<IProject> result) {
		IJavaProject javaProject = JavaCore.create(thisProject);
		if (javaProject instanceof JavaProject) {
			Set<IProject> requiredProjects = getRequiredProjects((JavaProject) javaProject, thisProject.getWorkspace().getRoot());
			projectDependencyGraph.putDependency(thisProject, requiredProjects);
			result.addAll(requiredProjects);
		}
	}
	
	/**
	 * @since 2.19
	 */
	protected SimpleProjectDependencyGraph getProjectDependencyGraph() {
		return projectDependencyGraph;
	}
	
	// JavaBuilder#build
	protected Set<IProject> getRequiredProjects(JavaProject javaProject, IWorkspaceRoot workspaceRoot) {
		LinkedHashSet<IProject> result = new LinkedHashSet<>();
		ExternalFoldersManager externalFoldersManager = JavaModelManager.getExternalManager();
		try {
			IClasspathEntry[] entries = javaProject.getExpandedClasspath();
			for (int i = 0, l = entries.length; i < l; i++) {
				IClasspathEntry entry = entries[i];
				IPath path = entry.getPath();
				IProject p = null;
				switch (entry.getEntryKind()) {
					case IClasspathEntry.CPE_PROJECT :
						p = workspaceRoot.getProject(path.lastSegment()); // missing projects are considered too
						if (((ClasspathEntry) entry).isOptional() && !JavaProject.hasJavaNature(p)) // except if entry is optional
							p = null;
						break;
					case IClasspathEntry.CPE_LIBRARY :
						if (path.segmentCount() > 0) {
							// some binary resources on the class path can come from projects that are not included in the project references
							IResource resource = workspaceRoot.findMember(path.segment(0));
							if (resource instanceof IProject) {
								p = (IProject) resource;
							} else {
								resource = externalFoldersManager.getFolder(path);
								if (resource != null)
									p = resource.getProject();
							}
						}
				}
				if (p != null)
					result.add(p);
			}
		} catch(JavaModelException e) {
			return result;
		}
		return result;
	}
}
