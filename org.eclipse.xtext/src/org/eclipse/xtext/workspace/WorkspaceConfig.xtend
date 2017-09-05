/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.workspace

import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * The default workspace consists of multiple projects and always contains the unknown project that is used for projectless files.
 *  
 * @author kosyakov - Initial contribution and API
 */
class WorkspaceConfig implements IWorkspaceConfig {

	val unknown = new UnknownProjectConfig(this)
	val projects = <String, IProjectConfig>newHashMap

	new(IProjectConfig... initialProjects) {
		addProject(unknown)
		initialProjects.forEach[addProject]
	}

	override getProjects() {
		projects.values.toSet
	}

	def void addProject(IProjectConfig project) {
		projects.put(project.name, project)
	}

	override findProjectByName(String name) {
		projects.get(name)
	}

	override findProjectContaining(URI member) {
		val candidates = projects.values.filter [
			findSourceFolderContaining(member) !== null
		]
		if (!candidates.empty)
			return candidates.maxBy[path.segmentCount]
		else
			return unknown
	}
}

@Accessors
@FinalFieldsConstructor
class UnknownProjectConfig implements IProjectConfig {

	val String name = '__unknown_project'
	val IWorkspaceConfig workspaceConfig

	override findSourceFolderContaining(URI member) {
		null
	}

	override getPath() {
		null
	}

	override getSourceFolders() {
		emptySet
	}

}
