package org.eclipse.xtext.xbase.file

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data

@Data class WorkspaceConfig {
	String absoluteFileSystemPath
	Map<String,ProjectConfig> projects = newLinkedHashMap()
	
	def addProjectConfig(ProjectConfig config) {
		projects.put(config.getName(), config);
	}
	
}
