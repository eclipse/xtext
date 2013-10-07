package org.xpect.xtext.lib.setup.generic;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.StringInputStream;
import org.xpect.xtext.lib.setup.FileSetupContext;

public class ThisFile extends GenericResource {

	public ThisFile() {
		super();
	}

	public ThisFile(String name) {
		super(name);
	}

	public InputStream getContents(FileSetupContext ctx) {
		return new StringInputStream(ctx.getXpectFile().getDocument());
	}

	public String getLocalName(FileSetupContext ctx) {
		return getName() == null ? ctx.getXpectFileURI().lastSegment() : getName();
	}

	public URI getResolvedURI(FileSetupContext ctx) {
		return getName() == null ? ctx.getXpectFileURI() : ctx.resolve(getName());
	}

}
