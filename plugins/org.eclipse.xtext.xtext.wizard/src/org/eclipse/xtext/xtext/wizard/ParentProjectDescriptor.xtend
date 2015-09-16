package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class ParentProjectDescriptor extends ProjectDescriptor {

	override getNameQualifier() {
		".parent"
	}
	
	override isEnabled() {
		config.needsGradleBuild || config.needsMavenBuild
	}
	
	override setEnabled(boolean enabled) {
		throw new UnsupportedOperationException("The parent project is automatically enabled depending on the build system")
	}

	override getLocation() {
		config.rootLocation + "/" + name
	}

	override isEclipsePluginProject() {
		false
	}
	
	override isPartOfGradleBuild() {
		true
	}
	
	override isPartOfMavenBuild() {
		true
	}

	override getFiles() {
		val files = newArrayList
		files += super.files
		if (config.needsGradleBuild) {
			files += file(Outlet.ROOT, 'settings.gradle', settingsGradle)
			files += file(Outlet.ROOT, 'gradle/source-layout.gradle', sourceLayoutGradle)
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
					apply from: "${rootDir}/gradle/source-layout.gradle"
				}
			'''
		]
	}

	def settingsGradle() '''
		«FOR p : config.enabledProjects.filter[it != this && partOfGradleBuild]»
			«IF config.projectLayout == ProjectLayout.FLAT»includeFlat«ELSE»include«ENDIF» '«p.name»'
		«ENDFOR»
	'''
	
	def sourceLayoutGradle() '''
		if (name.endsWith(".tests")) {
			sourceSets.test.java.srcDirs = ['«Outlet.TEST_JAVA.sourceFolder»', '«Outlet.TEST_SRC_GEN.sourceFolder»']
			sourceSets.test.resources.srcDirs = ['«Outlet.TEST_RESOURCES.sourceFolder»', '«Outlet.TEST_SRC_GEN.sourceFolder»']
			sourceSets.test.xtendOutputDir = '«Outlet.TEST_XTEND_GEN.sourceFolder»'
			sourceSets.main.java.srcDirs = []
			sourceSets.main.resources.srcDirs = []
		} else {
			sourceSets.main.java.srcDirs = ['«Outlet.MAIN_JAVA.sourceFolder»', '«Outlet.MAIN_SRC_GEN.sourceFolder»']
			sourceSets.main.resources.srcDirs = ['«Outlet.MAIN_RESOURCES.sourceFolder»', '«Outlet.MAIN_SRC_GEN.sourceFolder»']
			sourceSets.main.xtendOutputDir = '«Outlet.MAIN_XTEND_GEN.sourceFolder»'
			sourceSets.test.java.srcDirs = []
			sourceSets.test.resources.srcDirs = []
		}
		plugins.withId('war') {
			webAppDirName = "«Outlet.WEBAPP.sourceFolder»"
		}
	'''

	override pom() {
		super.pom => [
			packaging = "pom"
			buildSection = '''
				<properties>
					«IF config.needsTychoBuild»
						<tycho-version>0.23.1</tycho-version>
					«ENDIF»
					<xtextVersion>«config.xtextVersion»</xtextVersion>
					<project.build.sourceEncoding>«config.encoding»</project.build.sourceEncoding>
					<maven.compiler.source>1.6</maven.compiler.source>
					<maven.compiler.target>1.6</maven.compiler.target>
				</properties>
				<modules>
					«FOR p : config.enabledProjects.filter[it != this && partOfMavenBuild]»
						<module>«IF config.projectLayout == ProjectLayout.FLAT»../«ENDIF»«p.name»</module>
					«ENDFOR»
				</modules>
				<build>
					«IF config.needsTychoBuild»
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
											<goal>testCompile</goal>
										</goals>
									</execution>
								</executions>
								<configuration>
									<outputDirectory>${basedir}/«Outlet.MAIN_XTEND_GEN.sourceFolder»</outputDirectory>
									<testOutputDirectory>${basedir}/«Outlet.TEST_XTEND_GEN.sourceFolder»</testOutputDirectory>
								</configuration>
							</plugin>
							<plugin>
								<groupId>org.apache.maven.plugins</groupId>
								<artifactId>maven-clean-plugin</artifactId>
								<version>2.5</version>
								<configuration>
									<filesets>
										<fileset>
											«FOR dir : #[Outlet.MAIN_XTEND_GEN, Outlet.TEST_XTEND_GEN].toSet.map[sourceFolder]»
												<directory>${basedir}/«dir»</directory>
											«ENDFOR»
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