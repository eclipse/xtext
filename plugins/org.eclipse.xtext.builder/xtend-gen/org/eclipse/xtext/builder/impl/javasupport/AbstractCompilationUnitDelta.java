/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl.javasupport;

import com.google.common.base.Preconditions;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.impl.javasupport.CompilationUnitDelta;
import org.eclipse.xtext.resource.IResourceDescription;

@SuppressWarnings("all")
public class AbstractCompilationUnitDelta implements CompilationUnitDelta {
  private final String compilationUnitName;
  
  public AbstractCompilationUnitDelta(final String compilationUnitName) {
    Preconditions.<String>checkNotNull(compilationUnitName, "compilationUnitName cannot be null");
    this.compilationUnitName = compilationUnitName;
  }
  
  public String getCompilationUnitName() {
    return this.compilationUnitName;
  }
  
  public IResourceDescription getNew() {
    return null;
  }
  
  public IResourceDescription getOld() {
    return null;
  }
  
  public URI getUri() {
    return null;
  }
  
  public boolean haveEObjectDescriptionsChanged() {
    return false;
  }
}
