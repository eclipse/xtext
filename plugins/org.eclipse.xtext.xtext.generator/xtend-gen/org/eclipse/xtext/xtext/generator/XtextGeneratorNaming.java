/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;

@SuppressWarnings("all")
public class XtextGeneratorNaming {
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
    String _name = GrammarUtil.getName(grammar);
    String _plus = (_runtimeBasePackage + _name);
    return (_plus + "RuntimeModule");
  }
  
  public String getRuntimeGenModule(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _plus = (_runtimeBasePackage + "Abstract");
    String _name = GrammarUtil.getName(grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "RuntimeModule");
  }
  
  public String getRuntimeDefaultModule(final Grammar grammar) {
    return "org.eclipse.xtext.service.DefaultRuntimeModule";
  }
  
  public String getRuntimeSetup(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = (_runtimeBasePackage + _name);
    return (_plus + "StandaloneSetup");
  }
  
  public String getRuntimeGenSetup(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = (_runtimeBasePackage + _name);
    return (_plus + "StandaloneSetupGenerated");
  }
  
  public String getEclipsePluginBasePackage(final Grammar grammar) {
    String _namespace = GrammarUtil.getNamespace(grammar);
    return (_namespace + ".ui");
  }
  
  public String getEclipsePluginModule(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _name = GrammarUtil.getName(grammar);
    String _plus = (_eclipsePluginBasePackage + _name);
    return (_plus + "UiModule");
  }
  
  public String getEclipsePluginGenModule(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _plus = (_eclipsePluginBasePackage + "Abstract");
    String _name = GrammarUtil.getName(grammar);
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "UiModule");
  }
  
  public String getEclipsePluginDefaultModule(final Grammar grammar) {
    return "org.eclipse.xtext.ui.DefaultUiModule";
  }
}
