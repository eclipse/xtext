/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors

abstract class TestProjectDescriptor extends ProjectDescriptor {
	@Accessors val ProjectDescriptor testedProject
	
	new(TestedProjectDescriptor testedProject) {
		super(testedProject.config)
		this.testedProject = testedProject
	}
	
	override getSourceFolders() {
		#[Outlet.TEST_JAVA, Outlet.TEST_RESOURCES, Outlet.TEST_SRC_GEN, Outlet.TEST_XTEND_GEN].map[sourceFolder].toSet
	}
	
	def isInlined() {
		enabled && config.sourceLayout != SourceLayout.PLAIN
	}
	
	def isSeparate() {
		enabled && config.sourceLayout == SourceLayout.PLAIN
	}
	
	override getNameQualifier() {
		testedProject.nameQualifier + ".tests"
	}
	
	override getUpstreamProjects() {
		#{testedProject}
	}
	
	override isEclipsePluginProject() {
		testedProject.isEclipsePluginProject
	}
	
	override getExternalDependencies() {
		val deps = newLinkedHashSet
		deps += super.externalDependencies
		deps += new ExternalDependency()=>[
			p2.bundleId = "org.junit"
			p2.version = "4.7.0"
		]
		return deps
	}
	
	override pom() {
		super.pom => [
			packaging = if(isEclipsePluginProject) "eclipse-test-plugin" else "jar"
			buildSection = '''
				<build>
					«IF !isEclipsePluginProject && config.sourceLayout == SourceLayout.PLAIN»
						<testSourceDirectory>«Outlet.TEST_JAVA.sourceFolder»</testSourceDirectory>
						<testResources>
							<testResource>
								<directory>«Outlet.TEST_RESOURCES.sourceFolder»</directory>
								<excludes>
									<exclude>**/*.java</exclude>
									<exclude>**/*.xtend</exclude>
								</excludes>
							</testResource>
						</testResources>
					«ENDIF»
					<plugins>
						<plugin>
							<groupId>org.eclipse.xtend</groupId>
							<artifactId>xtend-maven-plugin</artifactId>
						</plugin>
						«IF isEclipsePluginProject»
							<plugin>
								<groupId>org.eclipse.tycho</groupId>
								<artifactId>tycho-surefire-plugin</artifactId>
								<version>${tycho-version}</version>
								<configuration>
									<failIfNoTests>false</failIfNoTests>
									«IF needsUiHarness»
										<useUIHarness>true</useUIHarness>
									«ENDIF»
								</configuration>
							</plugin>
						«ENDIF»
						«IF !isEclipsePluginProject»
							<plugin>
								<groupId>org.codehaus.mojo</groupId>
								<artifactId>build-helper-maven-plugin</artifactId>
								<version>1.9.1</version>
								<executions>
									<execution>
										<id>add-test-source</id>
										<phase>initialize</phase>
										<goals>
											<goal>add-test-source</goal>
											<goal>add-test-resource</goal>
										</goals>
										<configuration>
											<sources>
												<source>«Outlet.TEST_SRC_GEN.sourceFolder»</source>
											</sources>
											<resources>
												<resource>
													<directory>«Outlet.TEST_SRC_GEN.sourceFolder»</directory>
													<excludes>
														<exclude>**/*.java</exclude>
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
			if (isEclipsePluginProject && needsUiHarness) {
				profileSection = '''
					<profiles>
						<profile>
							<id>testing-on-mac</id>
							<activation>
								<os>
									<family>mac</family>
								</os>
							</activation>
							<properties>
								<tycho.testArgLine>-XstartOnFirstThread</tycho.testArgLine>
							</properties>
						</profile>
					</profiles>
				'''
			}
		]
	}
	
	def needsUiHarness() {
		false
	}
}