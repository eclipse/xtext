/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model.project;

import com.google.common.base.CharMatcher;
import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.XtextProjectConfig;

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
   * The path is delimited by '/', but does not begin or end with a separator.
   */
  @Override
  public String getEcoreModelFolder() {
    String _path = this.ecoreModel.getPath();
    IXtextGeneratorFileSystemAccess _root = this.getRoot();
    String _path_1 = _root.getPath();
    boolean _startsWith = _path.startsWith(_path_1);
    if (_startsWith) {
      String _path_2 = this.ecoreModel.getPath();
      IXtextGeneratorFileSystemAccess _root_1 = this.getRoot();
      String _path_3 = _root_1.getPath();
      int _length = _path_3.length();
      String _substring = _path_2.substring(_length);
      final String relativePath = _substring.replace("\\", "/");
      CharMatcher _is = CharMatcher.is('/');
      return _is.trimFrom(relativePath);
    }
    throw new RuntimeException("Could not derive the Ecore model folder from the project configuration. Please make sure that \'root\' is a prefix of \'ecoreModel\'.");
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
