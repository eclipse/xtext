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
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;

@SuppressWarnings("all")
public class SubProjectConfig implements ISubProjectConfig {
  @Inject
  @Accessors(AccessorType.PUBLIC_GETTER)
  private XtextProjectConfig owner;
  
  @Accessors
  private boolean enabled;
  
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
    if ((this.rootPath != null)) {
      XtextGeneratorFileSystemAccess _newFileSystemAccess = this.owner.newFileSystemAccess(this.rootPath, true);
      this.root = _newFileSystemAccess;
      this.root.initialize(injector);
    }
    if ((this.metaInfPath != null)) {
      XtextGeneratorFileSystemAccess _newFileSystemAccess_1 = this.owner.newFileSystemAccess(this.metaInfPath, true);
      this.metaInf = _newFileSystemAccess_1;
      this.metaInf.initialize(injector);
    }
    if ((this.srcPath != null)) {
      XtextGeneratorFileSystemAccess _newFileSystemAccess_2 = this.owner.newFileSystemAccess(this.srcPath, false);
      this.src = _newFileSystemAccess_2;
      this.src.initialize(injector);
    }
    if ((this.srcGenPath != null)) {
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
