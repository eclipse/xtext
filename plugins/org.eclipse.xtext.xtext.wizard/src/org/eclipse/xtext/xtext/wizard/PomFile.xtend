/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors

class PomFile extends TextFile {
	@Accessors String packaging = "jar"
	@Accessors String buildSection = ""

	new(ProjectDescriptor project) {
		super(Outlet.ROOT, "pom.xml", project)
	}

	override getContent() '''
		<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
			<modelVersion>4.0.0</modelVersion>
			«IF project != project.config.parentProject»
				<parent>
					<groupId>«project.config.baseName»</groupId>
					<artifactId>«project.config.parentProject.name»</artifactId>
					<version>1.0.0-SNAPSHOT</version>
					«IF project.config.projectLayout == ProjectLayout.FLAT»
						<relativePath>../«project.config.parentProject.name»/pom.xml</relativePath>
					«ENDIF»
				</parent>
			«ELSE»
				<groupId>«project.config.baseName»</groupId>
				<version>1.0.0-SNAPSHOT</version>
			«ENDIF»
			<artifactId>«project.name»</artifactId>
			<packaging>«packaging»</packaging>
		
			«buildSection»
		
			«IF !project.isEclipsePluginProject»
			<dependencies>
				«FOR p: project.upstreamProjects»
					<dependency>
						<groupId>${project.groupId}</groupId>
						<artifactId>«p.name»</artifactId>
						<version>${project.version}</version>
					</dependency>
				«ENDFOR»
				«FOR dep : project.externalDependencies.map[maven].filter[artifactId != null]»
					<dependency>
						<groupId>«dep.groupId»</groupId>
						<artifactId>«dep.artifactId»</artifactId>
						<version>«dep.version»</version>
						«IF dep.scope != Scope.COMPILE»
							<scope>«dep.scope.mavenNotation»</scope>
						«ENDIF»
					</dependency>
				«ENDFOR»
			</dependencies>
			«ENDIF»
		</project>
	'''
}