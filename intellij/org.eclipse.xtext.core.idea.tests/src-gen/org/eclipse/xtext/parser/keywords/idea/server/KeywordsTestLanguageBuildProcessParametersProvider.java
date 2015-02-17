package org.eclipse.xtext.parser.keywords.idea.server;

import java.util.Arrays;
import java.util.List;

import com.intellij.compiler.server.BuildProcessParametersProvider;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.extensions.PluginId;

public class KeywordsTestLanguageBuildProcessParametersProvider extends BuildProcessParametersProvider {

	public List<String> getClassPath() {
		String path = PluginManager.getPlugin(PluginId.getId("org.eclipse.xtext.parser.keywords.idea")).getPath().getPath();
		return Arrays.asList(
			path + "/bin", 
			path + "/../org.eclipse.xtext.tests/bin"
		);
	}

}
