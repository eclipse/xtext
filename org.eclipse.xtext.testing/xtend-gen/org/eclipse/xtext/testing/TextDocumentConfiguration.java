/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import java.util.Map;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TextDocumentConfiguration {
  private Map<String, CharSequence> filesInScope = CollectionLiterals.<String, CharSequence>emptyMap();
  
  private String model;
  
  private String filePath;
  
  @Pure
  public Map<String, CharSequence> getFilesInScope() {
    return this.filesInScope;
  }
  
  public void setFilesInScope(final Map<String, CharSequence> filesInScope) {
    this.filesInScope = filesInScope;
  }
  
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
