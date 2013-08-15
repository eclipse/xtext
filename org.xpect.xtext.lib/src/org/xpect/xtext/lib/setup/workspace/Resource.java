package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

import com.google.common.collect.Lists;

public class Resource<R extends IResource> {
	private final List<IResourceConfigurator<? super R>> configurators = Lists.newArrayList();

	public void add(IResourceConfigurator<? super R> configurator) {
		this.configurators.add(configurator);
	}

	protected void configure(IFileSetupContext ctx, R resource) throws IOException {
		for (IResourceConfigurator<? super R> configurator : configurators)
			configurator.configure(ctx, resource);
	}

	public List<IResourceConfigurator<? super R>> getConfigurators() {
		return configurators;
	}

}
