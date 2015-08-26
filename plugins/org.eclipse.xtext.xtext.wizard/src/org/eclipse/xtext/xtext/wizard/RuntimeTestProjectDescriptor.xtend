package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import static org.eclipse.xtext.xtext.wizard.ExternalDependency.*

@FinalFieldsConstructor
class RuntimeTestProjectDescriptor extends TestProjectDescriptor {

	override getExternalDependencies() {
		val deps = newHashSet
		deps += super.externalDependencies
		deps += createXtextDependency("org.eclipse.xtext.junit4") => [maven.scope = Scope.TESTCOMPILE]
		deps += createXtextDependency("org.eclipse.xtext.xbase.junit") => [maven.scope = Scope.TESTCOMPILE]
		deps
	}
	
	override isEclipsePluginProject() {
		config.buildSystem.isPluginBuild
	}

	override pom() {
		super.pom => [
			packaging = if(isEclipsePluginProject) "eclipse-test-plugin" else "jar"
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
		]
	}
}