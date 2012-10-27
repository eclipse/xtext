package org.eclipse.xpect.ui.services;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.ui.builder.IResourceServiceProviderProvider;
import org.eclipse.xpect.ui.util.XtInjectorSetupUtil;
import org.eclipse.xpect.util.URIDelegationHandler;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider;
import org.eclipse.xtext.ui.resource.IResourceUIServiceProvider;

import com.google.inject.Injector;

public class XtResourceUIServiceProviderProvider extends DefaultResourceUIServiceProvider implements IResourceServiceProviderProvider {

	public XtResourceUIServiceProviderProvider() {
		super(null);
	}

	@Override
	public IResourceServiceProvider get(URI uri, String contentType) {
		String ext = new URIDelegationHandler().getOriginalFileExtension(uri.lastSegment());
		if (ext != null) {
			Injector injector = XtInjectorSetupUtil.getWorkbenchInjector(uri, ext);
			if (injector != null)
				return injector.getInstance(IResourceUIServiceProvider.class);
		}
		return this;
	}

	@Override
	public boolean canHandle(URI uri) {
		return false;
	}
	
	@Override
	public boolean canHandle(URI uri, IStorage storage) {
		return false;
	}

}
