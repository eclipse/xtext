/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

/**
 * Convenience class for implementing generator fragments. Provides access to the
 * {@link IXtextProjectConfig project configuration} and the {@link IXtextGeneratorLanguage language configuration}.
 */
@SuppressWarnings("all")
public abstract class AbstractXtextGeneratorFragment implements IXtextGeneratorFragment {
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private IXtextGeneratorLanguage language;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private Grammar grammar;
  
  @Override
  public void checkConfiguration(final Issues issues) {
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
  }
  
  @Pure
  protected IXtextProjectConfig getProjectConfig() {
    return this.projectConfig;
  }
  
  @Pure
  protected IXtextGeneratorLanguage getLanguage() {
    return this.language;
  }
  
  @Pure
  protected Grammar getGrammar() {
    return this.grammar;
  }
}
