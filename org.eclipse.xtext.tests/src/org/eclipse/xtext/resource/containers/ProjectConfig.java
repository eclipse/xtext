/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.containers;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.WorkspaceConfig;

public class ProjectConfig implements IProjectConfig {
	private final URI path;

	private final Set<SourceFolder> sourceFolders = new HashSet<>();

	private final String name;

	private final IWorkspaceConfig workspaceConfig;

	public ProjectConfig(String name, WorkspaceConfig workspaceConfig) {
		this.name = name;
		this.path = URI.createURI(new File(name).getAbsoluteFile().toURI().toString()).appendSegment("");
		this.sourceFolders.add(new SourceFolder(this.path.trimSegments(1).appendSegment("src").appendSegment("")));
		this.workspaceConfig = workspaceConfig;
		workspaceConfig.addProject(this);
	}

	@Override
	public ISourceFolder findSourceFolderContaining(URI member) {
		for (ISourceFolder f : sourceFolders) {
			if (UriUtil.isPrefixOf(this.path, member)) {
				return f;
			}
		}
		return null;
	}

	public URI getPath() {
		return path;
	}

	public Set<SourceFolder> getSourceFolders() {
		return sourceFolders;
	}

	public String getName() {
		return name;
	}

	public IWorkspaceConfig getWorkspaceConfig() {
		return workspaceConfig;
	}
}
