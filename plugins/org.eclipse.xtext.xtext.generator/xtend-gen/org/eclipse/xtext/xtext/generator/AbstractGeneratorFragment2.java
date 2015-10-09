/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;

@SuppressWarnings("all")
public abstract class AbstractGeneratorFragment2 implements IGeneratorFragment2 {
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private XtextProjectConfig projectConfig;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Inject
  private ILanguageConfig language;
  
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
  protected XtextProjectConfig getProjectConfig() {
    return this.projectConfig;
  }
  
  @Pure
  protected ILanguageConfig getLanguage() {
    return this.language;
  }
  
  @Pure
  protected Grammar getGrammar() {
    return this.grammar;
  }
}
