/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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
	
	override needsUiHarness() {
		true
	}
	
}