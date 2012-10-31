package org.xpect.xtext.lib.setup;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.xpect.setup.IXpectSetup.IFileSetupContext;

public interface ISetupFile {
	URI getURI(IFileSetupContext ctx);

	InputStream createInputStream(IFileSetupContext ctx) throws IOException;
}
