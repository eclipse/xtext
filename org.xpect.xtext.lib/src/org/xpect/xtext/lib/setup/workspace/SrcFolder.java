package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

public class SrcFolder extends Container<IFolder> implements IResourceFactory<IFolder, IProject> {

	private final String name;

	public SrcFolder() {
		this("src");
	}

	public SrcFolder(String name) {
		super();
		this.name = name;
	}

	public IFolder create(IFileSetupContext ctx, IProject container) throws IOException, CoreException {
		IFolder folder = container.getFolder(name);
		folder.create(false, true, new NullProgressMonitor());
		configure(ctx, folder);
		createMembers(ctx, folder);
		return folder;
	}

	public String getName() {
		return name;
	}

}
