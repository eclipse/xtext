package org.eclipse.xpect.ui;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class OverridingXtextResourceSetProvider extends
		XtextResourceSetProvider {

	private Map<Injector, Injector> injectors = Maps.newConcurrentMap();

	@Inject
	private IResourceServiceProvider.Registry provider;

	private Injector createChildInjector(IResourceServiceProvider service) {
		Injector parent = service.get(Injector.class);
		Injector result = injectors.get(parent);
		if (result == null)
			injectors.put(
					parent,
					result = parent
							.createChildInjector(new OverridingLangModule()));
		return result;
	}

	public class Reg implements Resource.Factory.Registry {

		private Resource.Factory.Registry delegate;

		public Reg(Registry delegate) {
			super();
			this.delegate = delegate;
		}

		@Override
		public Factory getFactory(URI uri) {
			Factory fact = delegate.getFactory(uri);
			if (fact instanceof IResourceFactory) {
				IResourceServiceProvider provider2 = provider
						.getResourceServiceProvider(uri);
				if (provider2 != null) {
					Injector inj = createChildInjector(provider2);
					return inj.getInstance(fact.getClass());
				}
			}
			return fact;
		}

		@Override
		public Factory getFactory(URI uri, String contentType) {
			Factory fact = delegate.getFactory(uri, contentType);
			if (fact instanceof IResourceFactory) {
				IResourceServiceProvider provider2 = provider
						.getResourceServiceProvider(uri, contentType);
				if (provider2 != null) {
					Injector inj = createChildInjector(provider2);
					return inj.getInstance(fact.getClass());
				}
			}
			return fact;
		}

		@Override
		public Map<String, Object> getProtocolToFactoryMap() {
			return delegate.getProtocolToFactoryMap();
		}

		@Override
		public Map<String, Object> getExtensionToFactoryMap() {
			return delegate.getExtensionToFactoryMap();
		}

		@Override
		public Map<String, Object> getContentTypeToFactoryMap() {
			return delegate.getContentTypeToFactoryMap();
		}
	}

	public static final class OverridingFactory implements Resource.Factory {

		@Override
		public Resource createResource(URI uri) {
			XtextResource res = (XtextResource) createResource(uri);
			return null;
		}

	}

	@Override
	public ResourceSet get(IProject project) {
		ResourceSet rs = super.get(project);
		rs.setResourceFactoryRegistry(new Reg(rs.getResourceFactoryRegistry()));
		return rs;
	}
}
