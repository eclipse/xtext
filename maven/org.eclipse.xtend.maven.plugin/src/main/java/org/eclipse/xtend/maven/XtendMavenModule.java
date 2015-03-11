package org.eclipse.xtend.maven;

import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

public class XtendMavenModule extends XtendRuntimeModule {

	public Class<? extends ITraceURIConverter> bindITraceURIConverter() {
		return MavenTraceURIConverter.class;
	}

	public Class<? extends ResourceDescriptionsProvider> bindResourceDescriptionsProvider() {
		return MavenProjectAwareResourceDescriptionsProvider.class;
	}
}
