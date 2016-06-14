/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.inject.Injector;
import java.util.Collection;
import java.util.Map;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

@SuppressWarnings("all")
public class XtextGeneratorFileSystemAccess extends JavaIoFileSystemAccess implements IXtextGeneratorFileSystemAccess {
  public XtextGeneratorFileSystemAccess(final String path, final boolean overwrite) {
    String _removeTrailingPathSeparator = this.removeTrailingPathSeparator(path);
    this.setOutputPath(_removeTrailingPathSeparator);
    OutputConfiguration _defaultOutput = this.getDefaultOutput();
    _defaultOutput.setOverrideExistingResources(overwrite);
  }
  
  private String removeTrailingPathSeparator(final String s) {
    String _xifexpression = null;
    boolean _endsWith = s.endsWith("/");
    if (_endsWith) {
      int _length = s.length();
      int _minus = (_length - 1);
      _xifexpression = s.substring(0, _minus);
    } else {
      _xifexpression = s;
    }
    return _xifexpression;
  }
  
  private OutputConfiguration getDefaultOutput() {
    Map<String, OutputConfiguration> _outputConfigurations = this.getOutputConfigurations();
    Collection<OutputConfiguration> _values = _outputConfigurations.values();
    return IterableExtensions.<OutputConfiguration>head(_values);
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
  }
  
  @Override
  public String getPath() {
    OutputConfiguration _defaultOutput = this.getDefaultOutput();
    return _defaultOutput.getOutputDirectory();
  }
  
  @Override
  public boolean isOverwrite() {
    OutputConfiguration _defaultOutput = this.getDefaultOutput();
    return _defaultOutput.isOverrideExistingResources();
  }
}
