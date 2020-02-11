/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project

import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess

/**
 * Configuration of the web project.
 * 
 * @noextend This class should not be extended by clients.
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
