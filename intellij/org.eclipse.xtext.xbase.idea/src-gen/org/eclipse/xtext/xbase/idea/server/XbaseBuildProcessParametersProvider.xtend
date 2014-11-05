package org.eclipse.xtext.xbase.idea.server

import com.intellij.compiler.server.BuildProcessParametersProvider
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId

class XbaseBuildProcessParametersProvider extends BuildProcessParametersProvider {

	override getClassPath() {
		val plugin = PluginManager.getPlugin(PluginId.getId("org.eclipse.xtext.xbase.Xbase"));
		val path = plugin.path.path

		#[
			path + "/bin",
			path + "/../org.eclipse.xtext.xbase.idea/../../plugins/org.eclipse.xtext.xbase/bin"
		]
	}

}
