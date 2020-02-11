/*******************************************************************************
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import com.google.common.base.Strings
import java.net.URL
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.JavaVersion
import java.util.Arrays

@FinalFieldsConstructor
@Accessors
abstract class ProjectDescriptor {
	val WizardConfiguration config
	boolean enabled

	def getName() {
		config.baseName + nameQualifier
	}

	def String getNameQualifier()

	def String getLocation() {
		if (config.projectLayout == ProjectLayout.FLAT) {
			config.rootLocation + "/" + name
		} else {
			config.parentProject.location + "/" + name
		}
	}

	def Set<? extends ProjectDescriptor> getUpstreamProjects() {
		emptySet
	}

	/**
	 * @since 2.15 (changed return value use 'path' of 'SourceFolderDescriptor' to get same result as before)
	 */
	def Set<SourceFolderDescriptor> getSourceFolders() {
		#[Outlet.MAIN_JAVA, Outlet.MAIN_RESOURCES, Outlet.MAIN_SRC_GEN, Outlet.MAIN_XTEND_GEN].map [
			new SourceFolderDescriptor(sourceFolder, isTest)
		].toSet
	}

	def Iterable<? extends AbstractFile> getFiles() {
		val List<TextFile> files = newArrayList
		if (eclipsePluginProject) {
			files += file(Outlet.META_INF, "MANIFEST.MF", manifest)
			files += file(Outlet.ROOT, "build.properties", buildProperties)
		}
		if (eclipseFeatureProject) {
			files += file(Outlet.ROOT, "build.properties", buildProperties)
		}
		if (config.needsGradleBuild && isPartOfGradleBuild) {
			files += buildGradle
		}
		if (config.needsMavenBuild && isPartOfMavenBuild) {
			files += pom
		}
		return files
	}

	def boolean isPartOfGradleBuild()

	def boolean isPartOfMavenBuild()

	def boolean isEclipsePluginProject()

	def boolean isEclipseFeatureProject() {
		false
	}

	def CharSequence buildProperties() '''
		«buildPropertiesEntry("source..", sourceFolders.map[it.path + "/"])»
		«buildPropertiesEntry("bin.includes", binIncludes)»
		«buildPropertiesEntry("bin.excludes", binExcludes)»
		«buildPropertiesEntry("additional.bundles", developmentBundles)»
	'''

	def Set<String> getBinIncludes() {
		newLinkedHashSet(".", '''«Outlet.META_INF.sourceFolder»/''')
	}

	/**
	 * @since 2.11
	 */
	def Set<String> getBinExcludes() {
		newLinkedHashSet("**/*.xtend")
	}

	def Set<String> getDevelopmentBundles() {
		emptySet
	}

	private def buildPropertiesEntry(String key, Iterable<String> value) {
		if (value.isEmpty)
			return ""
		val assignment = key + " = "
		val indent = Strings.repeat(" ", assignment.length)
		assignment + value.join(",\\\n" + indent)
	}

	def String manifest() '''
		Manifest-Version: 1.0
		Bundle-ManifestVersion: 2
		Bundle-Name: «name»
		Bundle-Vendor: My Company
		Bundle-Version: 1.0.0.qualifier
		Bundle-SymbolicName: «name»; singleton:=true
		«IF activatorClassName !== null»
			Bundle-Activator: «activatorClassName»
		«ENDIF»
		Bundle-ActivationPolicy: lazy
		«manifestEntry("Require-Bundle", requiredBundles)»
		«manifestEntry("Import-Package", importedPackages)»
		Bundle-RequiredExecutionEnvironment: «bree»
		Automatic-Module-Name: «name»
	'''

	def getBree() {
		return config.javaVersion.bree
	}

	private def manifestEntry(String key, Iterable<String> value) {
		if (value.isEmpty)
			return ""
		return '''«key»: «value.join(",\n ")»'''
	}

	def Set<String> getRequiredBundles() {
		val bundles = newLinkedHashSet
		bundles += upstreamProjects.map[name]
		bundles += externalDependencies.map[p2].filter[bundleId !== null].map [
			bundleId + if(version === null) "" else ';bundle-version="' + version + '"'
		]
		bundles
	}

	def Set<String> getImportedPackages() {
		externalDependencies.map[p2.packages].flatten.toSet
	}

	def Set<ExternalDependency> getExternalDependencies() {
		val deps = newLinkedHashSet()
		for (ePackage : config.ecore2Xtext.EPackageInfos) {
			deps += ExternalDependency.createBundleDependency(ePackage.bundleID)
		}
		return deps
	}

	def getActivatorClassName() {
		null
	}

	protected def isAtLeastJava9() {
		config.javaVersion.isAtLeast(JavaVersion.JAVA9)
	}

	def GradleBuildFile buildGradle() {
		new GradleBuildFile(this)
	}

	def PomFile pom() {
		new PomFile(this)
	}

	def sourceFolder(Outlet outlet) {
		config.sourceLayout.getPathFor(outlet);
	}

	def isTest(Outlet outlet) {
		return Arrays.asList(Outlet.testOutlets).contains(outlet)
	}

	protected def file(Outlet outlet, String relativePath, CharSequence content) {
		new PlainTextFile(outlet, relativePath, this, content)
	}

	protected def file(Outlet outlet, String relativePath, CharSequence content, boolean executable) {
		new PlainTextFile(outlet, relativePath, this, content, executable)
	}

	protected def binaryFile(Outlet outlet, String relativePath, URL url) {
		return new BinaryFile(outlet, relativePath, this, false, url)
	}

	protected def isFromExistingEcoreModels() {
		!config.ecore2Xtext.EPackageInfos.isEmpty
	}
}
