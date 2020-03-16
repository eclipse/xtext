/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import java.io.File;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.WorkspaceFolder;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.WorkspaceConfig;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
public class MultiProjectWorkspaceConfigFactory extends MultiRootWorkspaceConfigFactory {

	@Override
	protected void addProjectsForWorkspaceFolder(WorkspaceConfig workspaceConfig, WorkspaceFolder workspaceFolder, Set<String> existingNames) {
		if (workspaceFolder != null && workspaceFolder.getUri() != null)
			findProjects(workspaceConfig, uriExtensions.toUri(workspaceFolder.getUri()));
	}

	public void findProjects(WorkspaceConfig workspaceConfig, URI uri) {
		if (uri == null) {
			return;
		}
		File baseFile = new File(uri.toFileString());
		if (!baseFile.isDirectory()) {
			return;
		}
		for (File dir : baseFile.listFiles(File::isDirectory)) {
			FileProjectConfig project = new FileProjectConfig(dir, workspaceConfig);
			project.addSourceFolder(".");
			workspaceConfig.addProject(project);
		}
	}
}
