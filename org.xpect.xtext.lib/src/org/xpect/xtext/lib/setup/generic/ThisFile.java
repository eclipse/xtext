package org.xpect.xtext.lib.setup.generic;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.StringInputStream;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

public class ThisFile extends GenericResource {

	public ThisFile() {
		super();
	}

	public ThisFile(String name) {
		super(name);
	}

	public InputStream getContents(IFileSetupContext ctx) {
		return new StringInputStream(ctx.getXpectFile().getDocument());
	}

	public String getLocalName(IFileSetupContext ctx) {
		return getName() == null ? ctx.getXpectFile().eResource().getURI().lastSegment() : getName();
	}

	public URI getResolvedURI(IFileSetupContext ctx) {
		return getName() == null ? ctx.getXpectFile().eResource().getURI() : ctx.resolve(getName());
	}

}
