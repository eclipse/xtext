package org.eclipse.xtext.idea.common.types.idea.server

import com.intellij.compiler.server.BuildProcessParametersProvider
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId

class RefactoringTestLanguageBuildProcessParametersProvider extends BuildProcessParametersProvider {

	override getClassPath() {
		val plugin = PluginManager.getPlugin(PluginId.getId("org.eclipse.xtext.idea.common.types.RefactoringTestLanguage"));
		val path = plugin.path.path

		#[
			path + "/bin",
			path + "/../org.eclipse.xtext.idea.common.types.RefactoringTestLanguage/bin"
		]
	}

}
