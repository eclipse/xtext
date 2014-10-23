package org.xtext.idea.sdomain.idea.server

import com.intellij.compiler.server.BuildProcessParametersProvider
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId

class SDomainBuildProcessParametersProvider extends BuildProcessParametersProvider {

	override getClassPath() {
		val plugin = PluginManager.getPlugin(PluginId.getId("org.xtext.idea.sdomain.SDomain"));
		val path = plugin.path.path

		#[
			path + "/bin",
			path + "/../org.xtext.idea.sdomain/bin"
		]
	}

}
