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
		#{config.runtimeProject, config.ideProject}
	}
	
	override getNameQualifier() {
		".web"
	}
	
	override isEclipsePluginProject() {
		false
	}
	
	override getFiles() {
		emptyList
	}
	
	override getExternalDependencies() {
		val deps = newHashSet
		deps += super.externalDependencies
		deps += createXtextDependency("org.eclipse.xtext.web.servlet")
		deps += createMavenDependency("org.eclipse.xtend:org.eclipse.xtend.lib:${xtextVersion}")
		deps += createMavenDependency("org.eclipse.xtext:org.eclipse.xtext.web.servlet:${xtextVersion}")
		deps += createMavenDependency("org.webjars:requirejs:" + REQUIREJS_VERSION)
		// RequireJS-Text is only needed for Orion
//		deps += createMavenDependency("org.webjars:requirejs-text:" + REQUIREJS_TEXT_VERSION)
		deps += createMavenDependency("org.webjars:jquery:" + JQUERY_VERSION)
		deps += createMavenDependency("org.webjars:ace:" + ACE_VERSION)
		deps += createMavenDependency("org.eclipse.jetty:jetty-annotations:" + JETTY_VERSION) => [maven.scope = Scope.PROVIDED]
		deps += createMavenDependency("org.slf4j:slf4j-api:" + SLF4J_VERSION + "@jar") => [maven.scope = Scope.PROVIDED]
		deps += createMavenDependency("org.slf4j:slf4j-log4j12:" + SLF4J_VERSION + "@jar") => [maven.scope = Scope.PROVIDED]
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
							</configuration>
						</plugin>
					</plugins>
				</build>
			'''
		]
	}	
}