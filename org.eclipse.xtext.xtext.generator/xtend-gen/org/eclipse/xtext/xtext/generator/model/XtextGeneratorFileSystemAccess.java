/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.inject.Injector;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

@SuppressWarnings("all")
public class XtextGeneratorFileSystemAccess extends JavaIoFileSystemAccess implements IXtextGeneratorFileSystemAccess {
  public XtextGeneratorFileSystemAccess(final String path, final boolean overwrite) {
    this.setOutputPath(this.removeTrailingPathSeparator(path));
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
    return IterableExtensions.<OutputConfiguration>head(this.getOutputConfigurations().values());
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
  }
  
  @Override
  public String getPath() {
    return this.getDefaultOutput().getOutputDirectory();
  }
  
  @Override
  public boolean isOverwrite() {
    return this.getDefaultOutput().isOverrideExistingResources();
  }
}
