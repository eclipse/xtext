package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;
import org.xpect.xtext.lib.util.IFileUtil;

public class File implements IResourceFactory<IFile, IContainer> {

	private final org.xpect.xtext.lib.setup.generic.File delegate;

	public File() {
		delegate = new org.xpect.xtext.lib.setup.generic.File();
	}

	public File(org.xpect.xtext.lib.setup.generic.File file) {
		delegate = file;
	}

	public File(String name) {
		delegate = new org.xpect.xtext.lib.setup.generic.File(name);
	}

	public IFile create(IFileSetupContext ctx, IContainer container) throws IOException {
		return IFileUtil.create(container, delegate.getLocalName(ctx), delegate.getContents(ctx));
	}

	public void setFrom(String name) {
		delegate.setFrom(name);
	}

}
