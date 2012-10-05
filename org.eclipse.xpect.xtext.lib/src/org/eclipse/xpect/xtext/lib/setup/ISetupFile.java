package org.eclipse.xpect.xtext.lib.setup;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.setup.IXpectSetup.ITestSetupContext;

public interface ISetupFile {
	URI getURI(ITestSetupContext ctx);

	InputStream createInputStream(ITestSetupContext ctx) throws IOException;
}
