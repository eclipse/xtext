/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Injector
import org.eclipse.emf.mwe2.runtime.Mandatory
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.model.ManifestAccess
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess

@Accessors
class WizardConfig extends XtextProjectConfig {
	
	boolean eclipseEditor = true
	
	boolean ideaEditor = false
	
	boolean webSupport = false
	
	boolean genericIdeSupport = false
	
	boolean testingSupport = false
	
	boolean mavenLayout = false
	
	@Mandatory
	override setRuntimeRoot(String path) {
		super.setRuntimeRoot(path)
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		val runtimeBase = runtimeRoot?.path
		if (runtimeBase.nullOrEmpty) {
			issues.addError('The property \'runtimeRoot\' must be set.', this)
			return
		}
		if (!Character.isJavaIdentifierPart(runtimeBase.charAt(runtimeBase.length - 1)))
			issues.addError('The runtime root path must end with a valid package name.', this)
		if ((ideaEditor || webSupport) && !genericIdeSupport)
			issues.addError('Generic IDE support must be enabled when the IDEA or web editors are enabled.', this)
	}
	
	override initialize(Injector injector) {
		var src = 'src'
		var srcGen = 'src-gen'
		var srcWeb = 'WebRoot'
		var metaInf = 'META-INF'
		if (mavenLayout) {
			src = 'src/main/java'
			metaInf = 'src/main/resources/META-INF'
			srcGen = 'src/main/xtext-gen'
			srcWeb = 'src/main/webapp'
		}
		
		if (runtimeMetaInf === null)
			runtimeMetaInf = runtimeRoot.path + '/' + metaInf
		if (runtimeSrc === null)
			runtimeSrc = runtimeRoot.path  + '/' + src
		if (runtimeSrcGen === null)
			runtimeSrcGen = runtimeRoot.path  + '/' + srcGen
		if (runtimeManifest === null)
			runtimeManifest = new ManifestAccess
		if (runtimePluginXml === null)
			runtimePluginXml = new PluginXmlAccess
			
		if (testingSupport) {
			if (runtimeTestRoot === null)
				runtimeTestRoot = runtimeRoot.path + ".tests"
			if (runtimeTestMetaInf == null)
				runtimeTestMetaInf = runtimeTestRoot.path + '/' + metaInf
			if (runtimeTestSrc === null)
				runtimeTestSrc = runtimeTestRoot.path + '/' + src
			if (runtimeTestSrcGen === null)
				runtimeTestSrcGen = runtimeTestRoot.path + '/' + srcGen
			if (runtimeTestManifest === null)
				runtimeTestManifest = new ManifestAccess
		}
		
		if (eclipseEditor) {
			if (eclipsePluginRoot === null)
				eclipsePluginRoot = runtimeRoot.path + '.ui'
			if (eclipsePluginMetaInf === null)
				eclipsePluginMetaInf = eclipsePluginRoot.path + '/' + metaInf
			if (eclipsePluginSrc === null)
				eclipsePluginSrc = eclipsePluginRoot.path + '/' + src
			if (eclipsePluginSrcGen === null)
				eclipsePluginSrcGen = eclipsePluginRoot.path + '/' + srcGen
			if (eclipsePluginManifest === null)
				eclipsePluginManifest = new ManifestAccess
			if (eclipsePluginPluginXml === null)
				eclipsePluginPluginXml = new PluginXmlAccess
				
			if (testingSupport) {
				if (eclipsePluginTestRoot === null)
					eclipsePluginTestRoot = runtimeRoot.path + '.tests'
				if (eclipsePluginTestMetaInf === null)
					eclipsePluginTestMetaInf = eclipsePluginTestRoot.path + '/' + metaInf
				if (eclipsePluginTestSrc === null)
					eclipsePluginTestSrc = eclipsePluginTestRoot.path + '/' + src
				if (eclipsePluginTestSrcGen === null)
					eclipsePluginTestSrcGen = eclipsePluginTestRoot.path + '/' + srcGen
				if (eclipsePluginTestManifest === null)
					eclipsePluginTestManifest = new ManifestAccess
			}
		}
		
		if (ideaEditor) {
			if (ideaPluginRoot === null)
				ideaPluginRoot = runtimeRoot.path + '.idea'
			if (ideaPluginSrc === null)
				ideaPluginSrc = ideaPluginRoot.path + '/' + src
			if (ideaPluginSrcGen === null)
				ideaPluginSrcGen = ideaPluginRoot.path  + '/' + srcGen
			if (ideaPluginMetaInf === null)
				ideaPluginMetaInf = ideaPluginRoot.path  + '/' + metaInf
		}
		
		if (webSupport) {
			if (webRoot === null)
				webRoot = runtimeRoot.path + '.web'
			if (webSrc === null)
				webSrc = webRoot.path + '/' + src
			if (webSrcGen === null)
				webSrcGen = webRoot.path + '/' + srcGen
			if (webApp === null)
				webApp = webRoot.path + '/' + srcWeb
		}
		
		if (genericIdeSupport) {
			if (genericIdeRoot === null)
				genericIdeRoot = runtimeRoot.path + '.ide'
			if (genericIdeMetaInf === null)
				genericIdeMetaInf = genericIdeRoot.path + '/' + metaInf
			if (genericIdeSrc === null)
				genericIdeSrc = genericIdeRoot.path + '/' + src
			if (genericIdeSrcGen === null)
				genericIdeSrcGen = genericIdeRoot.path + '/' + srcGen
			if (genericIdeManifest === null)
				genericIdeManifest = new ManifestAccess
		}
		
		super.initialize(injector)
	}
	
}