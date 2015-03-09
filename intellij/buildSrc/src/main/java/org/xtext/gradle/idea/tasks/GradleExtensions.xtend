package org.xtext.gradle.idea.tasks

import groovy.lang.Closure
import org.gradle.api.Project
import org.gradle.api.file.CopySpec
import java.io.File

class GradleExtensions {
	static def copy(Project project, (CopySpec)=>void copyspec) {
		project.copy(new Closure(null) {
			override getMaximumNumberOfParameters() {
				1
			}

			override call(Object argument) {
				copyspec.apply(argument as CopySpec)
				null
			}
		})
	}
	
	static def /(File parent, String child) {
		new File(parent, child)
	}
}