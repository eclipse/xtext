package org.eclipse.xpect.ui.builder;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.ui.util.XtextInjectorSetupUtil;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Injector;

public class XpectResourceServiceProviderRegistry implements IResourceServiceProvider.Registry {

	public final static XpectResourceServiceProviderRegistry INSTANCE = new XpectResourceServiceProviderRegistry();

	protected XpectResourceServiceProviderRegistry() {
	}

	@Override
	public IResourceServiceProvider getResourceServiceProvider(URI uri, String contentType) {
		Injector inj = XtextInjectorSetupUtil.getWorkspaceInjector(uri);
		if (inj != null)
			return inj.getInstance(IResourceServiceProvider.class);
		return IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri, contentType);
	}

	@Override
	public IResourceServiceProvider getResourceServiceProvider(URI uri) {
		Injector inj = XtextInjectorSetupUtil.getWorkspaceInjector(uri);
		if (inj != null)
			return inj.getInstance(IResourceServiceProvider.class);
		return IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
	}

	@Override
	public Map<String, Object> getContentTypeToFactoryMap() {
		return IResourceServiceProvider.Registry.INSTANCE.getContentTypeToFactoryMap();
	}

	@Override
	public Map<String, Object> getExtensionToFactoryMap() {
		return IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap();
	}

	@Override
	public Map<String, Object> getProtocolToFactoryMap() {
		return IResourceServiceProvider.Registry.INSTANCE.getProtocolToFactoryMap();
	}

}
