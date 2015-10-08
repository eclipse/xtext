/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;

@SuppressWarnings("all")
public class WebProjectConfig extends SubProjectConfig {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess assets;
  
  public void setAssets(final String path) {
    XtextGeneratorFileSystemAccess _xtextGeneratorFileSystemAccess = new XtextGeneratorFileSystemAccess(path, true);
    this.assets = _xtextGeneratorFileSystemAccess;
  }
  
  @Override
  public void initialize(final Injector injector) {
    super.initialize(injector);
    if (this.assets!=null) {
      this.assets.initialize(injector);
    }
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getAssets() {
    return this.assets;
  }
}
