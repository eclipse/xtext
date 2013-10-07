package org.xpect.xtext.lib.setup.generic;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.xpect.xtext.lib.setup.FileSetupContext;

public class File extends GenericResource {
	private String from;

	public File() {
		super();
	}

	public File(String name) {
		super(name);
	}

	public InputStream getContents(FileSetupContext ctx) throws IOException {
		URI source = ctx.resolve(getFrom() == null ? getName() : getFrom());
		return ctx.getXpectFile().eResource().getResourceSet().getURIConverter().createInputStream(source);
	}

	public String getFrom() {
		return from;
	}

	public String getLocalName(FileSetupContext ctx) {
		return getName() == null ? from : getName();
	}

	public URI getResolvedURI(FileSetupContext ctx) {
		return ctx.resolve(getLocalName(ctx));
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
