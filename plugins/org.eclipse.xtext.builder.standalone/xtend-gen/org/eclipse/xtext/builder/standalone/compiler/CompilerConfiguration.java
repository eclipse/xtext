/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.compiler;

import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerConfiguration {
  @Property
  private String _sourceLevel = "1.5";
  
  @Property
  private String _targetLevel = "1.5";
  
  @Property
  private boolean _verbose;
  
  @Pure
  public String getSourceLevel() {
    return this._sourceLevel;
  }
  
  public void setSourceLevel(final String sourceLevel) {
    this._sourceLevel = sourceLevel;
  }
  
  @Pure
  public String getTargetLevel() {
    return this._targetLevel;
  }
  
  public void setTargetLevel(final String targetLevel) {
    this._targetLevel = targetLevel;
  }
  
  @Pure
  public boolean isVerbose() {
    return this._verbose;
  }
  
  public void setVerbose(final boolean verbose) {
    this._verbose = verbose;
  }
}
