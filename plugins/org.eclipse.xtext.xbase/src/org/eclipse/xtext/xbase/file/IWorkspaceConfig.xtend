/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.file

import java.util.Collection
import com.google.inject.ImplementedBy

/**
 * Describes a workspace with contained projects.
 */
@ImplementedBy(RuntimeWorkspaceConfigProvider)
interface IWorkspaceConfig {
	/**
	 * Returns the root path in the file system.
	 */
	def String getAbsoluteFileSystemPath()
	/**
	 * Provides access to all projects. The collection cannot be modified.
	 */
	def Collection<? extends ProjectConfig> getProjects()
	/**
	 * Find the project config for a given project. Otherwise null.
	 */
	def ProjectConfig getProject(String name)
}
