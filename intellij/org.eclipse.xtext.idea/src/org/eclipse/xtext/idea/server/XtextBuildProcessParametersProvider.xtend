/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.server

import com.intellij.compiler.server.BuildProcessParametersProvider
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId
import java.io.File

class XtextBuildProcessParametersProvider extends BuildProcessParametersProvider {

	override getClassPath() {
		val pluginId = PluginId.getId("org.eclipse.xtext.idea")
		val plugin = PluginManager.getPlugin(pluginId)
		val libs = newArrayList
		libs += new File(plugin.path, 'lib').listFiles.map[absolutePath]
		libs += new File(plugin.path, 'builder').listFiles.map[absolutePath]
		libs
	}

}
