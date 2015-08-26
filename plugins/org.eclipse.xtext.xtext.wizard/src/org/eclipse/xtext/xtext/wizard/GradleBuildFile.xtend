package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtext.xtext.wizard.TextFile
import org.eclipse.xtend.lib.annotations.Accessors

class GradleBuildFile extends TextFile {
	@Accessors String pluginsSection = ""
	@Accessors String additionalContent = ""
	
	new(ProjectDescriptor project) {
		super(Outlet.ROOT, "build.gradle", project)
	}
	
	override getContent() {
		'''
			«pluginsSection»
			«IF !allDependencies.isEmpty»
				dependencies {
					«FOR p : project.upstreamProjects»
						compile project(':«p.name»')
					«ENDFOR»
					«FOR dep : mavenDependencies»
						«dep.scope.gradleNotation» "«dep.groupId»:«dep.artifactId»:«dep.version»"
					«ENDFOR»
				}
			«ENDIF»
			«additionalContent»
		'''
	}
	
	private def getMavenDependencies() {
		project.externalDependencies.map[maven].filter[artifactId != null]
	}
	
	private def getAllDependencies() {
		project.upstreamProjects + mavenDependencies
	}
	
}