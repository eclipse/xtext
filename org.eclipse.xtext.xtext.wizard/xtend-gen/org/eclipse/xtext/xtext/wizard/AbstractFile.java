/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;

@FinalFieldsConstructor
@SuppressWarnings("all")
public abstract class AbstractFile {
  @Accessors
  private final Outlet outlet;
  
  @Accessors
  private final String relativePath;
  
  @Accessors
  private final ProjectDescriptor project;
  
  @Accessors
  private final boolean executable;
  
  public AbstractFile(final Outlet outlet, final String relativePath, final ProjectDescriptor project, final boolean executable) {
    super();
    this.outlet = outlet;
    this.relativePath = relativePath;
    this.project = project;
    this.executable = executable;
  }
  
  @Pure
  public Outlet getOutlet() {
    return this.outlet;
  }
  
  @Pure
  public String getRelativePath() {
    return this.relativePath;
  }
  
  @Pure
  public ProjectDescriptor getProject() {
    return this.project;
  }
  
  @Pure
  public boolean isExecutable() {
    return this.executable;
  }
}
