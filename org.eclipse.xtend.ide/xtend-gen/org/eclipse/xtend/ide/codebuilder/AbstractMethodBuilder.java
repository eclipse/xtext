/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractMethodBuilder extends AbstractExecutableBuilder {
  @Accessors
  private String methodName;

  @Accessors
  private LightweightTypeReference returnType;

  @Accessors
  private boolean staticFlag;

  @Accessors
  private boolean abstractFlag;

  @Accessors
  private boolean overrideFlag;

  @Accessors
  private boolean synchronizedFlag;

  @Pure
  public String getMethodName() {
    return this.methodName;
  }

  public void setMethodName(final String methodName) {
    this.methodName = methodName;
  }

  @Pure
  public LightweightTypeReference getReturnType() {
    return this.returnType;
  }

  public void setReturnType(final LightweightTypeReference returnType) {
    this.returnType = returnType;
  }

  @Pure
  public boolean isStaticFlag() {
    return this.staticFlag;
  }

  public void setStaticFlag(final boolean staticFlag) {
    this.staticFlag = staticFlag;
  }

  @Pure
  public boolean isAbstractFlag() {
    return this.abstractFlag;
  }

  public void setAbstractFlag(final boolean abstractFlag) {
    this.abstractFlag = abstractFlag;
  }

  @Pure
  public boolean isOverrideFlag() {
    return this.overrideFlag;
  }

  public void setOverrideFlag(final boolean overrideFlag) {
    this.overrideFlag = overrideFlag;
  }

  @Pure
  public boolean isSynchronizedFlag() {
    return this.synchronizedFlag;
  }

  public void setSynchronizedFlag(final boolean synchronizedFlag) {
    this.synchronizedFlag = synchronizedFlag;
  }
}
