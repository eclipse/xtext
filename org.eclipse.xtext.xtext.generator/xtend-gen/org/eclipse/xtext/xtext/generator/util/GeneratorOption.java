/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.util;

/**
 * An object-valued option with default value for use in generator fragments.
 */
@SuppressWarnings("all")
public class GeneratorOption<T extends Object> {
  private final T defaultValue;
  
  private T value;
  
  /**
   * Create an option with no default value.
   */
  public GeneratorOption() {
    this.defaultValue = null;
  }
  
  /**
   * Create an option with a default value.
   */
  public GeneratorOption(final T defaultValue) {
    this.defaultValue = defaultValue;
  }
  
  public T get() {
    T _elvis = null;
    if (this.value != null) {
      _elvis = this.value;
    } else {
      _elvis = this.defaultValue;
    }
    return _elvis;
  }
  
  public void set(final T value) {
    this.value = value;
  }
  
  public boolean isSet() {
    return (this.value != null);
  }
}
