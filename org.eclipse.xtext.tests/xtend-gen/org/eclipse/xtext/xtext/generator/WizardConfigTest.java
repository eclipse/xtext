/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class WizardConfigTest {
  private Injector injector;
  
  @Before
  public void createInjector() {
    DefaultGeneratorModule _defaultGeneratorModule = new DefaultGeneratorModule();
    this.injector = Guice.createInjector(_defaultGeneratorModule);
  }
  
  @Test
  public void testMavenProjectNames() {
    StandardProjectConfig _standardProjectConfig = new StandardProjectConfig();
    final Procedure1<StandardProjectConfig> _function = (StandardProjectConfig it) -> {
      it.setBaseName("com.acme");
      it.setMavenLayout(true);
      BundleProjectConfig _runtimeTest = it.getRuntimeTest();
      _runtimeTest.setEnabled(true);
      BundleProjectConfig _eclipsePlugin = it.getEclipsePlugin();
      _eclipsePlugin.setEnabled(true);
      BundleProjectConfig _eclipsePluginTest = it.getEclipsePluginTest();
      _eclipsePluginTest.setEnabled(true);
    };
    final StandardProjectConfig cfg = ObjectExtensions.<StandardProjectConfig>operator_doubleArrow(_standardProjectConfig, _function);
    cfg.initialize(this.injector);
    Assert.assertEquals("com.acme", cfg.getRuntimeTest().getName());
    Assert.assertEquals("com.acme.ui", cfg.getEclipsePluginTest().getName());
  }
  
  @Test
  public void testPlainProjectNames() {
    StandardProjectConfig _standardProjectConfig = new StandardProjectConfig();
    final Procedure1<StandardProjectConfig> _function = (StandardProjectConfig it) -> {
      it.setBaseName("com.acme");
      BundleProjectConfig _runtimeTest = it.getRuntimeTest();
      _runtimeTest.setEnabled(true);
      BundleProjectConfig _eclipsePlugin = it.getEclipsePlugin();
      _eclipsePlugin.setEnabled(true);
      BundleProjectConfig _eclipsePluginTest = it.getEclipsePluginTest();
      _eclipsePluginTest.setEnabled(true);
    };
    final StandardProjectConfig cfg = ObjectExtensions.<StandardProjectConfig>operator_doubleArrow(_standardProjectConfig, _function);
    cfg.initialize(this.injector);
    Assert.assertEquals("com.acme.tests", cfg.getRuntimeTest().getName());
    Assert.assertEquals("com.acme.ui.tests", cfg.getEclipsePluginTest().getName());
  }
}
