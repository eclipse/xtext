package org.eclipse.xpect.xtext.lib.setup;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xpect.setup.IXpectSetup.IFileSetupContext;

public class ThisFile implements ISetupFile {
	private String name;

	public ThisFile() {
		this(null);
	}

	public ThisFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public InputStream createInputStream(IFileSetupContext ctx) throws IOException {
		Resource resource = ctx.getXpectFile().eResource();
		return resource.getResourceSet().getURIConverter().createInputStream(resource.getURI());
	}

	public String getName() {
		return name;
	}

	@Override
	public URI getURI(IFileSetupContext ctx) {
		if (name == null)
			return ctx.getXpectFile().eResource().getURI();
		return ctx.getURIProvider().resolveURI(ctx.getXpectFile().eResource().getURI(), name);
	}

}
