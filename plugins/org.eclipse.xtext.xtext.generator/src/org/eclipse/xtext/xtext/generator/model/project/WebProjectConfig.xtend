/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project

import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess

/**
 * @noextend
 */
class WebProjectConfig extends SubProjectConfig implements IWebProjectConfig {
	@Accessors(PUBLIC_GETTER)
	String assetsPath
	@Accessors(PUBLIC_GETTER)
	IXtextGeneratorFileSystemAccess assets
	
	def void setAssets(String path) {
		assetsPath = path
	}
	
	override initialize(Injector injector) {
		super.initialize(injector)
		if (assetsPath !== null) {
			assets = owner.newFileSystemAccess(assetsPath, true)
			assets.initialize(injector)
		}
	}
}