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
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.utils.ProjectMapping;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

@Log
@SuppressWarnings("all")
public class XtextGeneratorStandaloneSetup implements IGuiceAwareGeneratorComponent {
  @Inject
  private XtextProjectConfig projectConfig;
  
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
    Iterable<Pair<String, String>> _projectMappings = this.getProjectMappings();
    final Procedure1<Pair<String, String>> _function = new Procedure1<Pair<String, String>>() {
      @Override
      public void apply(final Pair<String, String> mapping) {
        ProjectMapping _projectMapping = new ProjectMapping();
        final Procedure1<ProjectMapping> _function = new Procedure1<ProjectMapping>() {
          @Override
          public void apply(final ProjectMapping it) {
            String _key = mapping.getKey();
            it.setProjectName(_key);
            String _value = mapping.getValue();
            it.setPath(_value);
          }
        };
        ProjectMapping _doubleArrow = ObjectExtensions.<ProjectMapping>operator_doubleArrow(_projectMapping, _function);
        delegate.addProjectMapping(_doubleArrow);
      }
    };
    IterableExtensions.<Pair<String, String>>forEach(_projectMappings, _function);
  }
  
  private Iterable<Pair<String, String>> getProjectMappings() {
    List<? extends SubProjectConfig> _enabledProjects = this.projectConfig.getEnabledProjects();
    final Function1<SubProjectConfig, Boolean> _function = new Function1<SubProjectConfig, Boolean>() {
      @Override
      public Boolean apply(final SubProjectConfig it) {
        boolean _and = false;
        String _name = it.getName();
        boolean _notEquals = (!Objects.equal(_name, null));
        if (!_notEquals) {
          _and = false;
        } else {
          IXtextGeneratorFileSystemAccess _root = it.getRoot();
          boolean _notEquals_1 = (!Objects.equal(_root, null));
          _and = _notEquals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<? extends SubProjectConfig> _filter = IterableExtensions.filter(_enabledProjects, _function);
    final Function1<SubProjectConfig, Pair<String, String>> _function_1 = new Function1<SubProjectConfig, Pair<String, String>>() {
      @Override
      public Pair<String, String> apply(final SubProjectConfig it) {
        String _name = it.getName();
        IXtextGeneratorFileSystemAccess _root = it.getRoot();
        String _path = _root.getPath();
        return Pair.<String, String>of(_name, _path);
      }
    };
    return IterableExtensions.map(_filter, _function_1);
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
