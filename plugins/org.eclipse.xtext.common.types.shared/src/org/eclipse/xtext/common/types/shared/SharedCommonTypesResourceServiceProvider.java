package org.eclipse.xtext.common.types.shared;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

public class SharedCommonTypesResourceServiceProvider extends DefaultResourceServiceProvider {
	
	@Override
	public Manager getResourceDescriptionManager() {
		return null;
	}
	
	@Override
	public boolean canHandle(URI uri) {
		return "java".equals(uri.scheme());
	}
}
