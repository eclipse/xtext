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
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;

@SuppressWarnings("all")
public class SubProjectConfig implements IGuiceAwareGeneratorComponent {
  @Accessors
  private boolean enabled;
  
  @Accessors
  private String name;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess root;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess metaInf;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess src;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IXtextGeneratorFileSystemAccess srcGen;
  
  public void setRoot(final String path) {
    XtextGeneratorFileSystemAccess _xtextGeneratorFileSystemAccess = new XtextGeneratorFileSystemAccess(path, true);
    this.root = _xtextGeneratorFileSystemAccess;
  }
  
  public void setMetaInf(final String path) {
    XtextGeneratorFileSystemAccess _xtextGeneratorFileSystemAccess = new XtextGeneratorFileSystemAccess(path, true);
    this.metaInf = _xtextGeneratorFileSystemAccess;
  }
  
  public void setSrc(final String path) {
    XtextGeneratorFileSystemAccess _xtextGeneratorFileSystemAccess = new XtextGeneratorFileSystemAccess(path, false);
    this.src = _xtextGeneratorFileSystemAccess;
  }
  
  public void setSrcGen(final String path) {
    XtextGeneratorFileSystemAccess _xtextGeneratorFileSystemAccess = new XtextGeneratorFileSystemAccess(path, true);
    this.srcGen = _xtextGeneratorFileSystemAccess;
  }
  
  public void checkConfiguration(final Issues issues) {
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
    if (this.root!=null) {
      this.root.initialize(injector);
    }
    if (this.metaInf!=null) {
      this.metaInf.initialize(injector);
    }
    if (this.src!=null) {
      this.src.initialize(injector);
    }
    if (this.srcGen!=null) {
      this.srcGen.initialize(injector);
    }
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
  public IXtextGeneratorFileSystemAccess getRoot() {
    return this.root;
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getMetaInf() {
    return this.metaInf;
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getSrc() {
    return this.src;
  }
  
  @Pure
  public IXtextGeneratorFileSystemAccess getSrcGen() {
    return this.srcGen;
  }
}
