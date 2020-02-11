/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.project;

import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.IWebProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.SubProjectConfig;

/**
 * Configuration of the web project.
 * 
 * @noextend This class should not be extended by clients.
 */
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
      this.assets = this.getOwner().newFileSystemAccess(this.assetsPath, true);
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
