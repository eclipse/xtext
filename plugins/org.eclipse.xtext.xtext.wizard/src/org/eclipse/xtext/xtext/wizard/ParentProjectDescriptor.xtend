package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class ParentProjectDescriptor extends ProjectDescriptor {

	override getNameQualifier() {
		".parent"
	}

	override getLocation() {
		if (config.projectLayout == ProjectLayout.FLAT) {
			config.rootLocation + "/" + name
		} else {
			config.rootLocation + "/" + config.baseName
		}
	}

	override isEclipsePluginProject() {
		false
	}

	override getFiles() {
		val files = newArrayList
		files += super.files
		if (config.buildSystem.isGradleBuild) {
			files += file(Outlet.ROOT, 'settings.gradle', settingsGradle)
			if (config.sourceLayout == SourceLayout.PLAIN) {
				files += file(Outlet.ROOT, 'gradle/plain-layout.gradle', plainLayout)
			}
		}
		return files
	}

	override buildGradle() {
		super.buildGradle => [
			additionalContent = '''
				buildscript {
					repositories {
						jcenter()
					}
					dependencies {
						classpath 'org.xtend:xtend-gradle-plugin:0.4.8'
					}
				}
				subprojects {
					ext.xtextVersion = "«config.xtextVersion»"
					repositories {
						jcenter()
						«IF config.xtextVersion.isSnapshot»
							maven {
								url "https://oss.sonatype.org/content/repositories/snapshots/"
							}
						«ENDIF»
					}
					apply plugin: 'java'
					apply plugin: 'org.xtend.xtend'
					«IF config.sourceLayout == SourceLayout.PLAIN»
						apply from: "${rootDir}/gradle/plain-layout.gradle"
					«ENDIF»
				}
			'''
		]
	}

	def settingsGradle() '''
		«FOR p : config.enabledProjects.filter[it != this]»
			«IF config.projectLayout == ProjectLayout.FLAT»includeFlat«ELSE»include«ENDIF» '«p.name»'
		«ENDFOR»
	'''
	
	def plainLayout() '''
		if (name.endsWith(".tests")) {
			sourceSets.test.java.srcDirs = ['src', 'src-gen']
			sourceSets.test.resources.srcDirs = ['src', 'src-gen']
			sourceSets.test.xtendOutputDir = 'xtend-gen'
			sourceSets.main.java.srcDirs = []
			sourceSets.main.resources.srcDirs = []
		} else {
			sourceSets.main.java.srcDirs = ['src', 'src-gen']
			sourceSets.main.resources.srcDirs = ['src', 'src-gen']
			sourceSets.main.xtendOutputDir = 'xtend-gen'
			sourceSets.test.java.srcDirs = []
			sourceSets.test.resources.srcDirs = []
		}
		plugins.withId('war') {
			webAppDirName = "WebRoot"
		}
	'''

	override pom() {
		super.pom => [
			packaging = "pom"
			buildSection = '''
				<properties>
					«IF config.buildSystem == BuildSystem.TYCHO»
						<tycho-version>0.23.1</tycho-version>
					«ENDIF»
					<xtextVersion>«config.xtextVersion»</xtextVersion>
					<project.build.sourceEncoding>«config.encoding»</project.build.sourceEncoding>
					<maven.compiler.source>1.6</maven.compiler.source>
					<maven.compiler.target>1.6</maven.compiler.target>
				</properties>
				<modules>
					«FOR p : config.enabledProjects.filter[it != this]»
						<module>«IF config.projectLayout == ProjectLayout.FLAT»../«ENDIF»«p.name»</module>
					«ENDFOR»
				</modules>
				<build>
					«IF config.buildSystem == BuildSystem.TYCHO»
						<plugins>
							<plugin>
								<groupId>org.eclipse.tycho</groupId>
								<artifactId>tycho-maven-plugin</artifactId>
								<version>${tycho-version}</version>
								<extensions>true</extensions>
							</plugin>
							<plugin>
								<groupId>org.eclipse.tycho</groupId>
								<artifactId>target-platform-configuration</artifactId>
								<version>${tycho-version}</version>
								<configuration>
									<target>
										<artifact>
											<groupId>«config.baseName»</groupId>
											<artifactId>«config.targetPlatformProject.name»</artifactId>
											<version>${project.version}</version>
										</artifact>
									</target>
									<environments>
										<environment>
											<os>macosx</os>
											<ws>cocoa</ws>
											<arch>x86_64</arch>
										</environment>
										<environment>
											<os>win32</os>
											<ws>win32</ws>
											<arch>x86_64</arch>
										</environment>
										<environment>
											<os>linux</os>
											<ws>gtk</ws>
											<arch>x86_64</arch>
										</environment>
									</environments>
								</configuration>
							</plugin>
						</plugins>
					«ENDIF»
					<pluginManagement>
						<plugins>
							<plugin>
								<groupId>org.eclipse.xtend</groupId>
								<artifactId>xtend-maven-plugin</artifactId>
								<version>${xtextVersion}</version>
								<executions>
									<execution>
										<phase>generate-sources</phase>
										<goals>
											<goal>compile</goal>
										</goals>
									</execution>
								</executions>
								<configuration>
									<outputDirectory>${basedir}/«Outlet.MAIN_XTEND_GEN.sourceFolder»</outputDirectory>
								</configuration>
							</plugin>
							<plugin>
								<groupId>org.apache.maven.plugins</groupId>
								<artifactId>maven-clean-plugin</artifactId>
								<version>2.5</version>
								<configuration>
									<filesets>
										<fileset>
											<directory>${basedir}/«Outlet.MAIN_XTEND_GEN.sourceFolder»</directory>
										</fileset>
									</filesets>
								</configuration>
							</plugin>
						</plugins>
					</pluginManagement>
				</build>
				«IF config.xtextVersion.isSnapshot»
					<repositories>
						<repository>
							<id>sonatype-snapshots</id>
							<url>https://oss.sonatype.org/content/repositories/snapshots</url>
							<releases><enabled>false</enabled></releases>
							<snapshots><enabled>true</enabled></snapshots>
						</repository>
					</repositories>
				«ENDIF»
			'''
		]
	}
	
	override getSourceFolders() {
		#{}
	}
	
}