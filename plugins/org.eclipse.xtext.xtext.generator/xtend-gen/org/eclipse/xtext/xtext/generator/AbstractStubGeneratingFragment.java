/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;

@SuppressWarnings("all")
public abstract class AbstractStubGeneratingFragment extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private CodeConfig _codeConfig;
  
  @Accessors
  private boolean generateStub = true;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private Boolean generateXtendStub = null;
  
  public boolean generateXtendStub() {
    boolean _xifexpression = false;
    boolean _notEquals = (!Objects.equal(this.generateXtendStub, null));
    if (_notEquals) {
      _xifexpression = this.generateXtendStub.booleanValue();
    } else {
      _xifexpression = this._codeConfig.isPreferXtendStubs();
    }
    return _xifexpression;
  }
  
  @Pure
  public boolean isGenerateStub() {
    return this.generateStub;
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this.generateStub = generateStub;
  }
  
  public void setGenerateXtendStub(final Boolean generateXtendStub) {
    this.generateXtendStub = generateXtendStub;
  }
}
