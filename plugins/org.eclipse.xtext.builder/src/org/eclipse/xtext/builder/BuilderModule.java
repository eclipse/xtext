package org.eclipse.xtext.builder;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.builder.builderState.BuilderStateManager;
import org.eclipse.xtext.builder.builderState.IPersister;
import org.eclipse.xtext.builder.impl.StorageUtil;
import org.eclipse.xtext.builder.impl.javasupport.JavaSupportingStorageUtil;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class BuilderModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IPersister.class).to(IPersister.DefaultImpl.class);
		bind(StorageUtil.class).to(JavaSupportingStorageUtil.class);
		bind(ResourceSet.class).to(ResourceSetImpl.class);
		bind(BuilderStateManager.class).in(com.google.inject.Scopes.SINGLETON);
		bind(String.class).annotatedWith(Names.named(BuilderStateManager.NAMED_URI)).toInstance("./mybuilderstate.idx");
	}
	
}
