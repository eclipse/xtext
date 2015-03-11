package org.xtext.gradle.idea.tasks

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class IdeaExtension {
	Object ideaHome
	String ideaVersion
	Object sandboxDir
}
