/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@FinalFieldsConstructor
class SdkFeatureProject extends ProjectDescriptor {

	override getNameQualifier() {
		".sdk"
	}
	
	override isEclipsePluginProject() {
		false
	}
	
	override isEclipseFeatureProject() {
		true
	}
	
	override isPartOfGradleBuild() {
		false
	}
	
	override isPartOfMavenBuild() {
		true
	}
	
	override isEnabled() {
		super.enabled && config.runtimeProject.isEclipsePluginProject
	}
	
	override getFiles() {
		val files = newArrayList
		files += super.files
		files += file(Outlet.ROOT, "feature.xml", featureXml)
		files
	}
	
	override getSourceFolders() {
		#{}
	}
	
	override getBinIncludes() {
		#{"feature.xml"}
	}

	def featureXml() '''
		<?xml version="1.0" encoding="UTF-8"?>
		<feature id="«name»"
			label="«config.language.simpleName» SDK Feature "
			version="1.0.0.qualifier">
			«includedPlugin("")»
			«IF config.ideProject.enabled»
			«includedPlugin(config.ideProject.nameQualifier)»
			«ENDIF»
			«IF config.uiProject.enabled»
			«includedPlugin(config.uiProject.nameQualifier)»
			«ENDIF»
		</feature>
	'''

	def includedPlugin(String qualifier) '''
		<plugin
				id="«config.baseName + qualifier»"
				download-size="0"
				install-size="0"
				version="0.0.0"
				unpack="false"/>
	'''

	override buildGradle() {
		throw new UnsupportedOperationException("Eclipse features are not yet supported in Gradle")
	}

	override pom() {
		super.pom => [
			packaging = "eclipse-feature"
		]
	}

}