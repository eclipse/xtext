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
import org.eclipse.xtext.xtext.generator.Issues
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess

/**
 * @noextend
 */
@Accessors
class BundleProjectConfig extends SubProjectConfig implements IBundleProjectConfig{
	ManifestAccess manifest
	PluginXmlAccess pluginXml
	
	override initialize(Injector injector) {
		super.initialize(injector)
		manifest?.initialize(injector)
		pluginXml?.initialize(injector)
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		if (manifest !== null && metaInf === null) {
			issues.addError("The 'metaInf' outlet must be configured for projects with a manifest", this)
		}
		if (pluginXml !== null && root === null) {
			issues.addError("The 'root' outlet must be configured for projects with a plugin.xml", this)
		}
	}
	
}
