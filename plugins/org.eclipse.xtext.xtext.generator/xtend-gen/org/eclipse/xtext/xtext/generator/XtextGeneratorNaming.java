/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class XtextGeneratorNaming {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String eclipsePluginActivator;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String runtimeBasePackage;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String eclipsePluginBasePackage;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String genericIdeBasePackage;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String ideaBasePackage;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String webBasePackage;
  
  private Grammar myGrammar;
  
  Grammar setGrammar(final Grammar grammar) {
    return this.myGrammar = grammar;
  }
  
  public String getRuntimeBasePackage(final Grammar grammar) {
    boolean _or = false;
    boolean _notEquals = (!Objects.equal(grammar, this.myGrammar));
    if (_notEquals) {
      _or = true;
    } else {
      _or = (this.runtimeBasePackage == null);
    }
    if (_or) {
      return GrammarUtil.getNamespace(grammar);
    }
    return this.runtimeBasePackage;
  }
  
  public TypeReference getRuntimeModule(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "RuntimeModule");
    return new TypeReference(_runtimeBasePackage, _plus);
  }
  
  public TypeReference getRuntimeGenModule(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "RuntimeModule");
    return new TypeReference(_runtimeBasePackage, _plus_1);
  }
  
  public TypeReference getRuntimeDefaultModule(final Grammar grammar) {
    return new TypeReference("org.eclipse.xtext.service.DefaultRuntimeModule");
  }
  
  public TypeReference getRuntimeSetup(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "StandaloneSetup");
    return new TypeReference(_runtimeBasePackage, _plus);
  }
  
  public TypeReference getRuntimeGenSetup(final Grammar grammar) {
    String _runtimeBasePackage = this.getRuntimeBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "StandaloneSetupGenerated");
    return new TypeReference(_runtimeBasePackage, _plus);
  }
  
  public String getEclipsePluginBasePackage(final Grammar grammar) {
    boolean _or = false;
    boolean _notEquals = (!Objects.equal(grammar, this.myGrammar));
    if (_notEquals) {
      _or = true;
    } else {
      _or = (this.eclipsePluginBasePackage == null);
    }
    if (_or) {
      String _namespace = GrammarUtil.getNamespace(grammar);
      return (_namespace + ".ui");
    }
    return this.eclipsePluginBasePackage;
  }
  
  public TypeReference getEclipsePluginModule(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "UiModule");
    return new TypeReference(_eclipsePluginBasePackage, _plus);
  }
  
  public TypeReference getEclipsePluginGenModule(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "UiModule");
    return new TypeReference(_eclipsePluginBasePackage, _plus_1);
  }
  
  public TypeReference getEclipsePluginDefaultModule(final Grammar grammar) {
    return new TypeReference("org.eclipse.xtext.ui.DefaultUiModule");
  }
  
  public TypeReference getEclipsePluginExecutableExtensionFactory(final Grammar grammar) {
    String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "ExecutableExtensionFactory");
    return new TypeReference(_eclipsePluginBasePackage, _plus);
  }
  
  public TypeReference getEclipsePluginActivator(final Grammar grammar) {
    boolean _or = false;
    boolean _notEquals = (!Objects.equal(grammar, this.myGrammar));
    if (_notEquals) {
      _or = true;
    } else {
      _or = (this.eclipsePluginActivator == null);
    }
    if (_or) {
      String _eclipsePluginBasePackage = this.getEclipsePluginBasePackage(grammar);
      String _plus = (_eclipsePluginBasePackage + ".internal");
      String _simpleName = GrammarUtil.getSimpleName(grammar);
      String _plus_1 = (_simpleName + "Activator");
      return new TypeReference(_plus, _plus_1);
    }
    return new TypeReference(this.eclipsePluginActivator);
  }
  
  public String getGenericIdeBasePackage(final Grammar grammar) {
    boolean _or = false;
    boolean _notEquals = (!Objects.equal(grammar, this.myGrammar));
    if (_notEquals) {
      _or = true;
    } else {
      _or = (this.genericIdeBasePackage == null);
    }
    if (_or) {
      String _namespace = GrammarUtil.getNamespace(grammar);
      return (_namespace + ".ide");
    }
    return this.genericIdeBasePackage;
  }
  
  public TypeReference getGenericIdeModule(final Grammar grammar) {
    String _genericIdeBasePackage = this.getGenericIdeBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "IdeModule");
    return new TypeReference(_genericIdeBasePackage, _plus);
  }
  
  public TypeReference getGenericIdeGenModule(final Grammar grammar) {
    String _genericIdeBasePackage = this.getGenericIdeBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "IdeModule");
    return new TypeReference(_genericIdeBasePackage, _plus_1);
  }
  
  public String getIdeaBasePackage(final Grammar grammar) {
    boolean _or = false;
    boolean _notEquals = (!Objects.equal(grammar, this.myGrammar));
    if (_notEquals) {
      _or = true;
    } else {
      _or = (this.ideaBasePackage == null);
    }
    if (_or) {
      String _namespace = GrammarUtil.getNamespace(grammar);
      return (_namespace + ".idea");
    }
    return this.ideaBasePackage;
  }
  
  public TypeReference getIdeaModule(final Grammar grammar) {
    String _ideaBasePackage = this.getIdeaBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "IdeaModule");
    return new TypeReference(_ideaBasePackage, _plus);
  }
  
  public TypeReference getIdeaDefaultModule(final Grammar grammar) {
    return new TypeReference("org.eclipse.xtext.idea.DefaultIdeaModule");
  }
  
  public TypeReference getIdeaGenModule(final Grammar grammar) {
    String _ideaBasePackage = this.getIdeaBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "IdeaModule");
    return new TypeReference(_ideaBasePackage, _plus_1);
  }
  
  public TypeReference getIdeaStandaloneSetup(final Grammar grammar) {
    String _ideaBasePackage = this.getIdeaBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "StandaloneSetupIdea");
    return new TypeReference(_ideaBasePackage, _plus);
  }
  
  public String getWebBasePackage(final Grammar grammar) {
    boolean _or = false;
    boolean _notEquals = (!Objects.equal(grammar, this.myGrammar));
    if (_notEquals) {
      _or = true;
    } else {
      _or = (this.webBasePackage == null);
    }
    if (_or) {
      String _namespace = GrammarUtil.getNamespace(grammar);
      return (_namespace + ".web");
    }
    return this.webBasePackage;
  }
  
  public TypeReference getWebModule(final Grammar grammar) {
    String _webBasePackage = this.getWebBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "WebModule");
    return new TypeReference(_webBasePackage, _plus);
  }
  
  public TypeReference getWebDefaultModule(final Grammar grammar) {
    return new TypeReference("org.eclipse.xtext.web.server.DefaultWebModule");
  }
  
  public TypeReference getWebGenModule(final Grammar grammar) {
    String _webBasePackage = this.getWebBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "WebModule");
    return new TypeReference(_webBasePackage, _plus_1);
  }
  
  public TypeReference getWebSetup(final Grammar grammar) {
    String _webBasePackage = this.getWebBasePackage(grammar);
    String _simpleName = GrammarUtil.getSimpleName(grammar);
    String _plus = (_simpleName + "WebSetup");
    return new TypeReference(_webBasePackage, _plus);
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
  
  public void setIdeaBasePackage(final String ideaBasePackage) {
    this.ideaBasePackage = ideaBasePackage;
  }
  
  public void setWebBasePackage(final String webBasePackage) {
    this.webBasePackage = webBasePackage;
  }
}
