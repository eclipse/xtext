package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.xpect.xtext.lib.setup.FileSetupContext;
import org.xpect.xtext.lib.util.IFileUtil;

public class ThisFile extends org.xpect.xtext.lib.setup.generic.ThisFile implements IResourceFactory<IFile, IContainer> {

	public final org.xpect.xtext.lib.setup.generic.ThisFile delegate;

	public ThisFile() {
		delegate = new org.xpect.xtext.lib.setup.generic.ThisFile();
	}

	public ThisFile(org.xpect.xtext.lib.setup.generic.ThisFile file) {
		delegate = file;
	}

	public ThisFile(String name) {
		delegate = new org.xpect.xtext.lib.setup.generic.ThisFile(name);
	}

	public IFile create(FileSetupContext ctx, IContainer container, Workspace.Instance instance) throws IOException, CoreException {
		IFile file = IFileUtil.create(container, getLocalName(ctx), getContents(ctx));
		instance.setThisFile(file);
		instance.setThisProject(file.getProject());
		return file;
	}

}
