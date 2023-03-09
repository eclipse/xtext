/*******************************************************************************
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import java.util.List;

import org.eclipse.lsp4j.WorkspaceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.21
 */
public interface IMultiRootWorkspaceConfigFactory {
	
	/**
	 * Create a workspace config at the given location.
	 *
	 * @param workspaceFolders the list of workspace root folders
	 * @return the workspace configuration.
	 */
	IWorkspaceConfig getWorkspaceConfig(List<WorkspaceFolder> workspaceFolders);

}
