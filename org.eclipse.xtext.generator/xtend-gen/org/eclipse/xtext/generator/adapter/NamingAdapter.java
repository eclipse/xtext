/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.adapter;

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@FinalFieldsConstructor
@Deprecated
@SuppressWarnings("all")
class NamingAdapter extends XtextGeneratorNaming {
  private final Naming naming;
  
  @Override
  public String getRuntimeBasePackage(final Grammar grammar) {
    return this.naming.basePackageRuntime(grammar);
  }
  
  @Override
  public TypeReference getRuntimeModule(final Grammar grammar) {
    String _guiceModuleRt = this.naming.guiceModuleRt(grammar);
    return new TypeReference(_guiceModuleRt);
  }
  
  @Override
  public TypeReference getRuntimeGenModule(final Grammar grammar) {
    String _guiceModuleRtGenerated = this.naming.guiceModuleRtGenerated(grammar);
    return new TypeReference(_guiceModuleRtGenerated);
  }
  
  @Override
  public TypeReference getRuntimeSetup(final Grammar grammar) {
    String _setup = this.naming.setup(grammar);
    return new TypeReference(_setup);
  }
  
  @Override
  public TypeReference getRuntimeGenSetup(final Grammar grammar) {
    String _setupImpl = this.naming.setupImpl(grammar);
    return new TypeReference(_setupImpl);
  }
  
  @Override
  public String getEclipsePluginBasePackage(final Grammar grammar) {
    return this.naming.basePackageUi(grammar);
  }
  
  @Override
  public TypeReference getEclipsePluginModule(final Grammar grammar) {
    String _guiceModuleUi = this.naming.guiceModuleUi(grammar);
    return new TypeReference(_guiceModuleUi);
  }
  
  @Override
  public TypeReference getEclipsePluginGenModule(final Grammar grammar) {
    String _guiceModuleUiGenerated = this.naming.guiceModuleUiGenerated(grammar);
    return new TypeReference(_guiceModuleUiGenerated);
  }
  
  @Override
  public TypeReference getEclipsePluginExecutableExtensionFactory(final Grammar grammar) {
    String _executableExtensionFactory = this.naming.executableExtensionFactory(grammar);
    return new TypeReference(_executableExtensionFactory);
  }
  
  @Override
  public String getGenericIdeBasePackage(final Grammar grammar) {
    return this.naming.basePackageIde(grammar);
  }
  
  public NamingAdapter(final Naming naming) {
    super();
    this.naming = naming;
  }
}
