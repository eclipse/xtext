package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

public class Workspace extends Container<IWorkspaceRoot> {

	public Workspace() {
	}

	public void cleanWorkspace() throws CoreException {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = projects.length - 1; i >= 0; i--)
			projects[i].delete(true, new NullProgressMonitor());
	}

	public void configureWorkspace(final IFileSetupContext ctx) throws Exception {
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				try {
					configure(ctx, root);
					createMembers(ctx, root);
				} catch (IOException e) {
					throw new CoreException(new Status(IStatus.ERROR, "", "Error initializing test workspace", e));
				}
			}
		}.run(new NullProgressMonitor());
	}

	@SuppressWarnings("unchecked")
	protected <T> T findRecursive(Container<?> container, Class<T> type) {
		for (IResourceFactory<?, ?> child : container.getMemberFactories()) {
			if (type.isInstance(child))
				return (T) child;
			if (child instanceof Container) {
				T result = findRecursive((Container<?>) child, type);
				if (result != null)
					return result;
			}
		}
		return null;
	}

	public Project getDefaultProject() {
		for (IResourceFactory<?, ?> fact : getMemberFactories())
			if (fact instanceof Project)
				return (Project) fact;
		return null;
	}

	public org.xpect.xtext.lib.setup.workspace.ThisFile getThisFile() {
		return findRecursive(this, org.xpect.xtext.lib.setup.workspace.ThisFile.class);
	}

	public void waitForAutoBuild() {
		boolean interrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD, null);
				interrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				interrupted = true;
			}
		} while (interrupted);
	}
}
