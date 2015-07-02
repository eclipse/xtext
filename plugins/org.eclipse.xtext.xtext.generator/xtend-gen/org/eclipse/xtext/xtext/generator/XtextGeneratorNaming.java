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

@Singleton
@SuppressWarnings("all")
public class XtextGeneratorNaming {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String eclipsePluginActivator;
  
  public String getPackage(final String qualifiedName) {
    int _lastIndexOf = qualifiedName.lastIndexOf(".");
    return qualifiedName.substring(0, _lastIndexOf);
  }
  
  public String getSimple(final String qualifiedName) {
    int _lastIndexOf = qualifiedName.lastIndexOf(".");
    return qualifiedName.substring(_lastIndexOf);
  }
  
  public String getRuntimeBasePackage(final Grammar grammar) {
    return GrammarUtil.getNamespace(grammar);
  }
  
  public String getRuntimeModule(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".");
    String _name = GrammarUtil.getName(grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "RuntimeModule");
  }
  
  public String getRuntimeGenModule(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".Abstract");
    String _name = GrammarUtil.getName(grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "RuntimeModule");
  }
  
  public String getRuntimeDefaultModule(final Grammar grammar) {
    return "org.eclipse.xtext.service.DefaultRuntimeModule";
  }
  
  public String getRuntimeSetup(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".");
    String _name = GrammarUtil.getName(grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "StandaloneSetup");
  }
  
  public String getRuntimeGenSetup(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + ".");
    String _name = GrammarUtil.getName(grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "StandaloneSetupGenerated");
  }
  
  public String getEclipsePluginBasePackage(final Grammar grammar) {
    String _namespace = GrammarUtil.getNamespace(grammar);
    return (_namespace + ".ui");
  }
  
  public String getEclipsePluginModule(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _plus = (_eclipsePluginBasePackage + ".");
    String _name = GrammarUtil.getName(grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "UiModule");
  }
  
  public String getEclipsePluginGenModule(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _plus = (_eclipsePluginBasePackage + ".");
    String _plus_1 = (_plus + "Abstract");
    String _name = GrammarUtil.getName(grammar);
    String _plus_2 = (_plus_1 + _name);
    return (_plus_2 + "UiModule");
  }
  
  public String getEclipsePluginDefaultModule(final Grammar grammar) {
    return "org.eclipse.xtext.ui.DefaultUiModule";
  }
  
  public String getEclipsePluginExecutableExtensionFactory(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _plus = (_eclipsePluginBasePackage + ".");
    String _name = GrammarUtil.getName(grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "ExecutableExtensionFactory");
  }
  
  public String getEclipsePluginActivator(final Grammar grammar) {
    if ((this.eclipsePluginActivator == null)) {
      String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
      String _plus = (_eclipsePluginBasePackage + ".internal.");
      String _name = GrammarUtil.getName(grammar);
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + "Activator");
      this.eclipsePluginActivator = _plus_2;
    }
    return this.eclipsePluginActivator;
  }
  
  public void setEclipsePluginActivator(final String eclipsePluginActivator) {
    this.eclipsePluginActivator = eclipsePluginActivator;
  }
}
