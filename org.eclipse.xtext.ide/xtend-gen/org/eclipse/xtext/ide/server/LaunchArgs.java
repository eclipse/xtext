/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class LaunchArgs {
  private InputStream in;
  
  private OutputStream out;
  
  private PrintWriter trace;
  
  private boolean validate;
  
  @Pure
  public InputStream getIn() {
    return this.in;
  }
  
  public void setIn(final InputStream in) {
    this.in = in;
  }
  
  @Pure
  public OutputStream getOut() {
    return this.out;
  }
  
  public void setOut(final OutputStream out) {
    this.out = out;
  }
  
  @Pure
  public PrintWriter getTrace() {
    return this.trace;
  }
  
  public void setTrace(final PrintWriter trace) {
    this.trace = trace;
  }
  
  @Pure
  public boolean isValidate() {
    return this.validate;
  }
  
  public void setValidate(final boolean validate) {
    this.validate = validate;
  }
}
