/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.file

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Map

/**
 * An implementation of the workspace config that can be configured by clients.
 */
@Data
class SimpleWorkspaceConfig implements IWorkspaceConfig {
	String absoluteFileSystemPath
	@Accessors(NONE)
	Map<String, ProjectConfig> projects = newLinkedHashMap()
	
	def addProjectConfig(ProjectConfig config) {
		projects.put(config.getName(), config);
	}
	
	override getProjects() {
		projects.values.unmodifiableView
	}
	
	override getProject(String name) {
		return projects.get(name)
	}
	
}