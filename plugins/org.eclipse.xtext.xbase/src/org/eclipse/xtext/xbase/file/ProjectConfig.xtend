package org.eclipse.xtext.xbase.file

import java.util.Map
import org.eclipse.xtend.lib.macro.file.Path

class ProjectConfig {
	
	@Property val Path rootPath
	@Property val String name
	@Property val Map<Path,Path> sourceFolderMappings = newLinkedHashMap()
	
	new (String name) {
		_name = name
		_rootPath = new Path('''«Path.SEGMENT_SEPARATOR»«name»''')
	}
	
	def void addSourceFolderMapping(String from, String to) {
		sourceFolderMappings.put(rootPath.append(from), rootPath.append(to))
	}
}

