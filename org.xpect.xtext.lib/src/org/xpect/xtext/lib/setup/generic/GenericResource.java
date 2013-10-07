package org.xpect.xtext.lib.setup.generic;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.xpect.xtext.lib.setup.FileSetupContext;

public abstract class GenericResource {
	private final String name;

	public GenericResource() {
		this.name = null;
	}

	public GenericResource(String name) {
		this.name = name;
	}

	public abstract InputStream getContents(FileSetupContext ctx) throws IOException;

	public abstract String getLocalName(FileSetupContext ctx);

	public String getName() {
		return name;
	}

	public abstract URI getResolvedURI(FileSetupContext ctx);

}
