/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.util;

/**
 * A Boolean-valued option with default value for use in generator fragments.
 */
@SuppressWarnings("all")
public class BooleanGeneratorOption {
  private final boolean defaultValue;
  
  private Boolean value;
  
  public BooleanGeneratorOption() {
    this(false);
  }
  
  public BooleanGeneratorOption(final boolean defaultValue) {
    this.defaultValue = defaultValue;
  }
  
  public boolean get() {
    Boolean _elvis = null;
    if (this.value != null) {
      _elvis = this.value;
    } else {
      _elvis = Boolean.valueOf(this.defaultValue);
    }
    return (boolean) _elvis;
  }
  
  public void set(final boolean value) {
    this.value = Boolean.valueOf(value);
  }
  
  public boolean isSet() {
    return (this.value != null);
  }
}
