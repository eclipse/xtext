package org.xtext.gradle.idea.tasks

import org.eclipse.xtend.lib.annotations.Accessors
import org.gradle.api.file.CopySpec
import org.gradle.api.tasks.Sync

@Accessors
class AssembleSandboxTask extends Sync {
	CopySpec classes
	CopySpec libraries
	CopySpec metaInf

	new() {
		classes = rootSpec.addChild.into("classes")
		libraries = rootSpec.addChild.into("lib")
		metaInf = rootSpec.addChild.into("META-INF")
	}
}