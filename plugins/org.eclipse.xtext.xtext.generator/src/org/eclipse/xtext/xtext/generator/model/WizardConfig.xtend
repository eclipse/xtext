/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import com.google.inject.Injector
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.emf.mwe2.runtime.Mandatory
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.XtextGenerator

@Accessors
class WizardConfig extends XtextProjectConfig {
	
	String runtimeBase
	
	boolean eclipseEditor = true
	
	boolean ideaEditor = false
	
	boolean orionEditor = false
	
	boolean genericIdeSupport = false
	
	boolean testingSupport = false
	
	boolean mavenLayout = false
	
	@Mandatory
	def void setRuntimeBase(String runtimeBase) {
		this.runtimeBase = runtimeBase
	}
	
	override checkConfiguration(XtextGenerator generator, Issues issues) {
		super.checkConfiguration(generator, issues)
		if (runtimeBase.nullOrEmpty)
			issues.addError(generator, 'The property \'runtimeBase\' must be set.', this)
		if (!Character.isJavaIdentifierPart(runtimeBase.charAt(runtimeBase.length - 1)))
			issues.addError(generator, 'The runtime base path must end with a valid package name.', this)
		if ((ideaEditor || orionEditor) && !genericIdeSupport)
			issues.addError(generator, 'Generic IDE support must be enabled when the IDEA or Orion editors are enabled.', this)
	}
	
	override initialize(Injector injector) {
		var src = 'src'
		var srcGen = 'src-gen'
		var srcWeb = 'web'
		if (mavenLayout) {
			src = 'src/main/java'
			srcGen = 'src/main/xtext-gen'
			srcWeb = 'src/main/webapp'
		}
		
		if (runtimeSrc === null)
			runtimeSrc = runtimeBase + '/' + src
		if (runtimeSrcGen === null)
			runtimeSrcGen = runtimeBase + '/' + srcGen
		if (runtimeManifest === null)
			runtimeManifest = new ManifestAccess => [path = runtimeBase + '/META-INF/MANIFEST.MF']
		if (runtimePluginXml === null)
			runtimePluginXml = new PluginXmlAccess => [path = runtimeBase + '/plugin.xml']
		
		if (eclipseEditor) {
			if (eclipsePluginSrc === null)
				eclipsePluginSrc = runtimeBase + '.ui/' + src
			if (eclipsePluginSrcGen === null)
				eclipsePluginSrcGen = runtimeBase + '.ui/' + srcGen
			if (eclipsePluginManifest === null)
				eclipsePluginManifest = new ManifestAccess => [path = runtimeBase + '.ui/META-INF/MANIFEST.MF']
			if (eclipsePluginPluginXml === null)
				eclipsePluginPluginXml = new PluginXmlAccess => [path = runtimeBase + '.ui/plugin.xml']
		}
		
		if (ideaEditor) {
			if (ideaPluginSrc === null)
				ideaPluginSrc = runtimeBase + '.idea/' + src
			if (ideaPluginSrcGen === null)
				ideaPluginSrcGen = runtimeBase + '.idea/' + srcGen
		}
		
		if (orionEditor) {
			if (webSrc === null)
				webSrc = runtimeBase + '.web/' + src
			if (webSrcGen === null)
				webSrcGen = runtimeBase + '.web/' + srcGen
			if (orionJsGen === null)
				orionJsGen = runtimeBase + '.web/' + srcWeb + '/xtext/generated'
		}
		
		if (genericIdeSupport) {
			if (genericIdeSrc === null)
				genericIdeSrc = runtimeBase + '.ide/' + src
			if (genericIdeSrcGen === null)
				genericIdeSrcGen = runtimeBase + '.ide/' + srcGen
			if (genericIdeManifest === null)
				genericIdeManifest = new ManifestAccess => [path = runtimeBase + '.ide/META-INF/MANIFEST.MF']
		}
		
		if (testingSupport) {
			if (runtimeTestSrc === null)
				runtimeTestSrc = runtimeBase + '.tests/' + src
			if (runtimeTestSrcGen === null)
				runtimeTestSrcGen = runtimeBase + '.tests/' + srcGen
			if (runtimeTestManifest === null)
				runtimeTestManifest = new ManifestAccess => [path = runtimeBase + '.tests/META-INF/MANIFEST.MF']
			if (eclipsePluginTestSrc === null)
				eclipsePluginTestSrc = runtimeBase + '.tests/' + src
			if (eclipsePluginTestSrcGen === null)
				eclipsePluginTestSrcGen = runtimeBase + '.tests/' + srcGen
			if (eclipsePluginTestManifest === null)
				eclipsePluginTestManifest = new ManifestAccess => [path = runtimeBase + '.tests/META-INF/MANIFEST.MF']
		}
		
		super.initialize(injector)
	}
	
}