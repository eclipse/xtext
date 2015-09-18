package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors

abstract class TestProjectDescriptor extends ProjectDescriptor {
	@Accessors val ProjectDescriptor testedProject
	
	new(TestedProjectDescriptor testedProject) {
		super(testedProject.config)
		this.testedProject = testedProject
	}
	
	override getSourceFolders() {
		#{Outlet.TEST_JAVA, Outlet.TEST_RESOURCES, Outlet.TEST_SRC_GEN, Outlet.TEST_XTEND_GEN}.map[sourceFolder].toSet
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
	
	override pom() {
		super.pom => [
			packaging = if(isEclipsePluginProject) "eclipse-test-plugin" else "jar"
			buildSection = '''
				<build>
					«IF !isEclipsePluginProject && config.sourceLayout == SourceLayout.PLAIN»
						<sourceDirectory>«Outlet.TEST_JAVA.sourceFolder»</sourceDirectory>
						<resources>
							<resource>
								<directory>«Outlet.TEST_RESOURCES.sourceFolder»</directory>
							</resource>
						</resources>
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
		]
	}
	
	def needsUiHarness() {
		false
	}
}