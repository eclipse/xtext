package org.eclipse.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xpect.setup.XpectSetupComponent;
import org.eclipse.xpect.xtext.lib.setup.FileSetupContext;

@XpectSetupComponent
public class SrcFolder extends Container<IFolder> implements IResourceFactory<IFolder, IProject> {

	private final String name;

	public SrcFolder() {
		this("src");
	}

	public SrcFolder(String name) {
		super();
		this.name = name;
	}

	public IFolder create(FileSetupContext ctx, IProject container, Workspace.Instance instance) throws IOException, CoreException {
		IFolder folder = container.getFolder(name);
		folder.create(false, true, new NullProgressMonitor());
		configure(ctx, folder);
		createMembers(ctx, folder, instance);
		return folder;
	}

	public String getName() {
		return name;
	}

}
