package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

@SuppressWarnings("restriction")
public class Project extends Container<IProject> implements IResourceFactory<IProject, IWorkspaceRoot> {

	private final ProjectDescription description;

	public Project(String name) {
		super();
		this.description = createDescription();
		this.description.setName(name);
	}

	public IProject create(IFileSetupContext ctx, IWorkspaceRoot container) throws CoreException, IOException {
		IProject project = container.getProject(description.getName());
		project.create(description, new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		configure(ctx, project);
		createMembers(ctx, project);
		return project;
	}

	protected ProjectDescription createDescription() {
		return new ProjectDescription();
	}

	public String getName() {
		return description.getName();
	}
}
