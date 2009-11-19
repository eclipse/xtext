package org.eclipse.xtext.builder;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.builder.builderState.BuilderStateManager;
import org.eclipse.xtext.builder.builderState.IPersister;
import org.eclipse.xtext.builder.impl.ResourceIndexer;
import org.eclipse.xtext.builder.impl.StorageUtil;
import org.eclipse.xtext.builder.impl.javasupport.JdtStorageUtil;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class BuilderModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bindIPersister();
		bindStorageUtil();
		bindResourceSet();
		bindIResourceIndexer();
		bindResourceProvider();
		bindBuilderStateManager();
		bindUriForBuilderStateResource();
	}

	protected void bindResourceProvider() {
	}

	protected void bindUriForBuilderStateResource() {
		bind(String.class).annotatedWith(Names.named(BuilderStateManager.NAMED_URI)).toInstance("./mybuilderstate.idx");
	}

	protected void bindBuilderStateManager() {
		bind(BuilderStateManager.class).in(com.google.inject.Scopes.SINGLETON);
	}

	protected void bindIResourceIndexer() {
		bind(IResourceIndexer.class).to(ResourceIndexer.class);
	}

	protected void bindResourceSet() {
		bind(ResourceSet.class).to(ResourceSetImpl.class);
	}

	protected void bindStorageUtil() {
		bind(StorageUtil.class).to(JdtStorageUtil.class);
	}

	protected void bindIPersister() {
		bind(IPersister.class).to(IPersister.DefaultImpl.class);
	}
	
}
