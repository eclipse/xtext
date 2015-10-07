/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Collections;
import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.ProjectMapping;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

@Log
@SuppressWarnings("all")
public class XtextGeneratorStandaloneSetup implements IGuiceAwareGeneratorComponent {
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Accessors
  private boolean scanClasspath = true;
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
    this.setup();
  }
  
  private void setup() {
    final StandaloneSetup delegate = new StandaloneSetup();
    delegate.setScanClassPath(this.scanClasspath);
    Iterable<Pair<String, IXtextGeneratorFileSystemAccess>> _projectMappings = this.getProjectMappings();
    final Procedure1<Pair<String, IXtextGeneratorFileSystemAccess>> _function = new Procedure1<Pair<String, IXtextGeneratorFileSystemAccess>>() {
      @Override
      public void apply(final Pair<String, IXtextGeneratorFileSystemAccess> mapping) {
        ProjectMapping _projectMapping = new ProjectMapping();
        final Procedure1<ProjectMapping> _function = new Procedure1<ProjectMapping>() {
          @Override
          public void apply(final ProjectMapping it) {
            String _key = mapping.getKey();
            it.setProjectName(_key);
            IXtextGeneratorFileSystemAccess _value = mapping.getValue();
            String _path = _value.getPath();
            it.setPath(_path);
          }
        };
        ProjectMapping _doubleArrow = ObjectExtensions.<ProjectMapping>operator_doubleArrow(_projectMapping, _function);
        delegate.addProjectMapping(_doubleArrow);
      }
    };
    IterableExtensions.<Pair<String, IXtextGeneratorFileSystemAccess>>forEach(_projectMappings, _function);
  }
  
  private Iterable<Pair<String, IXtextGeneratorFileSystemAccess>> getProjectMappings() {
    String _runtimeProjectName = this.projectConfig.getRuntimeProjectName();
    IXtextGeneratorFileSystemAccess _runtimeRoot = this.projectConfig.getRuntimeRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo = Pair.<String, IXtextGeneratorFileSystemAccess>of(_runtimeProjectName, _runtimeRoot);
    String _runtimeTestProjectName = this.projectConfig.getRuntimeTestProjectName();
    IXtextGeneratorFileSystemAccess _runtimeTestRoot = this.projectConfig.getRuntimeTestRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo_1 = Pair.<String, IXtextGeneratorFileSystemAccess>of(_runtimeTestProjectName, _runtimeTestRoot);
    String _genericIdeProjectName = this.projectConfig.getGenericIdeProjectName();
    IXtextGeneratorFileSystemAccess _genericIdeRoot = this.projectConfig.getGenericIdeRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo_2 = Pair.<String, IXtextGeneratorFileSystemAccess>of(_genericIdeProjectName, _genericIdeRoot);
    String _genericIdeTestProjectName = this.projectConfig.getGenericIdeTestProjectName();
    IXtextGeneratorFileSystemAccess _genericIdeTestRoot = this.projectConfig.getGenericIdeTestRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo_3 = Pair.<String, IXtextGeneratorFileSystemAccess>of(_genericIdeTestProjectName, _genericIdeTestRoot);
    String _eclipsePluginProjectName = this.projectConfig.getEclipsePluginProjectName();
    IXtextGeneratorFileSystemAccess _eclipsePluginRoot = this.projectConfig.getEclipsePluginRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo_4 = Pair.<String, IXtextGeneratorFileSystemAccess>of(_eclipsePluginProjectName, _eclipsePluginRoot);
    String _eclipsePluginTestProjectName = this.projectConfig.getEclipsePluginTestProjectName();
    IXtextGeneratorFileSystemAccess _eclipsePluginTestRoot = this.projectConfig.getEclipsePluginTestRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo_5 = Pair.<String, IXtextGeneratorFileSystemAccess>of(_eclipsePluginTestProjectName, _eclipsePluginTestRoot);
    String _ideaPluginProjectName = this.projectConfig.getIdeaPluginProjectName();
    IXtextGeneratorFileSystemAccess _ideaPluginRoot = this.projectConfig.getIdeaPluginRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo_6 = Pair.<String, IXtextGeneratorFileSystemAccess>of(_ideaPluginProjectName, _ideaPluginRoot);
    String _ideaPluginTestProjectName = this.projectConfig.getIdeaPluginTestProjectName();
    IXtextGeneratorFileSystemAccess _ideaPluginTestRoot = this.projectConfig.getIdeaPluginTestRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo_7 = Pair.<String, IXtextGeneratorFileSystemAccess>of(_ideaPluginTestProjectName, _ideaPluginTestRoot);
    String _webProjectName = this.projectConfig.getWebProjectName();
    IXtextGeneratorFileSystemAccess _webRoot = this.projectConfig.getWebRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo_8 = Pair.<String, IXtextGeneratorFileSystemAccess>of(_webProjectName, _webRoot);
    String _webTestProjectName = this.projectConfig.getWebTestProjectName();
    IXtextGeneratorFileSystemAccess _webTestRoot = this.projectConfig.getWebTestRoot();
    Pair<String, IXtextGeneratorFileSystemAccess> _mappedTo_9 = Pair.<String, IXtextGeneratorFileSystemAccess>of(_webTestProjectName, _webTestRoot);
    final Function1<Pair<String, IXtextGeneratorFileSystemAccess>, Boolean> _function = new Function1<Pair<String, IXtextGeneratorFileSystemAccess>, Boolean>() {
      @Override
      public Boolean apply(final Pair<String, IXtextGeneratorFileSystemAccess> it) {
        boolean _and = false;
        String _key = it.getKey();
        boolean _notEquals = (!Objects.equal(_key, null));
        if (!_notEquals) {
          _and = false;
        } else {
          IXtextGeneratorFileSystemAccess _value = it.getValue();
          boolean _notEquals_1 = (!Objects.equal(_value, null));
          _and = _notEquals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<Pair<String, IXtextGeneratorFileSystemAccess>>filter(Collections.<Pair<String, IXtextGeneratorFileSystemAccess>>unmodifiableList(CollectionLiterals.<Pair<String, IXtextGeneratorFileSystemAccess>>newArrayList(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7, _mappedTo_8, _mappedTo_9)), _function);
  }
  
  private final static Logger LOG = Logger.getLogger(XtextGeneratorStandaloneSetup.class);
  
  @Pure
  public boolean isScanClasspath() {
    return this.scanClasspath;
  }
  
  public void setScanClasspath(final boolean scanClasspath) {
    this.scanClasspath = scanClasspath;
  }
}
