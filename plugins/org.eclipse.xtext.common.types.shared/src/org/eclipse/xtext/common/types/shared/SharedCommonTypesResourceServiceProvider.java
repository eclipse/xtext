package org.eclipse.xtext.common.types.shared;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

public class SharedCommonTypesResourceServiceProvider extends DefaultResourceServiceProvider {
	@Override
	public void setExtensions(String extensions) {
		// Disable dependency from super class
	}
	
	@Override
	public boolean canHandle(URI uri) {
		return "java".equals(uri.scheme());
	}
}
