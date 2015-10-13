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
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.WebProjectConfig;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;

@Accessors
@SuppressWarnings("all")
public class XtextProjectConfig implements IXtextProjectConfig {
  private RuntimeProjectConfig runtime = new RuntimeProjectConfig();
  
  private BundleProjectConfig runtimeTest = new BundleProjectConfig();
  
  private BundleProjectConfig genericIde = new BundleProjectConfig();
  
  private BundleProjectConfig eclipsePlugin = new BundleProjectConfig();
  
  private BundleProjectConfig eclipsePluginTest = new BundleProjectConfig();
  
  private SubProjectConfig ideaPlugin = new SubProjectConfig();
  
  private WebProjectConfig web = new WebProjectConfig();
  
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
  public SubProjectConfig getIdeaPlugin() {
    return this.ideaPlugin;
  }
  
  public void setIdeaPlugin(final SubProjectConfig ideaPlugin) {
    this.ideaPlugin = ideaPlugin;
  }
  
  @Pure
  public WebProjectConfig getWeb() {
    return this.web;
  }
  
  public void setWeb(final WebProjectConfig web) {
    this.web = web;
  }
}
