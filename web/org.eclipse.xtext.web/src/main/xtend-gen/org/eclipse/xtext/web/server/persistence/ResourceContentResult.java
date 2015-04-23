/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.persistence;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class ResourceContentResult implements IServiceResult {
  private final String fullText;
  
  private String stateId;
  
  private boolean dirty;
  
  public ResourceContentResult(final String fullText) {
    super();
    this.fullText = fullText;
  }
  
  @Pure
  public String getFullText() {
    return this.fullText;
  }
  
  @Pure
  public String getStateId() {
    return this.stateId;
  }
  
  public void setStateId(final String stateId) {
    this.stateId = stateId;
  }
  
  @Pure
  public boolean isDirty() {
    return this.dirty;
  }
  
  public void setDirty(final boolean dirty) {
    this.dirty = dirty;
  }
}
