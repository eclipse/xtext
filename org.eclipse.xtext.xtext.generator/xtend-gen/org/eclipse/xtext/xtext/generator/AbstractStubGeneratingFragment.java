/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Inject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.util.BooleanGeneratorOption;

@SuppressWarnings("all")
public abstract class AbstractStubGeneratingFragment extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private CodeConfig _codeConfig;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final BooleanGeneratorOption generateStub = new BooleanGeneratorOption(true);
  
  private final BooleanGeneratorOption generateXtendStub = new BooleanGeneratorOption();
  
  public boolean isGenerateStub() {
    return this.generateStub.get();
  }
  
  public void setGenerateStub(final boolean generateStub) {
    this.generateStub.set(generateStub);
  }
  
  public boolean isGenerateXtendStub() {
    boolean _xifexpression = false;
    boolean _isSet = this.generateXtendStub.isSet();
    if (_isSet) {
      _xifexpression = this.generateXtendStub.get();
    } else {
      _xifexpression = this._codeConfig.isPreferXtendStubs();
    }
    return _xifexpression;
  }
  
  public void setGenerateXtendStub(final boolean generateXtendStub) {
    this.generateXtendStub.set(generateXtendStub);
  }
  
  @Pure
  public BooleanGeneratorOption getGenerateStub() {
    return this.generateStub;
  }
}
