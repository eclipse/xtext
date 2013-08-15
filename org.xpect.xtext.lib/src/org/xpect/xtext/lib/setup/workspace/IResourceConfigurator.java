package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

public interface IResourceConfigurator<R extends IResource> {
	void configure(IFileSetupContext ctx, R resource) throws IOException;
}
