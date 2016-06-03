/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TextDocumentConfiguration {
  private String model = "";
  
  private String filePath;
  
  @Pure
  public String getModel() {
    return this.model;
  }
  
  public void setModel(final String model) {
    this.model = model;
  }
  
  @Pure
  public String getFilePath() {
    return this.filePath;
  }
  
  public void setFilePath(final String filePath) {
    this.filePath = filePath;
  }
}
