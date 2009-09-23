/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MockJavaProjectProvider implements IJavaProjectProvider {

	private static IJavaProject javaProject;
	
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		if (javaProject == null)
			throw new IllegalStateException("javaProject is null");
		return javaProject;
	}

	public static void setUp() throws Exception {
		javaProject = createJavaProject("myProject",
				new String[] {
					"org.eclipse.xtext.common.types.tests"
				},
				new String[] {
						JavaCore.NATURE_ID,
						"org.eclipse.pde.PluginNature"
				}
					
		);
	}

	public static void tearDown() throws Exception {
		if (javaProject != null)
			deleteJavaProject(javaProject);
	}
	
	public static IJavaProject createJavaProject(
			final String projectName, 
			String[] requiredBundles,
			String[] projectNatures) {

		IProject project = null;
		IJavaProject javaProject = null;
		try {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			project = workspace.getRoot().getProject(projectName);
			deleteProject(project);

			javaProject = JavaCore.create(project);
			IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(
					projectName);
			project.create(projectDescription, null);
			List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
			projectDescription.setNatureIds(projectNatures);

			final ICommand java = projectDescription.newCommand();
			java.setBuilderName(JavaCore.BUILDER_ID);

			final ICommand manifest = projectDescription.newCommand();
			manifest.setBuilderName("org.eclipse.pde.ManifestBuilder");

			final ICommand schema = projectDescription.newCommand();
			schema.setBuilderName("org.eclipse.pde.SchemaBuilder");

			projectDescription.setBuildSpec(new ICommand[] { java, manifest, schema });

			project.open(null);
			project.setDescription(projectDescription, null);

			classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER")));
			classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));

			javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
					null);

			javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), null);
			createManifest(projectName, requiredBundles, project);
			project.build(IncrementalProjectBuilder.FULL_BUILD, null);
			refresh(javaProject);
		}
		catch (final Exception exception) {
			throw new RuntimeException(exception);
		}
		return javaProject ;
	}
	
	public static void refresh(final IJavaProject javaProject) throws CoreException {
		javaProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		waitForManualRefresh();
	}
	
	public static void waitForManualRefresh() {
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_MANUAL_REFRESH, null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}
	
	private static void createManifest(final String projectName, final String[] requiredBundles,
			final IProject project) throws CoreException {
		final StringBuilder mainContent = new StringBuilder("Manifest-Version: 1.0\n");
		mainContent.append("Bundle-ManifestVersion: 2\n");
		mainContent.append("Bundle-Name: " + projectName + "\n");
		mainContent.append("Bundle-Vendor: My Company\n");
		mainContent.append("Bundle-Version: 1.0.0\n");
		mainContent.append("Bundle-SymbolicName: " + projectName.toLowerCase() + "; singleton:=true\n");
		mainContent.append("Bundle-ActivationPolicy: lazy\n");

		if (requiredBundles.length != 0) {
			mainContent.append("Require-Bundle: ");
		}

		for (Iterator<String> iterator = Arrays.asList(requiredBundles).iterator(); iterator.hasNext();) {
			mainContent.append(" " + iterator.next());
			if (iterator.hasNext()) {
				mainContent.append(",");
			}
			mainContent.append("\n");
		}
		mainContent.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5\n");

		final IFolder metaInf = project.getFolder("META-INF");
		metaInf.create(false, true, null);
		createFile("MANIFEST.MF", metaInf, mainContent.toString());
	}
	
	public static IFile createFile(final String name, final IContainer container, final String content) {
		final IFile file = container.getFile(new Path(name));
		try {
			final InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
			if (file.exists()) {
				file.setContents(stream, true, true, null);
			}
			else {
				file.create(stream, true, null);
			}
			stream.close();
		}
		catch (final Exception e) {
			throw new RuntimeException(e);
		}
		return file;
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

}
