package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

public class Workspace extends Container<IWorkspaceRoot> {

	public Workspace() {
	}

	public void cleanWorkspace() throws CoreException {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = projects.length - 1; i >= 0; i--)
			projects[i].delete(true, new NullProgressMonitor());
	}

	public void configureWorkspace(IFileSetupContext ctx) throws IOException, CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		configure(ctx, root);
		createMembers(ctx, root);
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
