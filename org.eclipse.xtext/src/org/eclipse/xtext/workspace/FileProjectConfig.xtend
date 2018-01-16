/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.workspace

import java.io.File
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.UriUtil

import static extension org.eclipse.xtext.util.UriUtil.*

@Accessors
class FileProjectConfig implements IProjectConfig {
	val URI path
	val String name
	val Set<FileSourceFolder> sourceFolders = newHashSet
	val IWorkspaceConfig workspaceConfig
	
	new (URI path) {
		this(path, null as IWorkspaceConfig)
	}
	
	new (URI path, String name) {
		this(path, name, null as IWorkspaceConfig)
	}
	
	new (File root, String name) {
		this(root, name, null as IWorkspaceConfig)
	}
	
	new (File root) {
		this(root, null as IWorkspaceConfig)
	}
	
	new (URI path, IWorkspaceConfig workspaceConfig) {
		this(path, path.lastSegment, workspaceConfig)
	}
	
	new (URI path, String name, IWorkspaceConfig workspaceConfig) {
		this.path = UriUtil.toFolderURI(path)
		this.name = name
		this.workspaceConfig = workspaceConfig ?: new WorkspaceConfig(this)
	}
	
	new (File root, String name, IWorkspaceConfig workspaceConfig) {
		this(UriUtil.createFolderURI(root), name, workspaceConfig)
	}
	
	new (File root, IWorkspaceConfig workspaceConfig) {
		this(UriUtil.createFolderURI(root), root.name, workspaceConfig)
	}

	def FileSourceFolder addSourceFolder(String relativePath) {
		val sourceFolder = new FileSourceFolder(this, relativePath)
		sourceFolders += sourceFolder
		sourceFolder
	}

	override FileSourceFolder findSourceFolderContaining(URI member) {
		sourceFolders.findFirst[source|source.path.isPrefixOf(member)]
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
		val result = URI.createFileURI(name).resolve(parent.path)
		if (result.hasTrailingPathSeparator) {
		    return result
		} else {
		    return result.appendSegment("")
		}
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
