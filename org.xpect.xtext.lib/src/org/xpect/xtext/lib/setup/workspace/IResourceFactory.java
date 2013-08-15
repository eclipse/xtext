package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

public interface IResourceFactory<R extends IResource, C extends IContainer> {
	R create(IFileSetupContext ctx, C container) throws IOException, CoreException;
}
