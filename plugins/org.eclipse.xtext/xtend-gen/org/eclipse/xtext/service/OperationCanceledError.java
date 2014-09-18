/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.service;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @since 2.8
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class OperationCanceledError extends Error {
  @Accessors
  private final RuntimeException wrapped;
  
  public Throwable fillInStackTrace() {
    return null;
  }
  
  public Throwable getCause() {
    return this.wrapped;
  }
  
  public String getLocalizedMessage() {
    return this.wrapped.getLocalizedMessage();
  }
  
  public String getMessage() {
    return this.wrapped.getMessage();
  }
  
  public StackTraceElement[] getStackTrace() {
    return this.wrapped.getStackTrace();
  }
  
  public OperationCanceledError(final RuntimeException wrapped) {
    super();
    this.wrapped = wrapped;
  }
  
  @Pure
  public RuntimeException getWrapped() {
    return this.wrapped;
  }
}
