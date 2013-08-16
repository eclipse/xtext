package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.internal.resources.ProjectDescription;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

@SuppressWarnings("restriction")
public class Project extends Container<IProject> implements IResourceFactory<IProject, IWorkspaceRoot> {

	private final ProjectDescription description;

	public Project(String name) {
		super();
		this.description = createDescription();
		this.description.setName(name);
		addNature(XtextProjectHelper.NATURE_ID);
		addBuilder(XtextProjectHelper.BUILDER_ID);
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

	public void addNature(String nature) {
		String[] natures = description.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = nature;
		description.setNatureIds(newNatures);
	}

	public void addBuilder(String builder) {
		ICommand[] specs = description.getBuildSpec();
		ICommand command = description.newCommand();
		command.setBuilderName(builder);
		ICommand[] specsModified = new ICommand[specs.length + 1];
		System.arraycopy(specs, 0, specsModified, 0, specs.length);
		specsModified[specs.length] = command;
		description.setBuildSpec(specsModified);
	}

	protected ProjectDescription getDescription() {
		return description;
	}

	public String getName() {
		return description.getName();
	}
}
