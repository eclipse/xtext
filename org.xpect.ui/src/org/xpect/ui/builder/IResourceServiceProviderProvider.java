package org.xpect.ui.builder;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;

public interface IResourceServiceProviderProvider extends IResourceServiceProvider {

	IResourceServiceProvider get(URI uri, String contentType);

}
