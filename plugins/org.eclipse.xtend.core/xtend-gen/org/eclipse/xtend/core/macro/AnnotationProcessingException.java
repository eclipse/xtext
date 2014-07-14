/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class AnnotationProcessingException extends RuntimeException {
  @Accessors
  private final URI problematicResource;
  
  public AnnotationProcessingException(final String message, final URI problematicResource) {
    super(message);
    this.problematicResource = problematicResource;
  }
  
  public AnnotationProcessingException(final String message, final Throwable cause, final URI problematicResource) {
    super(message, cause);
    this.problematicResource = problematicResource;
  }
  
  @Pure
  public URI getProblematicResource() {
    return this.problematicResource;
  }
}
