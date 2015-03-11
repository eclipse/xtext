package org.eclipse.xtext.idea.common.types.idea.server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.intellij.compiler.server.BuildProcessParametersProvider;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.extensions.PluginId;

public class RefactoringTestLanguageBuildProcessParametersProvider extends BuildProcessParametersProvider {

	public List<String> getClassPath() {
		PluginId pluginId = PluginId.getId("org.eclipse.xtext.idea.common.types.tests");
		File pluginFolder = PluginManager.getPlugin(pluginId).getPath();

		List<String> result = new ArrayList<String>();

		File libFolder = new File(pluginFolder, "lib");
		if (libFolder.exists()) {
			for (File file : libFolder.listFiles()) {
				result.add(file.getAbsolutePath());
			}
		}

		File classesFolder = new File(pluginFolder, "classes");
		if (classesFolder.exists()) {
			result.add(classesFolder.getAbsolutePath());
		}

		return result;
	}

}
