package org.eclipse.xpect.ui.builder;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.xpect.ui.util.XtextInjectorSetupUtil;

import com.google.inject.Injector;

public class XpectResourceFactoryRegistry implements Resource.Factory.Registry {
	private Resource.Factory.Registry delegate;

	public XpectResourceFactoryRegistry(Registry delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public Map<String, Object> getContentTypeToFactoryMap() {
		return delegate.getContentTypeToFactoryMap();
	}

	@Override
	public Map<String, Object> getExtensionToFactoryMap() {
		return delegate.getExtensionToFactoryMap();
	}

	@Override
	public Factory getFactory(URI uri) {
		Factory fact = delegate.getFactory(uri);
		Injector inj = XtextInjectorSetupUtil.getWorkspaceInjector(uri);
		if (inj != null)
			return inj.getInstance(fact.getClass());
		return fact;
	}

	@Override
	public Factory getFactory(URI uri, String contentType) {
		Factory fact = delegate.getFactory(uri, contentType);
		Injector inj = XtextInjectorSetupUtil.getWorkspaceInjector(uri);
		if (inj != null)
			return inj.getInstance(fact.getClass());
		return fact;
	}

	@Override
	public Map<String, Object> getProtocolToFactoryMap() {
		return delegate.getProtocolToFactoryMap();
	}

}