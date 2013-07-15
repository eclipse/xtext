package org.eclipse.xtext.xbase.file

import java.util.Map

@Data class WorkspaceConfig {
	String absoluteFileSystemPath
	Map<String,ProjectConfig> projects = newLinkedHashMap()
	
	def addProjectConfig(ProjectConfig config) {
		projects.put(config.getName(), config);
	}
	
}
