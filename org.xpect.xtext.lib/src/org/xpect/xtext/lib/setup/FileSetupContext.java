package org.xpect.xtext.lib.setup;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceFactory;
import org.xpect.XpectFile;
import org.xpect.XpectJavaModel;
import org.xpect.runner.IXpectURIProvider;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.state.StateContainer;
import org.xpect.util.IXtInjectorProvider;

import com.google.inject.Injector;

@XpectSetupFactory
public class FileSetupContext {

	private final StateContainer state;
	private final XpectFile xpectFile;

	public FileSetupContext(StateContainer state, XpectFile xpectFile) {
		super();
		this.state = state;
		this.xpectFile = xpectFile;
	}

	@Creates()
	public FileSetupContext create() {
		return this;
	}

	public <T> T get(Class<T> expectedType, Object... annotations) {
		return state.get(expectedType, annotations).get();
	}

	public StateContainer getState() {
		return state;
	}

	public XpectFile getXpectFile() {
		return xpectFile;
	}

	public URI getXpectFileURI() {
		return xpectFile.eResource().getURI();
	}

	public Resource load(ResourceSet resourceSet, URI uri, InputStream input) throws IOException {
		Injector injector = IXtInjectorProvider.INSTANCE.getInjector(get(XpectJavaModel.class), uri);
		Resource resource = injector.getInstance(IResourceFactory.class).createResource(uri);
		resourceSet.getResources().add(resource);
		try {
			resource.load(input, null);
		} finally {
			if (input != null)
				input.close();
		}
		return resource;
	}

	public URI resolve(String uri) {
		return get(IXpectURIProvider.class).resolveURI(getXpectFileURI(), uri);
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
