/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.project;

import com.google.common.base.CharMatcher;
import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;

/**
 * Configuration of the runtime project, i.e. the main subproject containing the language definition.
 * 
 * @noextend This class should not be extended by clients.
 */
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
    boolean _startsWith = this.ecoreModel.getPath().startsWith(this.getRoot().getPath());
    if (_startsWith) {
      final String relativePath = this.ecoreModel.getPath().substring(this.getRoot().getPath().length()).replace("\\", "/");
      return CharMatcher.is('/').trimFrom(relativePath);
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Could not derive the Ecore model folder from the project configuration. ");
    _builder.newLine();
    _builder.append("Please make sure that \'root\' is a prefix of \'ecoreModel\'.");
    _builder.newLine();
    _builder.append("was (root=\'");
    String _path = this.getRoot().getPath();
    _builder.append(_path);
    _builder.append("\', ecoreModel=\'");
    String _path_1 = this.ecoreModel.getPath();
    _builder.append(_path_1);
    _builder.append("\')");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    throw new RuntimeException(_builder.toString());
  }
  
  @Override
  public void initialize(final Injector injector) {
    super.initialize(injector);
    if ((this.ecoreModelPath != null)) {
      this.ecoreModel = this.getOwner().newFileSystemAccess(this.ecoreModelPath, true);
      this.ecoreModel.initialize(injector);
    }
  }
  
  @Override
  public String getXbaseLibVersionLowerBound() {
    return "2.14.0";
  }
  
  @Override
  public String getXtendLibVersionLowerBound() {
    return this.getXbaseLibVersionLowerBound();
  }
  
  @Pure
  public String getEcoreModelPath() {
    return this.ecoreModelPath;
  }
  
  @Pure
  @Override
  public IXtextGeneratorFileSystemAccess getEcoreModel() {
    return this.ecoreModel;
  }
}
