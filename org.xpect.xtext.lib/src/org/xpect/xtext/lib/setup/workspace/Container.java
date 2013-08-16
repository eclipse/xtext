package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

import com.google.common.collect.Lists;

public class Container<C extends IContainer> extends Resource<C> {

	private final List<IResourceFactory<?, ? super C>> memberFactories = Lists.newArrayList();

	public void add(IResourceFactory<?, ? super C> factory) {
		this.memberFactories.add(factory);
	}

	protected void createMembers(IFileSetupContext ctx, C container) throws IOException, CoreException {
		for (IResourceFactory<?, ? super C> factory : memberFactories)
			factory.create(ctx, container);
	}

	public List<IResourceFactory<?, ? super C>> getMemberFactories() {
		return memberFactories;
	}

	@SuppressWarnings("unchecked")
	public <T extends IResourceFactory<?, ?>> List<T> getMembers(Class<T> type) {
		List<T> result = Lists.newArrayList();
		for (IResourceFactory<?, ? super C> member : memberFactories)
			if (type.isInstance(member))
				result.add((T) member);
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T extends IResourceFactory<?, ?>> T getMember(Class<T> type) {
		for (IResourceFactory<?, ? super C> member : memberFactories)
			if (type.isInstance(member))
				return (T) member;
		return null;
	}

}
