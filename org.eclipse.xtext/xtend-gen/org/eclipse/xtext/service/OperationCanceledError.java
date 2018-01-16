/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.service;

/**
 * @since 2.8
 */
@SuppressWarnings("all")
public class OperationCanceledError extends Error {
  public OperationCanceledError(final RuntimeException cause) {
    super(cause);
  }
  
  public RuntimeException getWrapped() {
    Throwable _cause = this.getCause();
    return ((RuntimeException) _cause);
  }
}
