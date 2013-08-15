package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.xpect.parameter.ParameterProvider;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;
import org.xpect.xtext.lib.setup.ThisProject;
import org.xpect.xtext.lib.util.IFileAdapter;
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

	public IFile create(IFileSetupContext ctx, IContainer container) throws IOException, CoreException {
		IFile file = IFileUtil.create(container, getLocalName(ctx), getContents(ctx));
		ctx.installParameterValue(org.xpect.xtext.lib.setup.ThisFile.class, new IFileAdapter(file));
		ctx.installParameterValue(ThisProject.class, new ParameterProvider(file.getProject()));
		return file;
	}

}
