/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.Issues;

/**
 * Generator fragment that wraps another fragment and can be toggled via a property
 * 
 * @author Christian Dietrich - Initial contribution and API
 * 
 * @since 2.13
 */
@SuppressWarnings("all")
public class ConditionalXtextGeneratorFragment implements IXtextGeneratorFragment {
  @Accessors
  private IXtextGeneratorFragment fragment;
  
  @Accessors
  private boolean enabled = true;
  
  @Override
  public void checkConfiguration(final Issues issues) {
    if ((this.fragment == null)) {
      issues.addError("The property \'fragment\' must be set.", this);
    } else {
      this.fragment.checkConfiguration(issues);
    }
  }
  
  @Override
  public void generate() {
    if (this.enabled) {
      this.fragment.generate();
    }
  }
  
  @Override
  public void initialize(final Injector injector) {
    this.fragment.initialize(injector);
  }
  
  @Pure
  public IXtextGeneratorFragment getFragment() {
    return this.fragment;
  }
  
  public void setFragment(final IXtextGeneratorFragment fragment) {
    this.fragment = fragment;
  }
  
  @Pure
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }
}
