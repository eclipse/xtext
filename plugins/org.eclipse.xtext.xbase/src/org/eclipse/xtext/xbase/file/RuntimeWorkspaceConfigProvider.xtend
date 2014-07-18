/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.file

import com.google.inject.Provider
import com.google.inject.Singleton
import java.io.File
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
@Accessors
class RuntimeWorkspaceConfigProvider implements Provider<WorkspaceConfig> {
	File workspaceRoot = new File(".").absoluteFile.parentFile
	WorkspaceConfig workspaceConfig
	
	override get() {
		if (workspaceConfig == null) {
			workspaceConfig = new WorkspaceConfig(workspaceRoot.absolutePath) => [
				for (dir : workspaceRoot.listFiles.filter[isDirectory]) {
					addProjectConfig(new ProjectConfig(dir.name) => [
					])
				}
			]
		}
		return workspaceConfig
	}
	
}