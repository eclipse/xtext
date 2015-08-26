package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import static org.eclipse.xtext.xtext.wizard.ExternalDependency.*

@FinalFieldsConstructor
class UiProjectDescriptor extends ProjectDescriptor {
	
	override getUpstreamProjects() {
		#{config.runtimeProject, config.ideProject}.filter[enabled].toSet
	}
	
	override getNameQualifier() {
		".ui"
	}
	
	override getSourceFolders() {
		#{Outlet.MAIN_JAVA, Outlet.MAIN_RESOURCES, Outlet.MAIN_SRC_GEN, Outlet.MAIN_XTEND_GEN}.map[sourceFolder].toSet
	}
	
	override getExternalDependencies() {
		val deps = newHashSet
		deps += super.externalDependencies
		deps += createXtextDependency("org.eclipse.xtext.ui")
		deps += new ExternalDependency => [
			p2 [
				bundleId = "org.eclipse.ui.editors"
				version = "3.5.0"
			]
		]
		deps += new ExternalDependency => [
			p2 [
				bundleId = "org.eclipse.ui.ide"
				version = "3.5.0"
			]
		]
		if (!config.ideProject.enabled) {
			deps += config.ideProject.externalDependencies
		}
		deps
	}
	
	override getBinIncludes() {
		val includes = newHashSet
		includes += super.binIncludes
		includes += "plugin.xml"
		includes
	}
	
	override buildGradle() {
		throw new UnsupportedOperationException("UI projects cannot be built with Gradle yet")
	}
	
	override pom() {
		super.pom => [
			buildSection = '''
				<build>
					<plugins>
						<plugin>
							<groupId>org.eclipse.xtend</groupId>
							<artifactId>xtend-maven-plugin</artifactId>
						</plugin>
					</plugins>
				</build>
			'''
			packaging = if (config.buildSystem == BuildSystem.TYCHO) "eclipse-plugin" else "jar"
		]
	}
}