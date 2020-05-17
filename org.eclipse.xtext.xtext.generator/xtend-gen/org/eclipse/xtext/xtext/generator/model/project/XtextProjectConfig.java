/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.project;

import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import javax.inject.Inject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.WebProjectConfig;

/**
 * Configuration of the subprojects for one or more Xtext languages. If the standard project names
 * and layout is sufficient, use {@link StandardProjectConfig}.
 * 
 * @noextend This class should not be extended by clients.
 */
@Accessors
@SuppressWarnings("all")
public class XtextProjectConfig implements IXtextProjectConfig {
  private RuntimeProjectConfig runtime = new RuntimeProjectConfig();
  
  private BundleProjectConfig runtimeTest = new BundleProjectConfig();
  
  private BundleProjectConfig genericIde = new BundleProjectConfig();
  
  private BundleProjectConfig eclipsePlugin = new BundleProjectConfig();
  
  private BundleProjectConfig eclipsePluginTest = new BundleProjectConfig();
  
  private WebProjectConfig web = new WebProjectConfig();
  
  @Inject
  private CodeConfig codeConfig;
  
  public void checkConfiguration(final Issues issues) {
    final Consumer<SubProjectConfig> _function = (SubProjectConfig it) -> {
      it.checkConfiguration(issues);
    };
    this.getEnabledProjects().forEach(_function);
  }
  
  public List<? extends SubProjectConfig> getAllProjects() {
    ArrayList<SubProjectConfig> _xblockexpression = null;
    {
      final ArrayList<SubProjectConfig> allProjects = CollectionLiterals.<SubProjectConfig>newArrayList();
      Iterables.<SubProjectConfig>addAll(allProjects, Collections.<SubProjectConfig>unmodifiableList(CollectionLiterals.<SubProjectConfig>newArrayList(this.runtime, this.runtimeTest, this.genericIde, this.eclipsePlugin, this.eclipsePluginTest, this.web)));
      _xblockexpression = allProjects;
    }
    return _xblockexpression;
  }
  
  @Override
  public List<? extends SubProjectConfig> getTestProjects() {
    ArrayList<BundleProjectConfig> _xblockexpression = null;
    {
      final ArrayList<BundleProjectConfig> testProjects = CollectionLiterals.<BundleProjectConfig>newArrayList();
      Iterables.<BundleProjectConfig>addAll(testProjects, Collections.<BundleProjectConfig>unmodifiableList(CollectionLiterals.<BundleProjectConfig>newArrayList(this.runtimeTest, this.eclipsePluginTest)));
      _xblockexpression = testProjects;
    }
    return _xblockexpression;
  }
  
  @Override
  public List<? extends SubProjectConfig> getEnabledProjects() {
    ArrayList<SubProjectConfig> _xblockexpression = null;
    {
      final ArrayList<SubProjectConfig> enabledProjects = CollectionLiterals.<SubProjectConfig>newArrayList();
      final Function1<SubProjectConfig, Boolean> _function = (SubProjectConfig it) -> {
        return Boolean.valueOf(it.isEnabled());
      };
      Iterable<? extends SubProjectConfig> _filter = IterableExtensions.filter(this.getAllProjects(), _function);
      Iterables.<SubProjectConfig>addAll(enabledProjects, _filter);
      _xblockexpression = enabledProjects;
    }
    return _xblockexpression;
  }
  
  @Override
  public void initialize(final Injector injector) {
    this.setDefaults();
    injector.injectMembers(this);
    final Consumer<SubProjectConfig> _function = (SubProjectConfig it) -> {
      it.initialize(injector);
    };
    this.getEnabledProjects().forEach(_function);
  }
  
  public void setDefaults() {
    this.runtime.setEnabled(true);
    final Function1<SubProjectConfig, Boolean> _function = (SubProjectConfig it) -> {
      return Boolean.valueOf(it.isEnabled());
    };
    boolean _exists = IterableExtensions.exists(Collections.<SubProjectConfig>unmodifiableList(CollectionLiterals.<SubProjectConfig>newArrayList(this.eclipsePlugin, this.web)), _function);
    if (_exists) {
      this.genericIde.setEnabled(true);
    }
  }
  
  protected ManifestAccess newManifestAccess() {
    ManifestAccess _manifestAccess = new ManifestAccess();
    final Procedure1<ManifestAccess> _function = (ManifestAccess it) -> {
      it.setLineDelimiter(this.codeConfig.getLineDelimiter());
    };
    return ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifestAccess, _function);
  }
  
  protected PluginXmlAccess newPluginXmlAccess() {
    return new PluginXmlAccess();
  }
  
  protected XtextGeneratorFileSystemAccess newFileSystemAccess(final String path, final boolean overWrite) {
    return new XtextGeneratorFileSystemAccess(path, overWrite);
  }
  
  @Pure
  public RuntimeProjectConfig getRuntime() {
    return this.runtime;
  }
  
  public void setRuntime(final RuntimeProjectConfig runtime) {
    this.runtime = runtime;
  }
  
  @Pure
  public BundleProjectConfig getRuntimeTest() {
    return this.runtimeTest;
  }
  
  public void setRuntimeTest(final BundleProjectConfig runtimeTest) {
    this.runtimeTest = runtimeTest;
  }
  
  @Pure
  public BundleProjectConfig getGenericIde() {
    return this.genericIde;
  }
  
  public void setGenericIde(final BundleProjectConfig genericIde) {
    this.genericIde = genericIde;
  }
  
  @Pure
  public BundleProjectConfig getEclipsePlugin() {
    return this.eclipsePlugin;
  }
  
  public void setEclipsePlugin(final BundleProjectConfig eclipsePlugin) {
    this.eclipsePlugin = eclipsePlugin;
  }
  
  @Pure
  public BundleProjectConfig getEclipsePluginTest() {
    return this.eclipsePluginTest;
  }
  
  public void setEclipsePluginTest(final BundleProjectConfig eclipsePluginTest) {
    this.eclipsePluginTest = eclipsePluginTest;
  }
  
  @Pure
  public WebProjectConfig getWeb() {
    return this.web;
  }
  
  public void setWeb(final WebProjectConfig web) {
    this.web = web;
  }
  
  @Pure
  public CodeConfig getCodeConfig() {
    return this.codeConfig;
  }
  
  public void setCodeConfig(final CodeConfig codeConfig) {
    this.codeConfig = codeConfig;
  }
}
