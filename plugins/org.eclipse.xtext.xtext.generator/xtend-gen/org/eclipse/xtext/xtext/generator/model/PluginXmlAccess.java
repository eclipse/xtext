/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class PluginXmlAccess {
  @Accessors
  private String path;
  
  public void generate() {
  }
  
  @Pure
  public String getPath() {
    return this.path;
  }
  
  public void setPath(final String path) {
    this.path = path;
  }
}
