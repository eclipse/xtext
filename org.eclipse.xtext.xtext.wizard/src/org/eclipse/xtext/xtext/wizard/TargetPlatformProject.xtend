/*******************************************************************************
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
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
					<repository location="https://download.eclipse.org/releases/2023-03"/>
				</location>
				<location includeAllPlatforms="false" includeConfigurePhase="false" includeMode="planner" includeSource="true" type="InstallableUnit">
					<unit id="org.eclipse.emf.mwe2.launcher.feature.group" version="0.0.0"/>
					«IF config.xtextVersion.mweVersion.matches("\\d+\\.\\d+(\\.\\d+)+")»
						<repository location="https://download.eclipse.org/modeling/emft/mwe/updates/releases/«config.xtextVersion.mweVersion»/"/>
					«ELSE»
						<repository location="https://download.eclipse.org/modeling/emft/mwe/updates/milestones/«config.xtextVersion.mweBuildNumber»/"/>
					«ENDIF»
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
					<unit id="com.google.gson" version="2.10.1.v20230109-0753"/>
					<unit id="com.google.inject" version="5.0.1.v20221112-0806"/>
					<unit id="javax.inject" version="1.0.0.v20220405-0441"/>
					<unit id="org.antlr.runtime" version="3.2.0.v20220404-1927"/>
					<unit id="org.junit" version="4.13.2.v20211018-1956"/>
					«IF config.junitVersion == JUnitVersion.JUNIT_5»
						<unit id="org.apiguardian" version="1.1.2.v20211018-1956"/>
						<unit id="org.junit.jupiter.api" version="5.9.1.v20221103-2317"/>
						<unit id="org.junit.jupiter.engine" version="5.9.1.v20221103-2317"/>
						<unit id="org.junit.jupiter.migrationsupport" version="5.9.1.v20221103-2317"/>
						<unit id="org.junit.jupiter.params" version="5.9.1.v20221103-2317"/>
						<unit id="org.junit.platform.commons" version="1.9.1.v20221103-2317"/>
						<unit id="org.junit.platform.engine" version="1.9.1.v20221103-2317"/>
						<unit id="org.junit.platform.launcher" version="1.9.1.v20221103-2317"/>
						<unit id="org.junit.platform.runner" version="1.9.1.v20221103-2317"/>
						<unit id="org.junit.platform.suite.commons" version="1.9.1.v20221103-2317"/>
						<unit id="org.junit.vintage.engine" version="5.9.1.v20221103-2317"/>
						<unit id="org.opentest4j" version="1.2.0.v20211018-1956"/>
					«ENDIF»
					<unit id="org.objectweb.asm" version="9.4.0.v20221107-1714"/>
					<unit id="io.github.classgraph" version="4.8.149.v20220915-0556"/>
					<repository location="https://download.eclipse.org/tools/orbit/downloads/2023-03"/>
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
