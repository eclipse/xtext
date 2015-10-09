/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.WebProjectConfig;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;

@Accessors(AccessorType.PUBLIC_GETTER)
@SuppressWarnings("all")
public class XtextProjectConfig implements IGuiceAwareGeneratorComponent {
  private RuntimeProjectConfig runtime;
  
  private BundleProjectConfig runtimeTest;
  
  private BundleProjectConfig genericIde;
  
  private BundleProjectConfig eclipsePlugin;
  
  private BundleProjectConfig eclipsePluginTest;
  
  private SubProjectConfig ideaPlugin;
  
  private WebProjectConfig web;
  
  public XtextProjectConfig() {
    RuntimeProjectConfig _runtimeProjectConfig = new RuntimeProjectConfig();
    this.setRuntime(_runtimeProjectConfig);
    BundleProjectConfig _bundleProjectConfig = new BundleProjectConfig();
    this.setRuntimeTest(_bundleProjectConfig);
    BundleProjectConfig _bundleProjectConfig_1 = new BundleProjectConfig();
    this.setGenericIde(_bundleProjectConfig_1);
    BundleProjectConfig _bundleProjectConfig_2 = new BundleProjectConfig();
    this.setEclipsePlugin(_bundleProjectConfig_2);
    BundleProjectConfig _bundleProjectConfig_3 = new BundleProjectConfig();
    this.setEclipsePluginTest(_bundleProjectConfig_3);
    SubProjectConfig _subProjectConfig = new SubProjectConfig();
    this.setIdeaPlugin(_subProjectConfig);
    WebProjectConfig _webProjectConfig = new WebProjectConfig();
    this.setWeb(_webProjectConfig);
  }
  
  public void setRuntime(final RuntimeProjectConfig config) {
    this.runtime = config;
    config.setOwner(this);
  }
  
  public void setRuntimeTest(final BundleProjectConfig config) {
    this.runtimeTest = config;
    config.setOwner(this);
  }
  
  public void setGenericIde(final BundleProjectConfig config) {
    this.genericIde = config;
    config.setOwner(this);
  }
  
  public void setEclipsePlugin(final BundleProjectConfig config) {
    this.eclipsePlugin = config;
    config.setOwner(this);
  }
  
  public void setEclipsePluginTest(final BundleProjectConfig config) {
    this.eclipsePluginTest = config;
    config.setOwner(this);
  }
  
  public void setIdeaPlugin(final SubProjectConfig config) {
    this.ideaPlugin = config;
    config.setOwner(this);
  }
  
  public void setWeb(final WebProjectConfig config) {
    this.web = config;
    config.setOwner(this);
  }
  
  public void checkConfiguration(final Issues issues) {
    List<? extends SubProjectConfig> _enabledProjects = this.getEnabledProjects();
    final Procedure1<SubProjectConfig> _function = new Procedure1<SubProjectConfig>() {
      @Override
      public void apply(final SubProjectConfig it) {
        it.checkConfiguration(issues);
      }
    };
    IterableExtensions.forEach(_enabledProjects, _function);
  }
  
  public List<? extends SubProjectConfig> getAllProjects() {
    ArrayList<SubProjectConfig> _xblockexpression = null;
    {
      final ArrayList<SubProjectConfig> allProjects = CollectionLiterals.<SubProjectConfig>newArrayList();
      Iterables.<SubProjectConfig>addAll(allProjects, Collections.<SubProjectConfig>unmodifiableList(CollectionLiterals.<SubProjectConfig>newArrayList(this.runtime, this.runtimeTest, this.genericIde, this.eclipsePlugin, this.eclipsePluginTest, this.ideaPlugin, this.web)));
      _xblockexpression = allProjects;
    }
    return _xblockexpression;
  }
  
  public List<? extends SubProjectConfig> getTestProjects() {
    ArrayList<BundleProjectConfig> _xblockexpression = null;
    {
      final ArrayList<BundleProjectConfig> testProjects = CollectionLiterals.<BundleProjectConfig>newArrayList();
      Iterables.<BundleProjectConfig>addAll(testProjects, Collections.<BundleProjectConfig>unmodifiableList(CollectionLiterals.<BundleProjectConfig>newArrayList(this.runtimeTest, this.eclipsePluginTest)));
      _xblockexpression = testProjects;
    }
    return _xblockexpression;
  }
  
  public List<? extends SubProjectConfig> getEnabledProjects() {
    ArrayList<SubProjectConfig> _xblockexpression = null;
    {
      final ArrayList<SubProjectConfig> enabledProjects = CollectionLiterals.<SubProjectConfig>newArrayList();
      List<? extends SubProjectConfig> _allProjects = this.getAllProjects();
      final Function1<SubProjectConfig, Boolean> _function = new Function1<SubProjectConfig, Boolean>() {
        @Override
        public Boolean apply(final SubProjectConfig it) {
          return Boolean.valueOf(it.isEnabled());
        }
      };
      Iterable<? extends SubProjectConfig> _filter = IterableExtensions.filter(_allProjects, _function);
      Iterables.<SubProjectConfig>addAll(enabledProjects, _filter);
      _xblockexpression = enabledProjects;
    }
    return _xblockexpression;
  }
  
  @Override
  public void initialize(final Injector injector) {
    this.setDefaults();
    injector.injectMembers(this);
    List<? extends SubProjectConfig> _enabledProjects = this.getEnabledProjects();
    final Procedure1<SubProjectConfig> _function = new Procedure1<SubProjectConfig>() {
      @Override
      public void apply(final SubProjectConfig it) {
        it.initialize(injector);
      }
    };
    IterableExtensions.forEach(_enabledProjects, _function);
  }
  
  public void setDefaults() {
    this.runtime.setEnabled(true);
    final Function1<SubProjectConfig, Boolean> _function = new Function1<SubProjectConfig, Boolean>() {
      @Override
      public Boolean apply(final SubProjectConfig it) {
        return Boolean.valueOf(it.isEnabled());
      }
    };
    boolean _exists = IterableExtensions.exists(Collections.<SubProjectConfig>unmodifiableList(CollectionLiterals.<SubProjectConfig>newArrayList(this.eclipsePlugin, this.ideaPlugin, this.web)), _function);
    if (_exists) {
      this.genericIde.setEnabled(true);
    }
  }
  
  protected ManifestAccess newManifestAccess() {
    return new ManifestAccess();
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
  
  @Pure
  public BundleProjectConfig getRuntimeTest() {
    return this.runtimeTest;
  }
  
  @Pure
  public BundleProjectConfig getGenericIde() {
    return this.genericIde;
  }
  
  @Pure
  public BundleProjectConfig getEclipsePlugin() {
    return this.eclipsePlugin;
  }
  
  @Pure
  public BundleProjectConfig getEclipsePluginTest() {
    return this.eclipsePluginTest;
  }
  
  @Pure
  public SubProjectConfig getIdeaPlugin() {
    return this.ideaPlugin;
  }
  
  @Pure
  public WebProjectConfig getWeb() {
    return this.web;
  }
}
