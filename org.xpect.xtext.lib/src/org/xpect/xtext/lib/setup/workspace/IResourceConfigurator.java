package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.xpect.xtext.lib.setup.FileSetupContext;

public interface IResourceConfigurator<R extends IResource> {
	void configure(FileSetupContext ctx, R resource) throws IOException;
}
