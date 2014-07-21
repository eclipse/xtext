/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.compiler;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class CompilerConfiguration {
  private String sourceLevel = "1.5";
  
  private String targetLevel = "1.5";
  
  private boolean verbose;
  
  @Pure
  public String getSourceLevel() {
    return this.sourceLevel;
  }
  
  public void setSourceLevel(final String sourceLevel) {
    this.sourceLevel = sourceLevel;
  }
  
  @Pure
  public String getTargetLevel() {
    return this.targetLevel;
  }
  
  public void setTargetLevel(final String targetLevel) {
    this.targetLevel = targetLevel;
  }
  
  @Pure
  public boolean isVerbose() {
    return this.verbose;
  }
  
  public void setVerbose(final boolean verbose) {
    this.verbose = verbose;
  }
}
