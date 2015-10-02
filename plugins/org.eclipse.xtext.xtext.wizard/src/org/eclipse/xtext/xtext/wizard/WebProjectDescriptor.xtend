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
class WebProjectDescriptor extends ProjectDescriptor {
	
	static val REQUIREJS_VERSION = '2.1.17'
//	static val REQUIREJS_TEXT_VERSION = '2.0.10-3'
	static val JQUERY_VERSION = '2.1.4'
	static val JETTY_VERSION = '9.2.11.v20150529'
	static val SLF4J_VERSION = '1.7.12'
	static val ACE_VERSION = '1.1.9'
	
	override getUpstreamProjects() {
		newLinkedHashSet(config.runtimeProject, config.ideProject)
	}
	
	override getNameQualifier() {
		".web"
	}
	
	override isEclipsePluginProject() {
		false
	}
	
	override isPartOfGradleBuild() {
		config.preferredBuildSystem == BuildSystem.GRADLE
	}
	
	override isPartOfMavenBuild() {
		config.preferredBuildSystem == BuildSystem.MAVEN
	}
	
	override getExternalDependencies() {
		val deps = newLinkedHashSet
		deps += super.externalDependencies
		deps += createXtextDependency("org.eclipse.xtext.xbase.web")
		deps += createXtextDependency("org.eclipse.xtext.web.servlet")
		deps += createMavenDependency("org.eclipse.xtend:org.eclipse.xtend.lib:${xtextVersion}")
		deps += createMavenDependency("org.webjars:requirejs:" + REQUIREJS_VERSION)
		// RequireJS-Text is only needed for Orion
//		deps += createMavenDependency("org.webjars:requirejs-text:" + REQUIREJS_TEXT_VERSION)
		deps += createMavenDependency("org.webjars:jquery:" + JQUERY_VERSION)
		deps += createMavenDependency("org.webjars:ace:" + ACE_VERSION)
		deps += createMavenDependency("org.eclipse.jetty:jetty-annotations:" + JETTY_VERSION) => [maven.scope = Scope.PROVIDED]
		deps += createMavenDependency("org.slf4j:slf4j-simple:" + SLF4J_VERSION) => [maven.scope = Scope.PROVIDED]
		return deps
	}
	
	override buildGradle() {
		super.buildGradle => [
			pluginsSection = '''
				plugins {
					id 'war'
				}
			'''
			additionalContent = '''
				task jettyRun(type:JavaExec) {
					dependsOn(sourceSets.main.runtimeClasspath)
					classpath = sourceSets.main.runtimeClasspath.filter{it.exists()}
					main = "«config.language.basePackage».web.ServerLauncher"
					standardInput = System.in
				}
			'''
		]
	}

	override pom() {
		super.pom => [
			packaging = "war"
			buildSection = '''
				<build>
					«IF config.sourceLayout == SourceLayout.PLAIN»
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
						<plugin>
							<artifactId>maven-war-plugin</artifactId>
							<version>2.6</version>
							<configuration>
								<warSourceDirectory>«Outlet.WEBAPP.sourceFolder»</warSourceDirectory>
								<failOnMissingWebXml>false</failOnMissingWebXml>
							</configuration>
						</plugin>
						<plugin>
							<groupId>org.eclipse.jetty</groupId>
							<artifactId>jetty-maven-plugin</artifactId>
							<version>9.2.13.v20150730</version>
							<configuration>
								<webAppSourceDirectory>«Outlet.WEBAPP.sourceFolder»</webAppSourceDirectory>
							</configuration>
						</plugin>
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
												</excludes>
											</resource>
										</resources>
									</configuration>
								</execution>
							</executions>
						</plugin>
					</plugins>
				</build>
			'''
		]
	}	
}