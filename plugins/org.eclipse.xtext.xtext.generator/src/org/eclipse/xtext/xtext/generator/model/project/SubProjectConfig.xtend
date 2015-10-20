/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.Issues
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess

class SubProjectConfig implements ISubProjectConfig {
	@Inject
	@Accessors(PUBLIC_GETTER)
	XtextProjectConfig owner
	
	@Accessors
	boolean enabled
	
	@Accessors
	String name
	
	@Accessors(PUBLIC_GETTER)
	String rootPath
	
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess root
	
	@Accessors(PUBLIC_GETTER)
	String metaInfPath
	
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess metaInf
	
	@Accessors(PUBLIC_GETTER)
	String srcPath
	
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess src
	
	@Accessors(PUBLIC_GETTER)
	String srcGenPath
	
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess srcGen
	
	def void setRoot(String path) {
		rootPath = path
	}

	def void setMetaInf(String path) {
		metaInfPath = path
	}

	def void setSrc(String path) {
		srcPath = path
	}

	def void setSrcGen(String path) {
		srcGenPath = path
	}
	
	def void checkConfiguration(Issues issues) {
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
		if (rootPath !== null) {
			root = owner.newFileSystemAccess(rootPath, true)
			root.initialize(injector)
		}
		if (metaInfPath !== null) {
			metaInf = owner.newFileSystemAccess(metaInfPath, true)
			metaInf.initialize(injector)
		}
		if (srcPath !== null) {
			src = owner.newFileSystemAccess(srcPath, false)
			src.initialize(injector)
		}
		if (srcGenPath !== null) {
			srcGen = owner.newFileSystemAccess(srcGenPath, true)
			srcGen.initialize(injector)
		}
	}
	
}
