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

/**
 * @noextend
 */
class SubProjectConfig implements ISubProjectConfig {
	@Inject
	@Accessors(PUBLIC_GETTER)
	XtextProjectConfig owner
	
	@Accessors
	boolean enabled
	
	@Accessors
	boolean overwriteSrc
	
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
		if (!rootPath.isNullOrEmpty) {
			root = owner.newFileSystemAccess(rootPath, true)
			root.initialize(injector)
		}
		if (!metaInfPath.isNullOrEmpty) {
			metaInf = owner.newFileSystemAccess(metaInfPath, true)
			metaInf.initialize(injector)
		}
		if (!srcPath.isNullOrEmpty) {
			src = owner.newFileSystemAccess(srcPath, overwriteSrc)
			src.initialize(injector)
		}
		if (!srcGenPath.isNullOrEmpty) {
			srcGen = owner.newFileSystemAccess(srcGenPath, true)
			srcGen.initialize(injector)
		}
	}
	
}
