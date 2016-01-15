package org.eclipse.xpect.xtext.lib.setup.generic;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.xtext.lib.setup.FileSetupContext;

public interface Resource {
	/**
	 * @return a URI relative to this resource's container
	 */
	URI getLocalURI(FileSetupContext ctx);
}
