package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtext.xtext.wizard.TestProjectDescriptor
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import static org.eclipse.xtext.xtext.wizard.ExternalDependency.*

@FinalFieldsConstructor
class UiTestProjectDescriptor extends TestProjectDescriptor {
	
	override getExternalDependencies() {
		val deps = newLinkedHashSet
		deps += super.externalDependencies
		deps += createXtextDependency("org.eclipse.xtext.junit4") => [maven.scope = Scope.TESTCOMPILE]
		deps += createXtextDependency("org.eclipse.xtext.xbase.junit") => [maven.scope = Scope.TESTCOMPILE]
		deps
	}
	
	override isPartOfGradleBuild() {
		false
	}
	
	override isPartOfMavenBuild() {
		true
	}
	
}