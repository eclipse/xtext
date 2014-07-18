package org.eclipse.xtext.xbase.file

import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.file.Path

@Accessors
class ProjectConfig {
	
	val Path rootPath
	val String name
	val Map<Path,Path> sourceFolderMappings = newLinkedHashMap()
	
	new (String name) {
		this.name = name
		this.rootPath = new Path('''«Path.SEGMENT_SEPARATOR»«name»''')
	}
	
	def void addSourceFolderMapping(String from, String to) {
		sourceFolderMappings.put(rootPath.append(from), rootPath.append(to))
	}
}

