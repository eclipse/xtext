/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public String getMessage() {
    return this.message;
  }

  @Override
  public Problem.Severity getSeverity() {
    return this.severity;
  }
}
