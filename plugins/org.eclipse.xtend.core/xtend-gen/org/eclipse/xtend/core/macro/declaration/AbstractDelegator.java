/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractDelegator<T extends Object> {
  @Accessors
  private T delegate;
  
  @Accessors
  private CompilationUnitImpl compilationUnit;
  
  @Pure
  public T getDelegate() {
    return this.delegate;
  }
  
  public void setDelegate(final T delegate) {
    this.delegate = delegate;
  }
  
  @Pure
  public CompilationUnitImpl getCompilationUnit() {
    return this.compilationUnit;
  }
  
  public void setCompilationUnit(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }
}
