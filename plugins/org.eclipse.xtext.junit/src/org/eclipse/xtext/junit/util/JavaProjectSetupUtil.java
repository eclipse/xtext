package org.eclipse.xtext.junit.util;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;

public class JavaProjectSetupUtil {

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
		IProject project = createProject(projectName);
		IJavaProject javaProject = makeJavaProject(project);
		return javaProject;
	}

	public static IProject createProject(String projectName) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		deleteProject(project);
		project.create(null);
		project.open(null);
		return project;
	}

	public static IFolder deleteSourceFolder(IJavaProject project, String folderPath) throws JavaModelException,
			CoreException {
		IFolder folder = project.getProject().getFolder(folderPath);
		deleteClasspathEntry(project, folder.getFullPath());
		folder.delete(true, monitor());
		return folder;
	}

	public static void addProjectReference(IProject referencer, IProject referenced) throws CoreException {
		IProjectDescription description = referencer.getDescription();
		List<IProject> referencedProjects = new ArrayList<IProject>(Arrays.asList(description.getReferencedProjects()));
		referencedProjects.add(referenced);
		IProject[] refProjectsArray = referencedProjects.toArray(new IProject[referencedProjects.size()]);
		description.setReferencedProjects(refProjectsArray);
		referencer.setDescription(description, new NullProgressMonitor());
	}

	public static void deleteJavaProject(IJavaProject javaProject) throws CoreException {
		IProject project = javaProject.getProject();
		deleteProject(project);
	}

	public static void deleteProject(IProject project) throws CoreException {
		if (project.exists()) {
			if (project.isOpen()) {
				project.close(null);
			}
			project.delete(true, true, null);
		}
	}

	public static IJavaProject makeJavaProject(IProject project) throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.save(null, true);
		addProjectNature(project, JavaCore.NATURE_ID);
		addSourceFolder(javaProject, "src");
		addJreClasspathEntry(javaProject);
		return javaProject;
	}

	public static void addProjectNature(IProject project, String natureId) throws CoreException {
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

	public static IFolder addSourceFolder(IJavaProject javaProject, String folderName) throws CoreException,
			JavaModelException {
		IProject project = javaProject.getProject();
		IPath projectPath = project.getFullPath();

		deleteClasspathEntry(javaProject, projectPath);

		IFolder srcFolder = createSubFolder(project, folderName); //$NON-NLS-1$
		IClasspathEntry srcFolderClasspathEntry = JavaCore.newSourceEntry(srcFolder.getFullPath());
		addToClasspath(javaProject, srcFolderClasspathEntry);
		return srcFolder;
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
	}

	private static IFolder createSubFolder(IProject project, String folderName) throws CoreException {
		IFolder folder = project.getFolder(folderName);
		if (folder.exists()) {
			folder.delete(true, null);
		}
		folder.create(true, true, null);
		return folder;
	}

	private static void addJreClasspathEntry(IJavaProject javaProject) throws JavaModelException {
		IClasspathEntry existingJreContainerClasspathEntry = getJreContainerClasspathEntry(javaProject);
		if (existingJreContainerClasspathEntry == null) {
			IClasspathEntry defaultJREContainerEntry = JavaRuntime.getDefaultJREContainerEntry();
			addToClasspath(javaProject, defaultJREContainerEntry);
		}
	}

	public static IClasspathEntry getJreContainerClasspathEntry(IJavaProject javaProject) throws JavaModelException {
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

	public static File createExternalJar(InputStream data, String nameWithoutJarSuffix) throws IOException,
			FileNotFoundException {
		File tempFile = File.createTempFile(nameWithoutJarSuffix, ".jar");
		tempFile.createNewFile();
		FileOutputStream stream = new FileOutputStream(tempFile);
		int i = -1;
		while ((i = data.read()) != -1)
			stream.write(i);
		stream.close();
		data.close();
		return tempFile;
	}

}
