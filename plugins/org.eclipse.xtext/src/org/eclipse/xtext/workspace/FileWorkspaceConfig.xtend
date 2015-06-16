/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.workspace

import java.io.File
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class FileWorkspaceConfig implements IWorkspaceConfig {
	val File root
	val Set<FileProjectConfig> projects = newHashSet

	def FileProjectConfig addProject(String name) {
		val project = new FileProjectConfig(this, name)
		projects += project
		project
	}

	override FileProjectConfig findProjectContaining(URI member) {
		projects.findFirst[project|member.deresolve(project.path).isRelative]
	}

	override getPath() {
		URI.createFileURI(root.path)
	}

	override Set<FileProjectConfig> getProjects() {
		projects
	}

	override findProjectByName(String name) {
		projects.findFirst[project|project.name == name]
	}

}

@FinalFieldsConstructor
class FileProjectConfig implements IProjectConfig {
	val FileWorkspaceConfig parent
	val String name
	val Set<FileSourceFolder> sourceFolders = newHashSet

	def FileSourceFolder addSourceFolder(String relativePath) {
		val sourceFolder = new FileSourceFolder(this, relativePath)
		sourceFolders += sourceFolder
		sourceFolder
	}

	override FileSourceFolder findSourceFolderContaing(URI member) {
		sourceFolders.findFirst[source|member.deresolve(source.path).isRelative]
	}

	override getName() {
		name
	}

	override getPath() {
		parent.path.appendSegment(name)
	}

	override Set<FileSourceFolder> getSourceFolders() {
		sourceFolders
	}

}

@FinalFieldsConstructor
class FileSourceFolder implements ISourceFolder {
	val FileProjectConfig parent
	val String name

	override getName() {
		name
	}

	override getPath() {
		parent.path.appendSegments(name.split("/"))
	}

}