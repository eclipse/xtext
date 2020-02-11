/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.workspace;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

public class UnknownProjectConfig implements IProjectConfig {
	private static final String NAME = "__unknown_project";

	private final IWorkspaceConfig workspaceConfig;

	public UnknownProjectConfig(IWorkspaceConfig workspaceConfig) {
		this.workspaceConfig = workspaceConfig;
	}

	@Override
	public ISourceFolder findSourceFolderContaining(URI member) {
		return null;
	}

	@Override
	public URI getPath() {
		return null;
	}

	@Override
	public Set<? extends ISourceFolder> getSourceFolders() {
		return Collections.emptySet();
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public IWorkspaceConfig getWorkspaceConfig() {
		return workspaceConfig;
	}
}
