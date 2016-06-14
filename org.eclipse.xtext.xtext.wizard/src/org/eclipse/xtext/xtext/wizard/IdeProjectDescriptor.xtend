/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import static org.eclipse.xtext.xtext.wizard.ExternalDependency.*

@FinalFieldsConstructor
class IdeProjectDescriptor extends ProjectDescriptor {
	
	override getNameQualifier() {
		".ide"
	}

	override getUpstreamProjects() {
		#{config.runtimeProject}
	}
	
	override isEclipsePluginProject() {
		config.preferredBuildSystem == BuildSystem.NONE || config.uiProject.enabled
	}
	
	override isPartOfGradleBuild() {
		true
	}
	
	override isPartOfMavenBuild() {
		true
	}
	
	override getExternalDependencies() {
		val deps = newLinkedHashSet
		deps += super.externalDependencies
		deps += createXtextDependency("org.eclipse.xtext.ide")
		deps += createXtextDependency("org.eclipse.xtext.xbase.ide")
		deps
	}
	
	override pom() {
		super.pom => [
			buildSection = '''
				<build>
					«IF !isEclipsePluginProject && config.sourceLayout == SourceLayout.PLAIN»
						<sourceDirectory>«Outlet.MAIN_JAVA.sourceFolder»</sourceDirectory>
						<resources>
							<resource>
								<directory>«Outlet.MAIN_RESOURCES.sourceFolder»</directory>
								<excludes>
									<exclude>**/*.java</exclude>
									<exclude>**/*.xtend</exclude>
								</excludes>
							</resource>
						</resources>
					«ENDIF»
					<plugins>
						<plugin>
							<groupId>org.eclipse.xtend</groupId>
							<artifactId>xtend-maven-plugin</artifactId>
						</plugin>
						«IF !isEclipsePluginProject»
							<plugin>
								<groupId>org.codehaus.mojo</groupId>
								<artifactId>build-helper-maven-plugin</artifactId>
								<version>1.9.1</version>
								<executions>
									<execution>
										<id>add-source</id>
										<phase>initialize</phase>
										<goals>
											<goal>add-source</goal>
											<goal>add-resource</goal>
										</goals>
										<configuration>
											<sources>
												<source>«Outlet.MAIN_SRC_GEN.sourceFolder»</source>
											</sources>
											<resources>
												<resource>
													<directory>«Outlet.MAIN_SRC_GEN.sourceFolder»</directory>
													<excludes>
														<exclude>**/*.java</exclude>
														<exclude>**/*.g</exclude>
													</excludes>
												</resource>
											</resources>
										</configuration>
									</execution>
								</executions>
							</plugin>
						«ENDIF»
					</plugins>
				</build>
			'''
			packaging = if (isEclipsePluginProject) "eclipse-plugin" else "jar"
		]
	}

}