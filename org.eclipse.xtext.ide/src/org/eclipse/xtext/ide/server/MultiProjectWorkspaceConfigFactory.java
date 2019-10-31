/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.WorkspaceConfig;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
public class MultiProjectWorkspaceConfigFactory extends ProjectWorkspaceConfigFactory {
	@Override
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
