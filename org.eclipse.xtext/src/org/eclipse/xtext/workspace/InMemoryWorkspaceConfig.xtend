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

import static extension org.eclipse.xtext.util.UriUtil.*

@FinalFieldsConstructor
class InMemoryWorkspaceConfig implements IWorkspaceConfig {
	
	val IProjectConfig projectConfig
	
	override findProjectByName(String name) {
		if (projectConfig.name == name)
			return projectConfig
		else
			return null
	}
	
	override findProjectContaining(URI member) {
		if (projectConfig.path.isPrefixOf(member))
			return projectConfig
		else
			return new InMemoryProjectConfig(member.trimFragment.trimQuery.trimSegments(1))
	}
	
	override getProjects() {
		#{projectConfig}
	}
	
}

@Accessors
class InMemoryProjectConfig implements IProjectConfig {
	
	val URI path
	
	val IWorkspaceConfig workspaceConfig
	
	String name = 'inmemory'
	
	new() {
		this(URI.createURI('inmemory:/'))
	}
	
	new(URI path) {
		this.path = path
		this.workspaceConfig = new InMemoryWorkspaceConfig(this)
	}
	
	override getSourceFolders() {
		emptySet
	}
	
	override findSourceFolderContaining(URI member) {
		null
	}
	
}

