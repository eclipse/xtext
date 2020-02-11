/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.workspace

import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.lib.annotations.Data

@Data
class JdtProjectConfig extends EclipseProjectConfig {

	override getSourceFolders() {
		val javaProject = JavaCore.create(project)
		if (!javaProject.exists) {
			return emptySet
		}
		val classpath = javaProject.rawClasspath
		val sourceEntries = classpath.filter[entryKind === IClasspathEntry.CPE_SOURCE]
		val sourceFolders = sourceEntries.map[path.removeFirstSegments(1).toString]
		return sourceFolders.map[new EclipseSourceFolder(project, it)].toSet
	}

}