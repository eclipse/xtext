/*******************************************************************************
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.lsp4j.WorkspaceFolder;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.WorkspaceConfig;

import com.google.inject.Inject;

/**
 * Creates one project per workspace root folder.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.21
 */
public class MultiRootWorkspaceConfigFactory implements IMultiRootWorkspaceConfigFactory {

	@Inject UriExtensions uriExtensions;

	@Override
	public IWorkspaceConfig getWorkspaceConfig(List<WorkspaceFolder> workspaceFolders) {
		WorkspaceConfig workspaceConfig = new WorkspaceConfig();
		Set<String> existingProjectNames = new HashSet<>();
		for(WorkspaceFolder workspaceFolder: workspaceFolders) 
			addProjectsForWorkspaceFolder(workspaceConfig, workspaceFolder, existingProjectNames);
		return workspaceConfig;
	}

	protected void addProjectsForWorkspaceFolder(WorkspaceConfig workspaceConfig, WorkspaceFolder workspaceFolder, Set<String> existingNames) {
		if (workspaceFolder != null && workspaceFolder.getUri() != null) {
			FileProjectConfig project = new FileProjectConfig(uriExtensions.toUri(workspaceFolder.getUri()), getUniqueProjectName(workspaceFolder.getName(), existingNames));
			project.addSourceFolder(".");
			workspaceConfig.addProject(project);
		}
	}

	/**
	 * Project names have to be unique, as the WorkspaceManager uses them as keys in a map.
	 */
	protected String getUniqueProjectName(String proposal, Set<String> existingNames){
		if (existingNames.add(proposal)) {
			return proposal;
		} else {
			for(int count = 1; true; ++count) {
				if (existingNames.add(proposal + count))
					return proposal + count;
			}
		}
	}
	
	/**
	 * @since 2.20
	 */
	protected UriExtensions getUriExtensions() {
		return uriExtensions;
	}
}
