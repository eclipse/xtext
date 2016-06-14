/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model.project;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.XtextProjectConfig;

/**
 * @noextend
 */
@SuppressWarnings("all")
public class SubProjectConfig implements ISubProjectConfig {
  @Inject
  @Accessors(AccessorType.PUBLIC_GETTER)
  private XtextProjectConfig owner;
  
  @Accessors
  private boolean enabled;
  
  @Accessors
  private boolean overwriteSrc;
  
  @Accessors
  private String name;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String rootPath;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess root;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String metaInfPath;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess metaInf;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String srcPath;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess src;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String srcGenPath;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess srcGen;
  
  public void setRoot(final String path) {
    this.rootPath = path;
  }
  
  public void setMetaInf(final String path) {
    this.metaInfPath = path;
  }
  
  public void setSrc(final String path) {
    this.srcPath = path;
  }
  
  public void setSrcGen(final String path) {
    this.srcGenPath = path;
  }
  
  public void checkConfiguration(final Issues issues) {
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.rootPath);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      XtextGeneratorFileSystemAccess _newFileSystemAccess = this.owner.newFileSystemAccess(this.rootPath, true);
      this.root = _newFileSystemAccess;
      this.root.initialize(injector);
    }
    boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(this.metaInfPath);
    boolean _not_1 = (!_isNullOrEmpty_1);
    if (_not_1) {
      XtextGeneratorFileSystemAccess _newFileSystemAccess_1 = this.owner.newFileSystemAccess(this.metaInfPath, true);
      this.metaInf = _newFileSystemAccess_1;
      this.metaInf.initialize(injector);
    }
    boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(this.srcPath);
    boolean _not_2 = (!_isNullOrEmpty_2);
    if (_not_2) {
      XtextGeneratorFileSystemAccess _newFileSystemAccess_2 = this.owner.newFileSystemAccess(this.srcPath, this.overwriteSrc);
      this.src = _newFileSystemAccess_2;
      this.src.initialize(injector);
    }
    boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(this.srcGenPath);
    boolean _not_3 = (!_isNullOrEmpty_3);
    if (_not_3) {
      XtextGeneratorFileSystemAccess _newFileSystemAccess_3 = this.owner.newFileSystemAccess(this.srcGenPath, true);
      this.srcGen = _newFileSystemAccess_3;
      this.srcGen.initialize(injector);
    }
  }
  
  @Pure
  public XtextProjectConfig getOwner() {
    return this.owner;
  }
  
  @Pure
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }
  
  @Pure
  public boolean isOverwriteSrc() {
    return this.overwriteSrc;
  }
  
  public void setOverwriteSrc(final boolean overwriteSrc) {
    this.overwriteSrc = overwriteSrc;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public String getRootPath() {
    return this.rootPath;
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getRoot() {
    return this.root;
  }
  
  @Pure
  public String getMetaInfPath() {
    return this.metaInfPath;
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getMetaInf() {
    return this.metaInf;
  }
  
  @Pure
  public String getSrcPath() {
    return this.srcPath;
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getSrc() {
    return this.src;
  }
  
  @Pure
  public String getSrcGenPath() {
    return this.srcGenPath;
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getSrcGen() {
    return this.srcGen;
  }
}
