/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MockJavaProjectProvider implements IJavaProjectProvider {

	private IJavaProject javaProject;

	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		if (javaProject == null)
			throw new IllegalStateException("javaProject is null");
		return javaProject;
	}

	public void setUp() throws Exception {
		javaProject = createJavaProject("myProject");
	}

	public void tearDown() throws Exception {
		if (javaProject != null)
			deleteJavaProject(javaProject);
	}

	public IJavaProject createJavaProject(String projectName) throws CoreException {
		IProject project = createProject(projectName);
		IJavaProject javaProject = makeJavaProject(project);
		return javaProject;
	}

	public IProject createProject(String projectName) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		deleteProject(project);
		project.create(null);
		project.open(null);
		return project;
	}

	public void addProjectReference(IProject referencer, IProject referenced) throws CoreException {
		IProjectDescription description = referencer.getDescription();
		List<IProject> referencedProjects = new ArrayList<IProject>(Arrays.asList(description.getReferencedProjects()));
		referencedProjects.add(referenced);
		IProject[] refProjectsArray = referencedProjects.toArray(new IProject[referencedProjects.size()]);
		description.setReferencedProjects(refProjectsArray);
		referencer.setDescription(description, new NullProgressMonitor());
	}

	public void deleteJavaProject(IJavaProject javaProject) throws CoreException {
		IProject project = javaProject.getProject();
		deleteProject(project);
	}

	public void deleteProject(IProject project) throws CoreException {
		if (project.exists()) {
			if (project.isOpen()) {
				project.close(null);
			}
			project.delete(true, true, null);
		}
	}

	public IJavaProject makeJavaProject(IProject project) throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.save(null, true);
		addProjectNature(project, JavaCore.NATURE_ID);
		addSourceFolder(javaProject, "src");
		addJreClasspathEntry(javaProject);
		return javaProject;
	}

	public void addProjectNature(IProject project, String natureId) throws CoreException {
		IProjectNature existingNature = project.getNature(natureId);
		if (existingNature == null) {
			IProjectDescription projectDescription = project.getDescription();
			String[] natureIds = projectDescription.getNatureIds();
			String[] newNatureIds = new String[natureIds.length + 1];
			System.arraycopy(natureIds, 0, newNatureIds, 0, natureIds.length);
			newNatureIds[natureIds.length] = natureId;
			projectDescription.setNatureIds(newNatureIds);
			project.setDescription(projectDescription, null);
		}
	}

	private void addSourceFolder(IJavaProject javaProject, String folderName) throws CoreException,
			JavaModelException {
		IProject project = javaProject.getProject();
		IPath projectPath = project.getFullPath();

		deleteClaspathEntry(javaProject, projectPath);

		IFolder srcFolder = createSubFolder(project, folderName); //$NON-NLS-1$
		IClasspathEntry srcFolderClasspathEntry = JavaCore.newSourceEntry(srcFolder.getFullPath());
		addToClasspath(javaProject, srcFolderClasspathEntry);
	}

	private void deleteClaspathEntry(IJavaProject javaProject, IPath path) throws JavaModelException {
		IClasspathEntry[] classpath = javaProject.getRawClasspath();
		for (int i = 0; i < classpath.length; ++i) {
			IPath entryPath = classpath[i].getPath();
			if (path.equals(entryPath)) {
				IClasspathEntry[] newClasspath = new IClasspathEntry[classpath.length - 1];
				System.arraycopy(classpath, 0, newClasspath, 0, i);
				System.arraycopy(classpath, i + 1, newClasspath, i, classpath.length - i - 1);
				javaProject.setRawClasspath(newClasspath, null);

			}
		}
	}

	public void addToClasspath(IJavaProject javaProject, IClasspathEntry newClassPathEntry)
			throws JavaModelException {
		IClasspathEntry[] newClassPath;
		IClasspathEntry[] classPath = javaProject.getRawClasspath();
		for (IClasspathEntry classPathEntry : classPath) {
			if (classPathEntry.equals(newClassPathEntry)) {
				return;
			}
		}
		newClassPath = new IClasspathEntry[classPath.length + 1];
		System.arraycopy(classPath, 0, newClassPath, 1, classPath.length);
		newClassPath[0] = newClassPathEntry;
		javaProject.setRawClasspath(newClassPath, null);
	}

	private IFolder createSubFolder(IProject project, String folderName) throws CoreException {
		IFolder folder = project.getFolder(folderName);
		if (folder.exists()) {
			folder.delete(true, null);
		}
		folder.create(true, true, null);
		return folder;
	}

	private void addJreClasspathEntry(IJavaProject javaProject) throws JavaModelException {
		IClasspathEntry existingJreContainerClasspathEntry = getJreContainerClasspathEntry(javaProject);
		if (existingJreContainerClasspathEntry == null) {
			IClasspathEntry defaultJREContainerEntry = JavaRuntime.getDefaultJREContainerEntry();
			addToClasspath(javaProject, defaultJREContainerEntry);
		}
	}

	public IClasspathEntry getJreContainerClasspathEntry(IJavaProject javaProject) throws JavaModelException {
		IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
		for (IClasspathEntry classpathEntry : rawClasspath) {
			int entryKind = classpathEntry.getEntryKind();
			if (entryKind == IClasspathEntry.CPE_CONTAINER) {
				IPath path = classpathEntry.getPath();
				String pathAsString = path.toString();
				if (pathAsString.startsWith(JavaRuntime.JRE_CONTAINER)) {
					return classpathEntry;
				}
			}
		}
		return null;
	}

}
