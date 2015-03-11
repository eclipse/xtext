package org.xtext.gradle.idea.tasks

import org.eclipse.xtend.lib.annotations.Accessors
import org.gradle.api.file.CopySpec
import org.gradle.api.tasks.bundling.Zip

@Accessors(PUBLIC_GETTER)
class IdeaZip extends Zip implements IdeaPluginSpec {
	CopySpec classes
	CopySpec libraries
	CopySpec metaInf

	new() {
		rootSpec.into(project.name)
		classes = rootSpec.addChild.into("classes")
		libraries = rootSpec.addChild.into("lib")
		metaInf = rootSpec.addChild.into("META-INF")
	}
}