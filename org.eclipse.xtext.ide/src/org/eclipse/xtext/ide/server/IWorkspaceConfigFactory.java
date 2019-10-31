/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.IWorkspaceConfig;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
public interface IWorkspaceConfigFactory {
	/**
	 * Create a workspace config at the given location.
	 *
	 * @param workspaceBaseURI
	 *            the location
	 * @return the workspace configuration.
	 */
	IWorkspaceConfig getWorkspaceConfig(URI workspaceBaseURI);
}
