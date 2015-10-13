/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.CharMatcher;
import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;

@SuppressWarnings("all")
public class RuntimeProjectConfig extends BundleProjectConfig implements IRuntimeProjectConfig {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String ecoreModelPath;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess ecoreModel;
  
  public void setEcoreModel(final String path) {
    this.ecoreModelPath = path;
  }
  
  /**
   * Returns the root-relative path of the folder where the generated .ecore and .genmodel can be found.
   * The path is delimited by and ends with '/'
   */
  @Override
  public String getEcoreModelFolder() {
    String _xblockexpression = null;
    {
      IXtextGeneratorFileSystemAccess _root = this.getRoot();
      String _path = _root.getPath();
      String _replace = this.ecoreModelPath.replace(_path, "");
      final String ecoreModelFolder = _replace.replace("\\", "/");
      final CharMatcher slashes = CharMatcher.is('/');
      String _trimFrom = slashes.trimFrom(ecoreModelFolder);
      _xblockexpression = (_trimFrom + "/");
    }
    return _xblockexpression;
  }
  
  @Override
  public void initialize(final Injector injector) {
    super.initialize(injector);
    if ((this.ecoreModelPath != null)) {
      XtextProjectConfig _owner = this.getOwner();
      XtextGeneratorFileSystemAccess _newFileSystemAccess = _owner.newFileSystemAccess(this.ecoreModelPath, true);
      this.ecoreModel = _newFileSystemAccess;
      this.ecoreModel.initialize(injector);
    }
  }
  
  @Pure
  public String getEcoreModelPath() {
    return this.ecoreModelPath;
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getEcoreModel() {
    return this.ecoreModel;
  }
}
