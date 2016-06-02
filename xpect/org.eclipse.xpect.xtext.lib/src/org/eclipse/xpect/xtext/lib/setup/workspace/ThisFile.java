package org.eclipse.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.xpect.setup.XpectSetupComponent;
import org.eclipse.xpect.xtext.lib.setup.FileSetupContext;

@XpectSetupComponent
public class ThisFile extends File implements IResourceFactory<IFile, IContainer> {

	public ThisFile() {
		super(new org.eclipse.xpect.xtext.lib.setup.generic.ThisFile());
	}

	public ThisFile(org.eclipse.xpect.xtext.lib.setup.generic.ThisFile file) {
		super(file);
	}

	public ThisFile(String name) {
		super(name);
	}

	public IFile create(FileSetupContext ctx, IContainer container, Workspace.Instance instance) throws IOException {
		IFile file = super.create(ctx, container, instance);
		instance.setThisFile(file);
		instance.setThisProject(file.getProject());
		return file;
	}

}
