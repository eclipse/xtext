package org.eclipse.xtext.ui.tests.util;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.util.StringInputStream;

public class ResourceUtil {

	public static IWorkspaceRoot root() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	public static IProject createProject(final String name) throws Exception {
		new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				IProject project = root().getProject(name);
				if (project.exists())
					project.delete(true, true, monitor);
				project.create(monitor);
				project.open(monitor);
			}
		}.run(null);

		return root().getProject(name);
	}

	public static IFile createFile(final IContainer p, final String name, final String content) throws Exception {
		new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				IFile file = p.getFile(new Path(name));
				file.create(new StringInputStream(content), true, new NullProgressMonitor());
			}
		}.run(null);
		return p.getFile(new Path(name));
	}
}
