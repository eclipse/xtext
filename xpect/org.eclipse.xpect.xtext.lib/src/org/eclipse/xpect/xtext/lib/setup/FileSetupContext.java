package org.eclipse.xpect.xtext.lib.setup;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpect.XpectFile;
import org.eclipse.xpect.XpectJavaModel;
import org.eclipse.xpect.runner.IXpectURIProvider;
import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Creates;
import org.eclipse.xpect.state.StateContainer;
import org.eclipse.xpect.util.IXtInjectorProvider;
import org.eclipse.xtext.resource.IResourceFactory;

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
		return xpectFile.toString();
	}
}
