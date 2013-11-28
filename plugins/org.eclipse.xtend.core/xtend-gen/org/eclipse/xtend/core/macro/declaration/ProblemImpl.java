/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.macro.services.Problem;

@SuppressWarnings("all")
public class ProblemImpl implements Problem {
  private String id;
  
  private String message;
  
  private Problem.Severity severity;
  
  public ProblemImpl(final String id, final String message, final Problem.Severity severity) {
    this.id = id;
    this.message = message;
    this.severity = severity;
  }
  
  public String getId() {
    return this.id;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public Problem.Severity getSeverity() {
    return this.severity;
  }
}
