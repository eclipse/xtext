/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.List;
import java.util.function.Consumer;
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
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

/**
 * @noextend
 */
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
    Iterable<Pair<String, String>> _projectMappings = this.getProjectMappings();
    final Consumer<Pair<String, String>> _function = (Pair<String, String> mapping) -> {
      ProjectMapping _projectMapping = new ProjectMapping();
      final Procedure1<ProjectMapping> _function_1 = (ProjectMapping it) -> {
        String _key = mapping.getKey();
        it.setProjectName(_key);
        String _value = mapping.getValue();
        it.setPath(_value);
      };
      ProjectMapping _doubleArrow = ObjectExtensions.<ProjectMapping>operator_doubleArrow(_projectMapping, _function_1);
      delegate.addProjectMapping(_doubleArrow);
    };
    _projectMappings.forEach(_function);
  }
  
  private Iterable<Pair<String, String>> getProjectMappings() {
    List<? extends ISubProjectConfig> _enabledProjects = this.projectConfig.getEnabledProjects();
    final Function1<ISubProjectConfig, Boolean> _function = (ISubProjectConfig it) -> {
      return Boolean.valueOf(((it.getName() != null) && (it.getRoot() != null)));
    };
    Iterable<? extends ISubProjectConfig> _filter = IterableExtensions.filter(_enabledProjects, _function);
    final Function1<ISubProjectConfig, Pair<String, String>> _function_1 = (ISubProjectConfig it) -> {
      String _name = it.getName();
      IXtextGeneratorFileSystemAccess _root = it.getRoot();
      String _path = _root.getPath();
      return Pair.<String, String>of(_name, _path);
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
