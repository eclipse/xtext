package org.eclipse.xtext.idea.server

import com.intellij.compiler.server.BuildProcessParametersProvider
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId
import java.io.File

class XtextBuildProcessParametersProvider extends BuildProcessParametersProvider {

	override getClassPath() {
		val plugin = PluginManager.getPlugin(PluginId.getId("org.xtext.idea"))
		val pluginFolder = plugin.path

		val result = newArrayList(pluginFolder.path + "/../org.xtext.idea.builder/bin")
		result += new File(pluginFolder, 'lib').listFiles.filter[file && name.endsWith('.jar')].map[path]
		result
	}

}
