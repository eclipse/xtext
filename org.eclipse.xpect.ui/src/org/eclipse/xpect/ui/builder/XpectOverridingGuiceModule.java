package org.eclipse.xpect.ui.builder;

import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Binder;
import com.google.inject.Module;

public class XpectOverridingGuiceModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(IResourceServiceProvider.Registry.class).toInstance(XpectResourceServiceProviderRegistry.INSTANCE);
	}

}
