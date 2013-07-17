/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractExecutableBuilder;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractMethodBuilder extends AbstractExecutableBuilder {
  private String _methodName;
  
  public String getMethodName() {
    return this._methodName;
  }
  
  public void setMethodName(final String methodName) {
    this._methodName = methodName;
  }
  
  private JvmTypeReference _returnType;
  
  public JvmTypeReference getReturnType() {
    return this._returnType;
  }
  
  public void setReturnType(final JvmTypeReference returnType) {
    this._returnType = returnType;
  }
  
  private boolean _staticFlag;
  
  public boolean isStaticFlag() {
    return this._staticFlag;
  }
  
  public void setStaticFlag(final boolean staticFlag) {
    this._staticFlag = staticFlag;
  }
  
  private boolean _abstractFlag;
  
  public boolean isAbstractFlag() {
    return this._abstractFlag;
  }
  
  public void setAbstractFlag(final boolean abstractFlag) {
    this._abstractFlag = abstractFlag;
  }
  
  private boolean _overrideFlag;
  
  public boolean isOverrideFlag() {
    return this._overrideFlag;
  }
  
  public void setOverrideFlag(final boolean overrideFlag) {
    this._overrideFlag = overrideFlag;
  }
}
