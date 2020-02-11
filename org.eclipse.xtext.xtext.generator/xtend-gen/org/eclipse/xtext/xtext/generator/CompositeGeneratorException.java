/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
class CompositeGeneratorException extends RuntimeException {
  @Accessors
  private final List<Exception> exceptions = CollectionLiterals.<Exception>newArrayList();
  
  public boolean addException(final Exception exception) {
    return this.exceptions.add(exception);
  }
  
  public boolean hasExceptions() {
    int _size = this.exceptions.size();
    return (_size > 0);
  }
  
  @Pure
  public List<Exception> getExceptions() {
    return this.exceptions;
  }
}
