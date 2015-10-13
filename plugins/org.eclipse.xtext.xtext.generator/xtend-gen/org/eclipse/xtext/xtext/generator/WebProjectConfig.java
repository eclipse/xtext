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
import org.eclipse.xtext.xtext.generator.IWebProjectConfig;
import org.eclipse.xtext.xtext.generator.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;

@SuppressWarnings("all")
public class WebProjectConfig extends SubProjectConfig implements IWebProjectConfig {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String assetsPath;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess assets;
  
  public void setAssets(final String path) {
    this.assetsPath = path;
  }
  
  @Override
  public void initialize(final Injector injector) {
    super.initialize(injector);
    if ((this.assetsPath != null)) {
      XtextProjectConfig _owner = this.getOwner();
      XtextGeneratorFileSystemAccess _newFileSystemAccess = _owner.newFileSystemAccess(this.assetsPath, true);
      this.assets = _newFileSystemAccess;
      this.assets.initialize(injector);
    }
  }
  
  @Pure
  public String getAssetsPath() {
    return this.assetsPath;
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getAssets() {
    return this.assets;
  }
}
