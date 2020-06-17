/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.JUnitVersion

@FinalFieldsConstructor
class TargetPlatformProject extends ProjectDescriptor {

	override getNameQualifier() {
		".target"
	}
	
	override isEclipsePluginProject() {
		false
	}
	
	override isPartOfGradleBuild() {
		false
	}
	
	override isPartOfMavenBuild() {
		true
	}
	
	override isEnabled() {
		config.needsTychoBuild
	}
	
	override setEnabled(boolean enabled) {
		throw new UnsupportedOperationException("The target platform project is activated automatically for Tycho builds")
	}

	override getFiles() {
		val files = newArrayList
		files += super.files
		files += file(Outlet.ROOT, name + ".target", target)
		files
	}
	
	override getSourceFolders() {
		#{}
	}

	def target() '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde version="3.8"?>
		<target name="«name»" sequenceNumber="1">
			<locations>
				<location includeAllPlatforms="false" includeConfigurePhase="false" includeMode="planner" includeSource="true" type="InstallableUnit">
					<unit id="org.eclipse.jdt.feature.group" version="0.0.0"/>
					<unit id="org.eclipse.platform.feature.group" version="0.0.0"/>
					<unit id="org.eclipse.pde.feature.group" version="0.0.0"/>
					<unit id="org.eclipse.draw2d.feature.group" version="0.0.0"/>
					<unit id="org.eclipse.emf.sdk.feature.group" version="0.0.0"/>
					<repository location="https://download.eclipse.org/releases/2020-09"/>
				</location>
				<location includeAllPlatforms="false" includeConfigurePhase="false" includeMode="planner" includeSource="true" type="InstallableUnit">
					<unit id="org.eclipse.emf.mwe2.launcher.feature.group" version="0.0.0"/>
					<repository location="https://download.eclipse.org/modeling/emft/mwe/updates/releases/«config.xtextVersion.mweVersion»/"/>
				</location>
				<location includeAllPlatforms="false" includeConfigurePhase="false" includeMode="planner" includeSource="true" type="InstallableUnit">
					<unit id="org.eclipse.xtext.sdk.feature.group" version="0.0.0"/>
					«IF config.xtextVersion.isSnapshot»
						<repository location="https://download.eclipse.org/modeling/tmf/xtext/updates/nightly/"/>
					«ELSEIF config.xtextVersion.isStable»
						<repository location="https://download.eclipse.org/modeling/tmf/xtext/updates/milestones/"/>
					«ELSE»
						<repository location="https://download.eclipse.org/modeling/tmf/xtext/updates/releases/«config.xtextVersion»/"/>
					«ENDIF»
				</location>
				<location includeAllPlatforms="false" includeConfigurePhase="false" includeMode="planner" includeSource="true" type="InstallableUnit">
					<unit id="com.google.gson" version="2.8.2.v20180104-1110"/>
					<unit id="org.antlr.runtime" version="3.2.0.v201101311130"/>
					<unit id="org.junit" version="4.12.0.v201504281640"/>
					«IF config.junitVersion == JUnitVersion.JUNIT_5»
						<unit id="org.junit.jupiter.api" version="5.6.0.v20200203-2009"/>
						<unit id="org.junit.jupiter.engine" version="5.6.0.v20200203-2009"/>
						<unit id="org.junit.platform.commons" version="1.6.0.v20200203-2009"/>
						<unit id="org.junit.platform.engine" version="1.6.0.v20200203-2009"/>
						<unit id="org.junit.platform.launcher" version="1.6.0.v20200203-2009"/>
						<unit id="org.junit.platform.runner" version="1.6.0.v20200203-2009"/>
						<unit id="org.opentest4j" version="1.2.0.v20190826-0900"/>
					«ENDIF»
					<unit id="org.objectweb.asm" version="8.0.1.v20200420-1007"/>
					<unit id="org.objectweb.asm.tree" version="8.0.1.v20200420-1007"/>
					<unit id="io.github.classgraph" version="4.8.35.v20190528-1517"/>
					<repository location="https://download.eclipse.org/tools/orbit/downloads/2020-09"/>
				</location>
			</locations>
		</target>
	'''

	override buildGradle() {
		throw new UnsupportedOperationException("Eclipse target platforms are not yet supported in Gradle")
	}

	override pom() {
		super.pom => [
			packaging = "eclipse-target-definition"
		]
	}

}
