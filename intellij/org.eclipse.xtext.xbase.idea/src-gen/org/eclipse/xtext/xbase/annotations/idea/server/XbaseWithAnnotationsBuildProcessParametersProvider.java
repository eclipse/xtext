package org.eclipse.xtext.xbase.annotations.idea.server;

import java.util.Arrays;
import java.util.List;

import com.intellij.compiler.server.BuildProcessParametersProvider;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.extensions.PluginId;

public class XbaseWithAnnotationsBuildProcessParametersProvider extends BuildProcessParametersProvider {

	public List<String> getClassPath() {
		String path = PluginManager.getPlugin(PluginId.getId("org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations")).getPath().getPath();
		return Arrays.asList(
			path + "/bin", 
			path + "/../../org.eclipse.xtext.xbase.idea/../../plugins/org.eclipse.xtext.xbase/bin"
		);
	}

}
