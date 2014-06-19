/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractExecutableBuilder;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractMethodBuilder extends AbstractExecutableBuilder {
  @Property
  private String _methodName;
  
  @Property
  private LightweightTypeReference _returnType;
  
  @Property
  private boolean _staticFlag;
  
  @Property
  private boolean _abstractFlag;
  
  @Property
  private boolean _overrideFlag;
  
  @Pure
  public String getMethodName() {
    return this._methodName;
  }
  
  public void setMethodName(final String methodName) {
    this._methodName = methodName;
  }
  
  @Pure
  public LightweightTypeReference getReturnType() {
    return this._returnType;
  }
  
  public void setReturnType(final LightweightTypeReference returnType) {
    this._returnType = returnType;
  }
  
  @Pure
  public boolean isStaticFlag() {
    return this._staticFlag;
  }
  
  public void setStaticFlag(final boolean staticFlag) {
    this._staticFlag = staticFlag;
  }
  
  @Pure
  public boolean isAbstractFlag() {
    return this._abstractFlag;
  }
  
  public void setAbstractFlag(final boolean abstractFlag) {
    this._abstractFlag = abstractFlag;
  }
  
  @Pure
  public boolean isOverrideFlag() {
    return this._overrideFlag;
  }
  
  public void setOverrideFlag(final boolean overrideFlag) {
    this._overrideFlag = overrideFlag;
  }
}
