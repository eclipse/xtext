/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.util

import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId

/**
 * @author dhuebner - Initial contribution and API
 */
class PlatformUtil {

	def boolean isMavenInstalled() {
		isPluginInstalled("org.jetbrains.idea.maven")
	}

	def boolean isGradleInstalled() {
		isPluginInstalled("org.jetbrains.plugins.gradle")
	}

	def boolean isPluginInstalled(String pluginId) {
		return PluginManager.isPluginInstalled(PluginId.getId(pluginId))
	}
}
