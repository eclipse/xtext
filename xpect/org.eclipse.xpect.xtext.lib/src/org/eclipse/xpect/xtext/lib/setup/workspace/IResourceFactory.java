package org.eclipse.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xpect.xtext.lib.setup.FileSetupContext;

public interface IResourceFactory<R extends IResource, C extends IContainer> {
	R create(FileSetupContext ctx, C container, Workspace.Instance instance) throws IOException, CoreException;
}
