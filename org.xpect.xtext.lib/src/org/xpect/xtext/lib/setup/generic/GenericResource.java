package org.xpect.xtext.lib.setup.generic;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

public abstract class GenericResource {
	private final String name;

	public GenericResource() {
		this.name = null;
	}

	public GenericResource(String name) {
		this.name = name;
	}

	public abstract InputStream getContents(IFileSetupContext ctx) throws IOException;

	public abstract String getLocalName(IFileSetupContext ctx);

	public String getName() {
		return name;
	}

	public abstract URI getResolvedURI(IFileSetupContext ctx);

}
