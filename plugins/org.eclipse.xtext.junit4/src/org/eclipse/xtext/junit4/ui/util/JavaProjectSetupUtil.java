/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.ui.util;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ClasspathEntry;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.osgi.service.prefs.BackingStoreException;

import com.google.common.collect.Lists;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class JavaProjectSetupUtil {

	private static final String JRE_CONTAINER_1_5 = "org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5";

	public static class TextFile {
		public TextFile(String path, String content) {
			this.path = path;
			this.content = content;
		}

		public String path;
		public String content;
	}

	/**
	 * creates a JarInputStream containing the passed text files. Each Pair<String
	 */
	public static InputStream jarInputStream(TextFile... files) {
		try {
			ByteArrayOutputStream out2 = new ByteArrayOutputStream();
			JarOutputStream jo = new JarOutputStream(new BufferedOutputStream(out2));
			for (TextFile textFile : files) {
				JarEntry je = new JarEntry(textFile.path);
				jo.putNextEntry(je);
				byte[] bytes = textFile.content.getBytes();
				jo.write(bytes, 0, bytes.length);
			}
			jo.close();
			return new ByteArrayInputStream(out2.toByteArray());
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public static IJavaProject createJavaProject(String projectName) throws CoreException {
		IProject project = createSimpleProject(projectName);
		JavaCore.initializeAfterLoad(monitor());
		IJavaProject javaProject = makeJavaProject(project);
		return javaProject;
	}
	
	public static IJavaProject findJavaProject(String projectName) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		if (project != null)
			return JavaCore.create(project);
		return null;
	}

	public static IProject createSimpleProject(String projectName) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		deleteProject(project);
		project.create(null);
		project.open(null);
		return project;
	}

	public static IFolder createExternalFolder(String folderName) throws CoreException {
		IPath externalFolderPath = new Path(folderName);
		IProject externalFoldersProject = JavaModelManager.getExternalManager().getExternalFoldersProject();
		if (!externalFoldersProject.isAccessible()) {
			if (!externalFoldersProject.exists())
				externalFoldersProject.create(monitor());
			externalFoldersProject.open(monitor());
		}
		IFolder result = externalFoldersProject.getFolder(externalFolderPath);
		result.create(true, false, null);
//		JavaModelManager.getExternalManager().addFolder(result.getFullPath());
		return result;
	}
	
	public static void deleteExternalFolder(IFolder folder) throws CoreException {
		JavaModelManager.getExternalManager().removeFolder(folder.getFullPath());
		folder.delete(true, null);
	}
	
	public static IFolder deleteSourceFolder(IJavaProject project, String folderPath) throws JavaModelException,
			CoreException {
		IFolder folder = project.getProject().getFolder(folderPath);
		deleteClasspathEntry(project, folder.getFullPath());
		folder.delete(true, monitor());
		return folder;
	}

	public static void addProjectReference(IJavaProject from, IJavaProject to) throws CoreException {
		addToClasspath(from, JavaCore.newProjectEntry(to.getPath()));
	}
	
	public static void removeProjectReference(IJavaProject from, IJavaProject to) throws CoreException {
		removeFromClasspath(from, IClasspathEntry.CPE_PROJECT, to.getPath());
	}
	
	public static void removeJarFromClasspath(IJavaProject from, IFile to) throws CoreException {
		removeFromClasspath(from, IClasspathEntry.CPE_LIBRARY, to.getFullPath());
	}
	
	public static void removeFromClasspath(IJavaProject from, int entryKind, IPath path) throws CoreException {
		List<IClasspathEntry> classpath = Lists.newArrayList(from.getRawClasspath());
		Iterator<IClasspathEntry> iterator = classpath.iterator();
		while (iterator.hasNext()) {
			IClasspathEntry entry = iterator.next();
			if (entry.getEntryKind() == entryKind) {
				if (entry.getPath().equals(path))
					iterator.remove();
			}
		}
		from.setRawClasspath(classpath.toArray(new IClasspathEntry[classpath.size()]), monitor());
	}

	public static void deleteJavaProject(IJavaProject javaProject) throws CoreException {
		IProject project = javaProject.getProject();
		deleteProject(project);
	}

	public static void deleteProject(IProject project) throws CoreException {
		if (project.exists()) {
			project.delete(true, true, null);
		}
	}

	public static IJavaProject makeJavaProject(IProject project) throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.save(null, true);
		addNature(project, JavaCore.NATURE_ID);
		addSourceFolder(javaProject, "src");
		addJre15ClasspathEntry(javaProject);
		return javaProject;
	}

	public static IFolder addSourceFolder(IJavaProject javaProject, String folderName) throws CoreException,
			JavaModelException {
		return addSourceFolder(javaProject, folderName, null, null);
	}

	public static IFolder addSourceFolder(IJavaProject javaProject, String folderName, String[] inclusionPatterns, String[] exclusionPatterns) throws CoreException,
			JavaModelException {
		
		IProject project = javaProject.getProject();
		IPath projectPath = project.getFullPath();

		deleteClasspathEntry(javaProject, projectPath);

		IFolder srcFolder = createSubFolder(project, folderName); //$NON-NLS-1$
		IClasspathEntry srcFolderClasspathEntry = JavaCore.newSourceEntry(srcFolder.getFullPath(), getInclusionPatterns(inclusionPatterns), getExclusionPatterns(exclusionPatterns), null);
		addToClasspath(javaProject, srcFolderClasspathEntry);
		return srcFolder;
	}

	private static IPath[] getExclusionPatterns(String[] exclusionPatterns) {
		return toPatterns(exclusionPatterns, ClasspathEntry.EXCLUDE_NONE);
	}

	private static IPath[] getInclusionPatterns(String[] inclusionPatterns) {
		return toPatterns(inclusionPatterns, ClasspathEntry.INCLUDE_ALL);
	}

	private static IPath[] toPatterns(String[] patterns, IPath[] defaultResult) {
		if (patterns == null || patterns.length == 0) {
			return defaultResult;
		}
		IPath[] result = new IPath[patterns.length];
		for (int i = 0; i < patterns.length; i++) {
			result[i] = new Path(patterns[i]);
		}
		return result;
	}

	public static void deleteClasspathEntry(IJavaProject javaProject, IPath path) throws JavaModelException {
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

	public static void addToClasspath(IJavaProject javaProject, IClasspathEntry newClassPathEntry)
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
		waitForAutoBuild();
	}

	public static IFolder createSubFolder(IProject project, String folderName) throws CoreException {
		IFolder folder = project.getFolder(folderName);
		if (folder.exists()) {
			folder.delete(true, null);
		}
		folder.create(true, true, null);
		return folder;
	}

	public static void addJre15ClasspathEntry(IJavaProject javaProject) throws JavaModelException {
		IClasspathEntry existingJreContainerClasspathEntry = getJreContainerClasspathEntry(javaProject);
		if (existingJreContainerClasspathEntry == null) {
			addToClasspath(javaProject, JavaCore.newContainerEntry(new Path(JRE_CONTAINER_1_5)));
		}
	}
	
	public static void makeJava5Compliant(IJavaProject javaProject) {
		@SuppressWarnings("unchecked")
		Map<String, String> options= javaProject.getOptions(false);
		options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_5);
		options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_5);
		options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_5);
		options.put(JavaCore.COMPILER_PB_ASSERT_IDENTIFIER, JavaCore.ERROR);
		options.put(JavaCore.COMPILER_PB_ENUM_IDENTIFIER, JavaCore.ERROR);
		options.put(JavaCore.COMPILER_CODEGEN_INLINE_JSR_BYTECODE, JavaCore.ENABLED);
		options.put(JavaCore.COMPILER_LOCAL_VARIABLE_ATTR, JavaCore.GENERATE);
		options.put(JavaCore.COMPILER_LINE_NUMBER_ATTR, JavaCore.GENERATE);
		options.put(JavaCore.COMPILER_SOURCE_FILE_ATTR, JavaCore.GENERATE);
		options.put(JavaCore.COMPILER_CODEGEN_UNUSED_LOCAL, JavaCore.PRESERVE);
		javaProject.setOptions(options);
	}

	public static IClasspathEntry getJreContainerClasspathEntry(IJavaProject javaProject) throws JavaModelException {
		IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
		for (IClasspathEntry classpathEntry : rawClasspath) {
			int entryKind = classpathEntry.getEntryKind();
			if (entryKind == IClasspathEntry.CPE_CONTAINER) {
				IPath path = classpathEntry.getPath();
				String pathAsString = path.toString();
				if (pathAsString.startsWith(JRE_CONTAINER_1_5)) {
					return classpathEntry;
				}
			}
		}
		return null;
	}

	public static IClasspathEntry addPlatformJarToClasspath(final Plugin srcPlugin, final String jarFileName,
			final IJavaProject destProject) throws JavaModelException, IOException {
		final IPath jarFilePath = PluginUtil.findPathInPlugin(srcPlugin, jarFileName);
		final IClasspathEntry newLibraryEntry = JavaCore.newLibraryEntry(jarFilePath, null, null);
		addToClasspath(destProject, newLibraryEntry);
		return newLibraryEntry;
	}

	public static IClasspathEntry addJarToClasspath(IJavaProject javaProject, IFile jarFile) throws JavaModelException {
		IClasspathEntry newLibraryEntry = JavaCore.newLibraryEntry(jarFile.getFullPath(), null, null);
		addToClasspath(javaProject, newLibraryEntry);
		return newLibraryEntry;
	}
	
	public static IClasspathEntry addExternalFolderToClasspath(IJavaProject javaProject, IFolder folder) throws JavaModelException {
		IClasspathEntry newLibraryEntry = JavaCore.newLibraryEntry(folder.getLocation(), null, null);
		addToClasspath(javaProject, newLibraryEntry);
		return newLibraryEntry;
	}

	public static File createExternalJar(InputStream data, String nameWithoutJarSuffix) throws IOException,
			FileNotFoundException {
		File tempFile = File.createTempFile(nameWithoutJarSuffix, ".jar");
		tempFile.createNewFile();
		tempFile.deleteOnExit();
		FileOutputStream stream = new FileOutputStream(tempFile);
		int i = -1;
		while ((i = data.read()) != -1)
			stream.write(i);
		stream.close();
		data.close();
		return tempFile;
	}
	
	public static void setUnixLineEndings(IProject project) {
		IEclipsePreferences prefs = new ProjectScope(project).getNode(Platform.PI_RUNTIME);
		prefs.put(Platform.PREF_LINE_SEPARATOR, "\n");
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			throw new RuntimeException(e);
		}
	}

}
