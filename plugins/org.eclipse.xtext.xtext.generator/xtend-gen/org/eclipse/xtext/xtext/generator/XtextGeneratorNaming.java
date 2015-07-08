/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@Singleton
@SuppressWarnings("all")
public class XtextGeneratorNaming {
  private final static Map<String, XtextGeneratorNaming> registry = CollectionLiterals.<String, XtextGeneratorNaming>newHashMap();
  
  public static XtextGeneratorNaming naming(final Grammar g) {
    synchronized (XtextGeneratorNaming.registry) {
      String _name = g.getName();
      boolean _containsKey = XtextGeneratorNaming.registry.containsKey(_name);
      if (_containsKey) {
        String _name_1 = g.getName();
        return XtextGeneratorNaming.registry.get(_name_1);
      }
    }
    final XtextGeneratorNaming naming = new XtextGeneratorNaming();
    naming.setGrammar(g);
    return naming;
  }
  
  private Grammar grammar;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String eclipsePluginActivator;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String runtimeBasePackage;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String eclipsePluginBasePackage;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String genericIdeBasePackage;
  
  protected void setGrammar(final Grammar grammar) {
    this.grammar = grammar;
    synchronized (XtextGeneratorNaming.registry) {
      String _name = grammar.getName();
      XtextGeneratorNaming.registry.put(_name, this);
    }
  }
  
  public String getRuntimeBasePackage() {
    if ((this.runtimeBasePackage == null)) {
      String _namespace = GrammarUtil.getNamespace(this.grammar);
      this.runtimeBasePackage = _namespace;
    }
    return this.runtimeBasePackage;
  }
  
  public TypeReference getRuntimeModule() {
    String _runtimeBasePackage = this.getRuntimeBasePackage();
    String _name = GrammarUtil.getName(this.grammar);
    String _plus = (_name + "RuntimeModule");
    return new TypeReference(_runtimeBasePackage, _plus);
  }
  
  public TypeReference getRuntimeGenModule() {
    String _runtimeBasePackage = this.getRuntimeBasePackage();
    String _name = GrammarUtil.getName(this.grammar);
    String _plus = ("Abstract" + _name);
    String _plus_1 = (_plus + "RuntimeModule");
    return new TypeReference(_runtimeBasePackage, _plus_1);
  }
  
  public TypeReference getRuntimeDefaultModule() {
    return new TypeReference("org.eclipse.xtext.service.DefaultRuntimeModule");
  }
  
  public TypeReference getRuntimeSetup() {
    String _runtimeBasePackage = this.getRuntimeBasePackage();
    String _name = GrammarUtil.getName(this.grammar);
    String _plus = (_name + "StandaloneSetup");
    return new TypeReference(_runtimeBasePackage, _plus);
  }
  
  public TypeReference getRuntimeGenSetup() {
    String _runtimeBasePackage = this.getRuntimeBasePackage();
    String _name = GrammarUtil.getName(this.grammar);
    String _plus = (_name + "StandaloneSetupGenerated");
    return new TypeReference(_runtimeBasePackage, _plus);
  }
  
  public String getEclipsePluginBasePackage() {
    if ((this.eclipsePluginBasePackage == null)) {
      String _namespace = GrammarUtil.getNamespace(this.grammar);
      String _plus = (_namespace + ".ui");
      this.eclipsePluginBasePackage = _plus;
    }
    return this.eclipsePluginBasePackage;
  }
  
  public TypeReference getEclipsePluginModule() {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage();
    String _name = GrammarUtil.getName(this.grammar);
    String _plus = (_name + "UiModule");
    return new TypeReference(_eclipsePluginBasePackage, _plus);
  }
  
  public TypeReference getEclipsePluginGenModule() {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage();
    String _name = GrammarUtil.getName(this.grammar);
    String _plus = ("Abstract" + _name);
    String _plus_1 = (_plus + "UiModule");
    return new TypeReference(_eclipsePluginBasePackage, _plus_1);
  }
  
  public TypeReference getEclipsePluginDefaultModule() {
    return new TypeReference("org.eclipse.xtext.ui.DefaultUiModule");
  }
  
  public TypeReference getEclipsePluginExecutableExtensionFactory() {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage();
    String _name = GrammarUtil.getName(this.grammar);
    String _plus = (_name + "ExecutableExtensionFactory");
    return new TypeReference(_eclipsePluginBasePackage, _plus);
  }
  
  public TypeReference getEclipsePluginActivator() {
    if ((this.eclipsePluginActivator == null)) {
      String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage();
      String _plus = (_eclipsePluginBasePackage + ".internal.");
      String _name = GrammarUtil.getName(this.grammar);
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + "Activator");
      this.eclipsePluginActivator = _plus_2;
    }
    return new TypeReference(this.eclipsePluginActivator);
  }
  
  public String getGenericIdeBasePackage() {
    if ((this.genericIdeBasePackage == null)) {
      String _namespace = GrammarUtil.getNamespace(this.grammar);
      String _plus = (_namespace + ".ide");
      this.genericIdeBasePackage = _plus;
    }
    return this.genericIdeBasePackage;
  }
  
  public TypeReference getGenericIdeModule() {
    String _genericIdeBasePackage = this.getGenericIdeBasePackage();
    String _name = GrammarUtil.getName(this.grammar);
    String _plus = (_name + "IdeModule");
    return new TypeReference(_genericIdeBasePackage, _plus);
  }
  
  public TypeReference getGenericIdeGenModule() {
    String _genericIdeBasePackage = this.getGenericIdeBasePackage();
    String _name = GrammarUtil.getName(this.grammar);
    String _plus = ("Abstract" + _name);
    String _plus_1 = (_plus + "IdeModule");
    return new TypeReference(_genericIdeBasePackage, _plus_1);
  }
  
  public void setEclipsePluginActivator(final String eclipsePluginActivator) {
    this.eclipsePluginActivator = eclipsePluginActivator;
  }
  
  public void setRuntimeBasePackage(final String runtimeBasePackage) {
    this.runtimeBasePackage = runtimeBasePackage;
  }
  
  public void setEclipsePluginBasePackage(final String eclipsePluginBasePackage) {
    this.eclipsePluginBasePackage = eclipsePluginBasePackage;
  }
  
  public void setGenericIdeBasePackage(final String genericIdeBasePackage) {
    this.genericIdeBasePackage = genericIdeBasePackage;
  }
}
