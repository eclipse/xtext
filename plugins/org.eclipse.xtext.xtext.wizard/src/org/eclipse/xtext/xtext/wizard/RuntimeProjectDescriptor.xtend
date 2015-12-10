/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtext.xtext.wizard.ecore2xtext.Ecore2XtextGrammarCreator

import static org.eclipse.xtext.xtext.wizard.ExternalDependency.*

class RuntimeProjectDescriptor extends TestedProjectDescriptor {

	val grammarCreator = new Ecore2XtextGrammarCreator
	val RuntimeTestProjectDescriptor testProject
	
	new(WizardConfiguration config) {
		super(config)
		enabled = true
		testProject = new RuntimeTestProjectDescriptor(this)
	}
	
	override setEnabled(boolean enabled) {
		if (!enabled)
			throw new IllegalArgumentException("The runtime project is always enabled")
		super.enabled = enabled
	}
	
	String nameQualifier = ''
	
	
	override getNameQualifier() {
		nameQualifier
	}
	
	def void setNameQualifier(String nameQualifier) {
		this.nameQualifier = nameQualifier
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
	
	override getTestProject() {
		testProject
	}
	
	override getExternalDependencies() {
		val deps = newLinkedHashSet
		deps += super.externalDependencies
		deps += createXtextDependency("org.eclipse.xtext")
		deps += createXtextDependency("org.eclipse.xtext.xbase")
		deps += new ExternalDependency => [
			p2 [
				bundleId = "org.eclipse.equinox.common"
				version = "3.5.0"
			]
		]
		for (ePackage: config.ecore2Xtext.EPackageInfos) {
			deps += createBundleDependency(ePackage.bundleID)
			if (ePackage.genmodelURI.fileExtension == "xcore") {
				deps += createBundleDependency("org.eclipse.emf.ecore.xcore")
			}
		}
		if (!isEclipsePluginProject && config.needsMavenBuild) {
			deps += createXtextDependency("org.eclipse.xtext.xtext") => [maven.optional = true]
			deps += createXtextDependency("org.eclipse.xtext.xtext.generator")  => [maven.optional = true]
		}
		deps
	}
	
	override getDevelopmentBundles() {
		newLinkedHashSet(
			"org.eclipse.xtext.xbase", 
			"org.eclipse.xtext.common.types", 
			"org.eclipse.xtext.xtext.generator",
			"org.eclipse.emf.codegen.ecore", 
			"org.eclipse.emf.mwe.utils",
			"org.eclipse.emf.mwe2.launch",
			"org.eclipse.emf.mwe2.lib",
			"org.objectweb.asm",
			"org.apache.commons.logging", 
			"org.apache.log4j",
			"com.ibm.icu"
		)
	}
	
	override getBinIncludes() {
		val includes = newLinkedHashSet
		includes += super.binIncludes
		includes += "plugin.xml"
		includes
	}

	override getFiles() {
		val files = newArrayList
		files += super.files
		files += grammarFile
		files += file(Outlet.MAIN_JAVA, workflowFilePath, workflow)
		if (isPlainMavenBuild) {
			files += file(Outlet.ROOT, "jar-with-ecore-model.xml", jarDescriptor)
		}
		return files
	}
	
	private def isPlainMavenBuild() {
		config.needsMavenBuild && !isEclipsePluginProject
	}

	def getGrammarFile() {
		file(Outlet.MAIN_JAVA, grammarFilePath, grammar)
	}
	
	def String getGrammarFilePath() {
		return '''«config.language.basePackagePath»/«config.language.simpleName».xtext'''
	}
	

	def grammar() {
		if (fromExistingEcoreModels)
			grammarCreator.grammar(config)
		else
			defaultGrammar
	}
	
	private def defaultGrammar() '''
		grammar «config.language.name» with org.eclipse.xtext.common.Terminals
		
		generate «config.language.simpleName.toFirstLower» "«config.language.nsURI»"
		
		Model:
			greetings+=Greeting*;
			
		Greeting:
			'Hello' name=ID '!';
	'''
	
	def String getWorkflowFilePath() {
		'''«config.language.basePackagePath»/Generate«config.language.simpleName».mwe2'''
	}
	
	def workflow() {
		''' 
			module «(config.language.basePackagePath+"/Generate"+config.language.simpleName).replaceAll("/", ".")»
			
			import org.eclipse.xtext.xtext.generator.*
			import org.eclipse.xtext.xtext.generator.model.project.*
			
			var rootPath = ".."
			
			Workflow {
				
				component = XtextGenerator {
					configuration = {
						project = StandardProjectConfig {
							baseName = "«name»"
							rootPath = rootPath
							«IF testProject.enabled»
								runtimeTest = {
									enabled = true
								}
							«ENDIF»
							«IF config.ideProject.enabled 
								&& !#[config.webProject, config.intellijProject, config.uiProject].exists[enabled]»
								genericIde = {
									enabled = true
								}
							«ENDIF»
							«IF config.uiProject.enabled»
								eclipsePlugin = {
									enabled = true
								}
							«ENDIF»
							«IF config.uiProject.testProject.enabled»
								eclipsePluginTest = {
									enabled = true
								}
							«ENDIF»
							«IF config.intellijProject.enabled»
								ideaPlugin = {
									enabled = true
								}
							«ENDIF»
							«IF config.webProject.enabled»
								web = {
									enabled = true
								}
							«ENDIF»
							«IF config.sourceLayout == SourceLayout.MAVEN»
								mavenLayout = true
							«ENDIF»
							«IF isEclipsePluginProject»
								createEclipseMetaData = true
							«ENDIF»
						}
						code = {
							encoding = "«config.encoding»"
							fileHeader = "/*\n * generated by Xtext \${version}\n */"
						}
					}
					language = StandardLanguage {
						name = "«config.language.name»"
						fileExtensions = "«config.language.fileExtensions»"
						«IF !config.ecore2Xtext.EPackageInfos.empty»
							
							standaloneSetup = {
								«FOR genmodelURI : config.ecore2Xtext.EPackageInfos.map[genmodelURI.toString].toSet»
									loadedResource = "«genmodelURI»"
								«ENDFOR»
							}
						«ENDIF»
						«IF fromExistingEcoreModels»
							
							fragment = ecore2xtext.Ecore2XtextValueConverterServiceFragment2 auto-inject {}

							fragment = adapter.FragmentAdapter {
								fragment = ecore2xtext.FormatterFragment {}
							}
						«ENDIF»

						serializer = {
							generateStub = false
						}
						validator = {
							// composedCheck = "org.eclipse.xtext.validation.NamesAreUniqueValidator"
						}
					}
				}
			}
		'''
	}
	
	private def isFromExistingEcoreModels() {
		!config.ecore2Xtext.EPackageInfos.isEmpty
	}
	
	override buildGradle() {
		super.buildGradle => [
			additionalContent = '''
				configurations {
					mwe2 {
						extendsFrom compile
					}
				}

				dependencies {
					mwe2 "org.eclipse.emf:org.eclipse.emf.mwe2.launch:«config.xtextVersion.mweVersion»"
					mwe2 "org.eclipse.xtext:org.eclipse.xtext.xtext.generator:${xtextVersion}"
				}
				
				task generateXtextLanguage(type: JavaExec) {
					main = 'org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher'
					classpath = configurations.mwe2
					inputs.file "«Outlet.MAIN_JAVA.sourceFolder»/«workflowFilePath»"
					inputs.file "«Outlet.MAIN_JAVA.sourceFolder»/«grammarFilePath»"
					outputs.dir "«Outlet.MAIN_SRC_GEN.sourceFolder»"
					args += "«Outlet.MAIN_JAVA.sourceFolder»/«workflowFilePath»"
					args += "-p"
					args += "rootPath=/${projectDir}/.."
				}
				
				compileXtend.dependsOn(generateXtextLanguage)
				clean.dependsOn(cleanGenerateXtextLanguage)
				eclipse.classpath.plusConfigurations += [configurations.mwe2]
			'''
		]
	}
		
	override pom() {
		super.pom => [
			packaging = if (isEclipsePluginProject) "eclipse-plugin" else "jar"
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
									<exclude>**/*.xtext</exclude>
									<exclude>**/*.mwe2</exclude>
								</excludes>
							</resource>
						</resources>
					«ENDIF»
					<plugins>
						<plugin>
							<groupId>org.codehaus.mojo</groupId>
							<artifactId>exec-maven-plugin</artifactId>
							<version>1.4.0</version>
							<executions>
								<execution>
									<id>mwe2Launcher</id>
									<phase>generate-sources</phase>
									<goals>
										<goal>java</goal>
									</goals>
								</execution>
							</executions>
							<configuration>
								<mainClass>org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher</mainClass>
								<arguments>
									<argument>/${project.basedir}/«Outlet.MAIN_JAVA.sourceFolder»/«workflowFilePath»</argument>
									<argument>-p</argument>
									<argument>rootPath=/${project.basedir}/..</argument>
								</arguments>
								<classpathScope>compile</classpathScope>
								<includePluginDependencies>true</includePluginDependencies>
								<cleanupDaemonThreads>false</cleanupDaemonThreads><!-- see https://bugs.eclipse.org/bugs/show_bug.cgi?id=475098#c3 -->
							</configuration>
							«IF config.needsTychoBuild»
								<dependencies>
									<dependency>
										<groupId>org.eclipse.emf</groupId>
										<artifactId>org.eclipse.emf.mwe2.launch</artifactId>
										<version>«config.xtextVersion.mweVersion»</version>
									</dependency>
									<dependency>
										<groupId>org.eclipse.xtext</groupId>
										<artifactId>org.eclipse.xtext.xtext.generator</artifactId>
										<version>${xtextVersion}</version>
									</dependency>
									<dependency>
										<groupId>org.eclipse.xtext</groupId>
										<artifactId>org.eclipse.xtext.xbase</artifactId>
										<version>${xtextVersion}</version>
									</dependency>
								</dependencies>
							«ENDIF»
						</plugin>
						<plugin>
							<groupId>org.eclipse.xtend</groupId>
							<artifactId>xtend-maven-plugin</artifactId>
						</plugin>

						<plugin>
							<groupId>org.apache.maven.plugins</groupId>
							<artifactId>maven-clean-plugin</artifactId>
							<configuration>
								<filesets combine.children="append">
									«FOR p : #[this, config.ideProject, config.uiProject, config.webProject]»
										«IF p.enabled»
											<fileset>
												<directory>${basedir}/../«p.name»/«Outlet.MAIN_SRC_GEN.sourceFolder»/</directory>
												<includes>
													<include>**/*</include>
												</includes>
											</fileset>
											«IF p instanceof TestedProjectDescriptor»
												«IF p.testProject.enabled»
													<fileset>
														<directory>${basedir}/../«if(p.testProject.isInlined) p.name else p.testProject.name»/«Outlet.TEST_SRC_GEN.sourceFolder»/</directory>
														<includes>
															<include>**/*</include>
														</includes>
													</fileset>
												«ENDIF»
											«ENDIF»
										«ENDIF»
									«ENDFOR»
									<fileset>
										<directory>${basedir}/model/generated/</directory>
									</fileset>
								</filesets>
							</configuration>
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
									«IF testProject.isInlined»
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
									«ENDIF»	
								</executions>
							</plugin>
							«IF isPlainMavenBuild»
								<plugin>
									<artifactId>maven-assembly-plugin</artifactId>
									<version>2.5.5</version>
									<configuration>
										<descriptors>
											<descriptor>jar-with-ecore-model.xml</descriptor>
										</descriptors>
										<appendAssemblyId>false</appendAssemblyId>
									</configuration>
									<executions>
										<execution>
											<id>make-assembly</id>
											<phase>package</phase>
											<goals>
												<goal>single</goal>
											</goals>
										</execution>
									</executions>
								</plugin>
							«ENDIF»
						«ENDIF»
					</plugins>
					<pluginManagement>
						<plugins>
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
														exec-maven-plugin
													</artifactId>
													<versionRange>
														[1.2.1,)
													</versionRange>
													<goals>
														<goal>java</goal>
													</goals>
												</pluginExecutionFilter>
												<action>
													<ignore></ignore>
												</action>
											</pluginExecution>
										</pluginExecutions>
									</lifecycleMappingMetadata>
								</configuration>
							</plugin>
						</plugins>
					</pluginManagement>
				</build>
			'''
		]
	}
	
	def jarDescriptor() '''
		<assembly xmlns="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.3" 
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.3 http://maven.apache.org/xsd/assembly-1.1.3.xsd">
			<id>jar-with-ecore-model</id>
			<formats>
				<format>jar</format>
			</formats>
			<includeBaseDirectory>false</includeBaseDirectory>
			<fileSets>
				<fileSet>
					<outputDirectory>/</outputDirectory>
					<directory>target/classes</directory>
				</fileSet>
				<fileSet>
					<outputDirectory>model/generated</outputDirectory>
					<directory>model/generated</directory>
				</fileSet>
			</fileSets>
		</assembly>
	'''
}