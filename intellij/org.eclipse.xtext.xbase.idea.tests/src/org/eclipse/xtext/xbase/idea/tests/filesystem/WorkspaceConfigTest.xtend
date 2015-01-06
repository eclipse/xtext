/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.tests.filesystem

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.xbase.file.WorkspaceConfig
import org.eclipse.xtext.xbase.idea.tests.LightXbaseTest

class WorkspaceConfigTest extends LightXbaseTest {

	@Inject
	Provider<WorkspaceConfig> workspaceConfigs

	def void testDefaultProject() {
		val config = workspaceConfigs.get
		assertEquals(project.basePath, config.absoluteFileSystemPath)
		config.projects.values.forEach [
			assertEquals(module.name, name)
			assertEquals(#{new Path("src") -> new Path("src-gen")}, sourceFolderMappings)
		]
	}

}