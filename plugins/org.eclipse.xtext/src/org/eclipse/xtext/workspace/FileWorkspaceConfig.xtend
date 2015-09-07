/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.workspace

import java.io.File
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import static extension org.eclipse.xtext.util.UriUtil.*
import org.eclipse.xtext.util.UriUtil

@FinalFieldsConstructor
class FileWorkspaceConfig implements IWorkspaceConfig {
	val File root
	val Map<String, FileProjectConfig> projects = newHashMap

	def FileProjectConfig addProject(String name) {
		val project = new FileProjectConfig(this, name)
		projects.put(project.name, project)
		project
	}

	override FileProjectConfig findProjectContaining(URI member) {
		projects.values.findFirst[project|project.path.isPrefixOf(member)]
	}

	def getPath() {
		UriUtil.createFolderURI(root)
	}
	
	override Set<? extends FileProjectConfig> getProjects() {
		projects.values.toSet
	}

	override FileProjectConfig findProjectByName(String name) {
		projects.get(name)
	}

	override equals(Object obj) {
		if (obj instanceof FileWorkspaceConfig) {
			return path == obj.path
		}
		return false
	}

	override hashCode() {
		path.hashCode
	}
	
	override toString() {
		'''Workspace («path»)'''
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

	override FileSourceFolder findSourceFolderContaining(URI member) {
		sourceFolders.findFirst[source|source.path.isPrefixOf(member)]
	}

	override getName() {
		name
	}

	override getPath() {
		URI.createFileURI(name).resolve(parent.path).appendSegment("")
	}

	override Set<FileSourceFolder> getSourceFolders() {
		sourceFolders
	}

	override equals(Object obj) {
		if (obj instanceof FileProjectConfig) {
			return path == obj.path
		}
		return false
	}

	override hashCode() {
		path.hashCode
	}
	
	override toString() {
		'''Project «name» («path»)'''
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
		URI.createFileURI(name).resolve(parent.path).appendSegment("")
	}

	override equals(Object obj) {
		if (obj instanceof FileSourceFolder) {
			return path == obj.path
		}
		return false
	}

	override hashCode() {
		path.hashCode
	}
	
	override toString() {
		'''«name» («path»)'''
	}
	
}