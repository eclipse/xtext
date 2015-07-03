/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Singleton;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@Singleton
@SuppressWarnings("all")
public class XtextGeneratorNaming {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String eclipsePluginActivator;
  
  public String getRuntimeBasePackage(final Grammar grammar) {
    return GrammarUtil.getNamespace(grammar);
  }
  
  public TypeReference getRuntimeModule(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = (_name + "RuntimeModule");
    return new TypeReference(_runtimeBasePackage, _plus);
  }
  
  public TypeReference getRuntimeGenModule(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = ("Abstract" + _name);
    String _plus_1 = (_plus + "RuntimeModule");
    return new TypeReference(_runtimeBasePackage, _plus_1);
  }
  
  public TypeReference getRuntimeDefaultModule(final Grammar grammar) {
    return new TypeReference("org.eclipse.xtext.service.DefaultRuntimeModule");
  }
  
  public TypeReference getRuntimeSetup(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = (_name + "StandaloneSetup");
    return new TypeReference(_runtimeBasePackage, _plus);
  }
  
  public TypeReference getRuntimeGenSetup(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = (_name + "StandaloneSetupGenerated");
    return new TypeReference(_runtimeBasePackage, _plus);
  }
  
  public String getEclipsePluginBasePackage(final Grammar grammar) {
    String _namespace = GrammarUtil.getNamespace(grammar);
    return (_namespace + ".ui");
  }
  
  public TypeReference getEclipsePluginModule(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = (_name + "UiModule");
    return new TypeReference(_eclipsePluginBasePackage, _plus);
  }
  
  public TypeReference getEclipsePluginGenModule(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = ("Abstract" + _name);
    String _plus_1 = (_plus + "UiModule");
    return new TypeReference(_eclipsePluginBasePackage, _plus_1);
  }
  
  public TypeReference getEclipsePluginDefaultModule(final Grammar grammar) {
    return new TypeReference("org.eclipse.xtext.ui.DefaultUiModule");
  }
  
  public TypeReference getEclipsePluginExecutableExtensionFactory(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = (_name + "ExecutableExtensionFactory");
    return new TypeReference(_eclipsePluginBasePackage, _plus);
  }
  
  public TypeReference getEclipsePluginActivator(final Grammar grammar) {
    if ((this.eclipsePluginActivator == null)) {
      String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
      String _plus = (_eclipsePluginBasePackage + ".internal.");
      String _name = GrammarUtil.getName(grammar);
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + "Activator");
      this.eclipsePluginActivator = _plus_2;
    }
    return new TypeReference(this.eclipsePluginActivator);
  }
  
  public void setEclipsePluginActivator(final String eclipsePluginActivator) {
    this.eclipsePluginActivator = eclipsePluginActivator;
  }
}
