package org.eclipse.xtext.idea.example.entities.idea.server

import com.intellij.compiler.server.BuildProcessParametersProvider
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId

class EntitiesBuildProcessParametersProvider extends BuildProcessParametersProvider {

	override getClassPath() {
		val plugin = PluginManager.getPlugin(PluginId.getId("org.eclipse.xtext.idea.example.entities.Entities"));
		val path = plugin.path.path

		#[
			path + "/bin",
			path + "/../org.eclipse.xtext.idea.example.entities/bin"
		]
	}

}
