/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class WizardConfigTest {
	private Injector injector;

	@Before
	public void createInjector() {
		injector = Guice.createInjector(new DefaultGeneratorModule());
	}

	@Test
	public void testMavenProjectNames() {
		StandardProjectConfig cfg = new StandardProjectConfig();
		cfg.setBaseName("com.acme");
		cfg.setMavenLayout(true);
		cfg.getRuntimeTest().setEnabled(true);
		cfg.getEclipsePlugin().setEnabled(true);
		cfg.getEclipsePluginTest().setEnabled(true);
		cfg.initialize(injector);
		Assert.assertEquals("com.acme", cfg.getRuntimeTest().getName());
		Assert.assertEquals("com.acme.ui", cfg.getEclipsePluginTest().getName());
	}

	@Test
	public void testPlainProjectNames() {
		StandardProjectConfig cfg = new StandardProjectConfig();
		cfg.setBaseName("com.acme");
		cfg.getRuntimeTest().setEnabled(true);
		cfg.getEclipsePlugin().setEnabled(true);
		cfg.getEclipsePluginTest().setEnabled(true);
		cfg.initialize(injector);
		Assert.assertEquals("com.acme.tests", cfg.getRuntimeTest().getName());
		Assert.assertEquals("com.acme.ui.tests", cfg.getEclipsePluginTest().getName());
	}
}
