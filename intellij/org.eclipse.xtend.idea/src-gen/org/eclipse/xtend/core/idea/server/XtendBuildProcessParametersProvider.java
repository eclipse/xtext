package org.eclipse.xtend.core.idea.server;

import java.util.Arrays;
import java.util.List;

import com.intellij.compiler.server.BuildProcessParametersProvider;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.extensions.PluginId;

public class XtendBuildProcessParametersProvider extends BuildProcessParametersProvider {

	public List<String> getClassPath() {
		String path = PluginManager.getPlugin(PluginId.getId("org.eclipse.xtend.core.Xtend")).getPath().getPath();
		return Arrays.asList(
			path + "/bin", 
			path + "/../../org.eclipse.xtend.core/bin"
		);
	}

}
