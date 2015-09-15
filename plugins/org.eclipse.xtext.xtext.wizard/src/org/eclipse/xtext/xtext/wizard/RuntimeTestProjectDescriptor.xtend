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
	
	override isPartOfGradleBuild() {
		config.preferredBuildSystem == BuildSystem.GRADLE
	}

	override isPartOfMavenBuild() {
		config.preferredBuildSystem == BuildSystem.MAVEN
	}
		
}