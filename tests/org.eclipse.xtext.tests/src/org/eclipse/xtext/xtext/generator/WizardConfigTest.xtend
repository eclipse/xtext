/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.junit.Test
import org.junit.Before
import com.google.inject.Guice
import com.google.inject.Injector
import org.junit.Assert

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class WizardConfigTest {
	
	var Injector injector
	
	@Before def void createInjector() {
		injector = Guice.createInjector(new DefaultGeneratorModule)
	}
	
	@Test def void testMavenProjectNames() {
		val cfg = new WizardConfig() => [
			baseName = 'com.acme'
			mavenLayout = true
			runtimeTest.enabled = true
			eclipsePlugin.enabled = true
			eclipsePluginTest.enabled = true
		]
		cfg.initialize(injector)
		Assert.assertEquals('com.acme', cfg.runtimeTest.name)
		Assert.assertEquals('com.acme.ui', cfg.eclipsePluginTest.name)
	}
	
	@Test def void testPlainProjectNames() {
		val cfg = new WizardConfig() => [
			baseName = 'com.acme'
			runtimeTest.enabled = true
			eclipsePlugin.enabled = true
			eclipsePluginTest.enabled = true
		]
		cfg.initialize(injector)
		Assert.assertEquals('com.acme.tests', cfg.runtimeTest.name)
		Assert.assertEquals('com.acme.ui.tests', cfg.eclipsePluginTest.name)
	}
	
}