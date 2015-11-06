/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import com.google.common.base.Charsets
import com.google.common.io.Resources
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class ParentProjectDescriptor extends ProjectDescriptor {
	String nameQualifier = '.parent'
	
	override getNameQualifier() {
		nameQualifier
	}
	
	def void setNameQualifier(String nameQualifier) {
		this.nameQualifier = nameQualifier
	}
	
	override isEnabled() {
		config.needsGradleBuild || config.needsMavenBuild || config.projectLayout == ProjectLayout.HIERARCHICAL
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
			files += file(Outlet.ROOT, 'gradle/maven-deployment.gradle', mavenDeploymentGradle)
			if(config.needsGradleWrapper) {
				files += file(Outlet.ROOT, 'gradlew', loadResource("gradlew/gradlew"), true)
				files += file(Outlet.ROOT, 'gradlew.bat', loadResource("gradlew/gradlew.bat"))
				files += file(Outlet.ROOT, 'gradle/wrapper/gradle-wrapper.properties', loadResource("gradlew/gradle-wrapper.properties"))
				files += binaryFile(Outlet.ROOT, 'gradle/wrapper/gradle-wrapper.jar', class.classLoader.getResource("gradlew/gradle-wrapper.jar"))
			}
		}
		return files
	}
	
	def String getJavaVersion() {
		config.javaVersion.qualifier	
	}
	
	def private CharSequence loadResource(String resourcePath) {
		Resources.toString(class.classLoader.getResource(resourcePath), Charsets.ISO_8859_1)
	}

	override buildGradle() {
		super.buildGradle => [
			additionalContent = '''
				buildscript {
					repositories {
						jcenter()
					}
					dependencies {
						classpath 'org.xtend:xtend-gradle-plugin:«config.xtextVersion.xtendGradlePluginVersion»'
						«IF config.intellijProject.isEnabled»
							classpath 'org.xtext:xtext-idea-gradle-plugin:«config.xtextVersion.xtextGradlePluginVersion»'
						«ENDIF»
					}
				}
				
				subprojects {
					ext.xtextVersion = '«config.xtextVersion»'
					repositories {
						jcenter()
						«IF config.xtextVersion.isSnapshot»
							maven {
								url 'https://oss.sonatype.org/content/repositories/snapshots'
							}
						«ENDIF»
					}
					
					apply plugin: 'java'
					apply plugin: 'org.xtend.xtend'
					apply from: "${rootDir}/gradle/source-layout.gradle"
					apply from: "${rootDir}/gradle/maven-deployment.gradle"
					apply plugin: 'eclipse'
					apply plugin: 'idea'
					
					group = '«config.baseName»'
					version = '1.0.0-SNAPSHOT'
					
					sourceCompatibility = '«javaVersion»'
					targetCompatibility = '«javaVersion»'
					
					configurations.all {
						exclude group: 'asm'
					}
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
		«IF config.sourceLayout == SourceLayout.PLAIN»
			if (name.endsWith(".tests")) {
				sourceSets {
					main {
						java.srcDirs = []
						resources.srcDirs = []
					}
					test {
						java.srcDirs = ['«Outlet.TEST_JAVA.sourceFolder»', '«Outlet.TEST_SRC_GEN.sourceFolder»']
						resources.srcDirs = ['«Outlet.TEST_RESOURCES.sourceFolder»', '«Outlet.TEST_SRC_GEN.sourceFolder»']
						xtendOutputDir = '«Outlet.TEST_XTEND_GEN.sourceFolder»'
					}
				}
			} else {
				sourceSets {
					main {
						java.srcDirs = ['«Outlet.MAIN_JAVA.sourceFolder»', '«Outlet.MAIN_SRC_GEN.sourceFolder»']
						resources.srcDirs = ['«Outlet.MAIN_RESOURCES.sourceFolder»', '«Outlet.MAIN_SRC_GEN.sourceFolder»']
						xtendOutputDir = '«Outlet.MAIN_XTEND_GEN.sourceFolder»'
					}
					test {
						java.srcDirs = []
						resources.srcDirs = []
					}
				}
			}
			
			sourceSets.all {
				resources.exclude '**/*.g', '**/*.xtext', '**/*.mwe2', '**/*.xtend', '**/*._trace'
			}
		«ELSE»
			sourceSets {
				main {
					java.srcDirs = ['«Outlet.MAIN_JAVA.sourceFolder»', '«Outlet.MAIN_SRC_GEN.sourceFolder»']
					resources.srcDirs = ['«Outlet.MAIN_RESOURCES.sourceFolder»', '«Outlet.MAIN_SRC_GEN.sourceFolder»']
					xtendOutputDir = '«Outlet.MAIN_XTEND_GEN.sourceFolder»'
				}
				test {
					java.srcDirs = ['«Outlet.TEST_JAVA.sourceFolder»', '«Outlet.TEST_SRC_GEN.sourceFolder»']
					resources.srcDirs = ['«Outlet.TEST_RESOURCES.sourceFolder»', '«Outlet.TEST_SRC_GEN.sourceFolder»']
					xtendOutputDir = '«Outlet.TEST_XTEND_GEN.sourceFolder»'
				}
			}
		«ENDIF»
		
		jar.manifest {
			attributes 'Bundle-SymbolicName': project.name
		}
		
		plugins.withId('war') {
			webAppDirName = "«Outlet.WEBAPP.sourceFolder»"
		}
		
		plugins.withId('org.xtext.idea-plugin') {
			assembleSandbox.metaInf.from('«Outlet.META_INF.sourceFolder»')
		}
	'''
	
	def mavenDeploymentGradle() '''
		//see https://docs.gradle.org/current/userguide/maven_plugin.html
		apply plugin: 'maven'
		
		uploadArchives {
			repositories {
				mavenDeployer {
					repository(url: "file://${buildDir}/localRepo")
					snapshotRepository(url: "file://${buildDir}/localRepo")
				}
			}
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
					<maven.compiler.source>«javaVersion»</maven.compiler.source>
					<maven.compiler.target>«javaVersion»</maven.compiler.target>
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
												<includes>
													<include>**/*</include>
												</includes>
											«ENDFOR»
										</fileset>
									</filesets>
								</configuration>
							</plugin>
							<plugin>
								<groupId>org.eclipse.m2e</groupId>
								<artifactId>lifecycle-mapping</artifactId>
								<version>1.0.0</version>
								<configuration>
									<lifecycleMappingMetadata>
										<pluginExecutions>
											<pluginExecution>
												<pluginExecutionFilter>
													<groupId>
														org.codehaus.mojo
													</groupId>
													<artifactId>
														build-helper-maven-plugin
													</artifactId>
													<versionRange>
														[1.9.1,)
													</versionRange>
													<goals>
														<goal>add-resource</goal>
														<goal>add-source</goal>
														<goal>add-test-resource</goal>
														<goal>add-test-source</goal>
													</goals>
												</pluginExecutionFilter>
												<action>
													<ignore></ignore>
												</action>
											</pluginExecution>
											«IF config.needsTychoBuild»
												<pluginExecution>
													<pluginExecutionFilter>
														<groupId>
															org.eclipse.tycho
														</groupId>
														<artifactId>
															tycho-compiler-plugin
														</artifactId>
														<versionRange>
															[0.23.1,)
														</versionRange>
														<goals>
															<goal>compile</goal>
														</goals>
													</pluginExecutionFilter>
													<action>
														<ignore></ignore>
													</action>
												</pluginExecution>
												<pluginExecution>
													<pluginExecutionFilter>
														<groupId>
															org.eclipse.tycho
														</groupId>
														<artifactId>
															tycho-packaging-plugin
														</artifactId>
														<versionRange>
															[0.23.1,)
														</versionRange>
														<goals>
															<goal>build-qualifier</goal>
															<goal>validate-id</goal>
															<goal>validate-version</goal>
														</goals>
													</pluginExecutionFilter>
													<action>
														<ignore></ignore>
													</action>
												</pluginExecution>
											«ENDIF»
										</pluginExecutions>
									</lifecycleMappingMetadata>
								</configuration>
							</plugin>
							«IF config.needsTychoBuild»
							<plugin>
								<!-- 
									Can be removed after first generator execution
									https://bugs.eclipse.org/bugs/show_bug.cgi?id=480097
								-->
								<groupId>org.eclipse.tycho</groupId>
								<artifactId>tycho-compiler-plugin</artifactId>
								<version>${tycho-version}</version>
								<configuration>
									<compilerArgument>-err:-forbidden</compilerArgument>
								</configuration>
							</plugin>
							«ENDIF»
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
					<pluginRepositories>
						<pluginRepository>
							<id>sonatype-snapshots</id>
							<url>https://oss.sonatype.org/content/repositories/snapshots</url>
							<releases><enabled>false</enabled></releases>
							<snapshots><enabled>true</enabled></snapshots>
						</pluginRepository>
					</pluginRepositories>
				«ENDIF»
			'''
		]
	}
	
	override getSourceFolders() {
		#{}
	}
	
}