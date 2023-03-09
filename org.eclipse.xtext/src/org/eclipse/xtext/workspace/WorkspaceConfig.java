/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.workspace;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * The default workspace consists of multiple projects and always contains the unknown project that is used for
 * projectless files.
 *
 * @author kosyakov - Initial contribution and API
 */
public class WorkspaceConfig implements IWorkspaceConfig {
	private final UnknownProjectConfig unknown = new UnknownProjectConfig(this);

	private final Map<String, IProjectConfig> projects = new LinkedHashMap<>();

	public WorkspaceConfig(IProjectConfig... initialProjects) {
		addProject(unknown);
		for (IProjectConfig p : initialProjects) {
			addProject(p);
		}
	}

	@Override
	public Set<? extends IProjectConfig> getProjects() {
		return toSet(projects.values());
	}

	public void addProject(IProjectConfig project) {
		projects.put(project.getName(), project);
	}

	@Override
	public IProjectConfig findProjectByName(String name) {
		return projects.get(name);
	}

	@Override
	public IProjectConfig findProjectContaining(URI member) {
		return projects.values().stream()
			.filter(projectCfg -> projectCfg.findSourceFolderContaining(member) != null)
			.max((cfg1, cfg2) -> cfg1.getPath().segmentCount() - cfg2.getPath().segmentCount())
			.orElse(unknown);
	}
}
