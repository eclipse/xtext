package org.eclipse.xtext.builder.impl.javasupport;

import org.eclipse.xtext.builder.BuilderModule;
import org.eclipse.xtext.builder.IResourceIndexer;
import org.eclipse.xtext.builder.impl.ResourceProvider;
import org.eclipse.xtext.builder.impl.StorageUtil;

public class JdtBuilderModule extends BuilderModule {
	
	@Override
	protected void bindIResourceIndexer() {
		bind(IResourceIndexer.class).to(JdtResourceIndexer.class);
	}
	
	@Override
	protected void bindResourceProvider() {
		bind(ResourceProvider.class).to(JdtResourceProvider.class);
	}
	
	@Override
	protected void bindStorageUtil() {
		bind(StorageUtil.class).to(JdtStorageUtil.class);
	}
}