/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.data;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.web.server.data.JsonObject;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class UpdateDocumentResult extends JsonObject {
  private String stateId;
  
  @Pure
  public String getStateId() {
    return this.stateId;
  }
  
  public void setStateId(final String stateId) {
    this.stateId = stateId;
  }
}
