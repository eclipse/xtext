/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class InvalidRequestException extends Exception {
  public enum Type {
    INVALID_PARAMETERS,
    
    UNKNOWN_LANGUAGE,
    
    RESOURCE_NOT_FOUND,
    
    INVALID_DOCUMENT_STATE;
  }
  
  private final InvalidRequestException.Type type;
  
  public InvalidRequestException(final InvalidRequestException.Type type, final String message) {
    super(message);
    this.type = type;
  }
  
  @Pure
  public InvalidRequestException.Type getType() {
    return this.type;
  }
}
