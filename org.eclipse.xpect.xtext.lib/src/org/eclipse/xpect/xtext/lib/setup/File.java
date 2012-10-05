package org.eclipse.xpect.xtext.lib.setup;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xpect.setup.IXpectSetup.ITestSetupContext;

public class File implements ISetupFile {
	private String from;
	private String name;

	public File(String name) {
		super();
		this.name = name;
	}

	@Override
	public InputStream createInputStream(ITestSetupContext ctx) throws IOException {
		String from = this.from != null ? this.from : name;
		Resource resource = ctx.getXpectFile().eResource();
		URI uri = ctx.getURIProvider().resolveURI(resource.getURI(), from);
		return resource.getResourceSet().getURIConverter().createInputStream(uri);
	}

	public String getFrom() {
		return from;
	}

	public String getName() {
		return name;
	}

	@Override
	public URI getURI(ITestSetupContext ctx) {
		return ctx.getURIProvider().resolveURI(ctx.getXpectFile().eResource().getURI(), name);
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setName(String name) {
		this.name = name;
	}

}
