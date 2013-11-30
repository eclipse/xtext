package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.xpect.xtext.lib.setup.FileSetupContext;
import org.xpect.xtext.lib.setup.workspace.Workspace.Instance;
import org.xpect.xtext.lib.util.IFileUtil;

public class Folder extends Container<IFolder> implements IResourceFactory<IFolder, IContainer> {

	private final org.xpect.xtext.lib.setup.generic.Folder delegate;

	public Folder(String name) {
		this.delegate = new org.xpect.xtext.lib.setup.generic.Folder(name);
	}

	public Folder(org.xpect.xtext.lib.setup.generic.Folder delegate) {
		super();
		this.delegate = delegate;
	}

	public IFolder create(FileSetupContext ctx, IContainer container, Instance instance) throws IOException, CoreException {
		IFolder folder = IFileUtil.createFolder(container, delegate.getLocalURI(ctx).toString());
		configure(ctx, folder);
		createMembers(ctx, folder, instance);
		return folder;
	}

}
