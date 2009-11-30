package org.eclipse.xtext.junit.util;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.util.StringInputStream;

public class IResourcesSetupUtil {

	public static IWorkspaceRoot root() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	public static IProject createProject(String name) throws CoreException,
			InvocationTargetException, InterruptedException {
		IProject project = root().getProject(name);
		createProject(project);
		return project;
	}

	public static IProject createProject(IProject project) throws CoreException {
		if (!project.exists())
			project.create(monitor());
		project.open(monitor());
		return project;
	}

	public static void addNature(IProject project, String nature)
			throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		// Add the nature
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = nature;
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
	}

	public static void removeNature(IProject project, String nature)
			throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		for (int i = 0; i < natures.length; ++i) {
			if (nature.equals(natures[i])) {
				// Remove the nature
				String[] newNatures = new String[natures.length - 1];
				System.arraycopy(natures, 0, newNatures, 0, i);
				System.arraycopy(natures, i + 1, newNatures, i, natures.length
						- i - 1);
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
				return;
			}
		}

	}

	public static void setReference(final IProject from, final IProject to)
			throws CoreException, InvocationTargetException,
			InterruptedException {
		new org.eclipse.ui.actions.WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				IProjectDescription projectDescription = from.getDescription();
				IProject[] projects = projectDescription
						.getReferencedProjects();
				IProject[] newProjects = new IProject[projects.length + 1];
				System.arraycopy(projects, 0, newProjects, 0, projects.length);
				newProjects[projects.length] = to;
				projectDescription.setReferencedProjects(newProjects);
				from.setDescription(projectDescription, monitor());
			}
		}.run(monitor());
	}
	
	public static void removeReference(final IProject from, final IProject to)
	throws CoreException, InvocationTargetException,
	InterruptedException {
		new org.eclipse.ui.actions.WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor)
			throws CoreException, InvocationTargetException,
			InterruptedException {
				IProjectDescription projectDescription = from.getDescription();
				IProject[] projects = projectDescription
				.getReferencedProjects();
				for (int i = 0; i < projects.length; ++i) {
					if (to.equals(projects[i])) {
						// Remove the nature
						IProject[] newProjects = new IProject[projects.length - 1];
						System.arraycopy(projects, 0, newProjects, 0, i);
						System.arraycopy(projects, i + 1, newProjects, i, projects.length
								- i - 1);
						projectDescription.setReferencedProjects(newProjects);
						from.setDescription(projectDescription, null);
						return;
					}
				}
			}
		}.run(monitor());
	}

	public static IFile createFile(String wsRelativePath, String s)
			throws CoreException, InvocationTargetException,
			InterruptedException {
		return createFile(new Path(wsRelativePath), s);
	}

	public static IFile createFile(IPath wsRelativePath, final String s)
			throws CoreException, InvocationTargetException,
			InterruptedException {
		final IFile file = root().getFile(wsRelativePath);
		new org.eclipse.ui.actions.WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				create(file.getParent());
				file.delete(true, monitor());
				file.create(new StringInputStream(s), true, monitor());
			}

		}.run(monitor());
		return file;
	}

	public static IResource file(String path) {
		return root().findMember(new Path(path));
	}

	private static void create(final IContainer container)
			throws CoreException, InvocationTargetException,
			InterruptedException {
		new org.eclipse.ui.actions.WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				if (!container.exists()) {
					create(container.getParent());
					if (container instanceof IFolder) {
						((IFolder) container).create(true, true, monitor());
					} else {
						IProject iProject = (IProject) container;
						createProject(iProject);
					}
				}
			}
		}.run(monitor());
	}

	public static IProgressMonitor monitor() {
		return new NullProgressMonitor();
	}

	public static void cleanBuild() throws CoreException {
		ResourcesPlugin.getWorkspace().build(
				IncrementalProjectBuilder.CLEAN_BUILD, monitor());
	}

	public static void waitForAutoBuild() {
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD,
						null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	public static void cleanWorkspace() throws CoreException {
		IProject[] projects = root().getProjects();
		for (IProject iProject : projects) {
			if (iProject.exists()) {
				iProject.delete(true,true, monitor());
			}
		}
	}
}
