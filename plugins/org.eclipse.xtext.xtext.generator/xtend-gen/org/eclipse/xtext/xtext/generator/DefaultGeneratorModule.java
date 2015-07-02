/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.parser.EclipseProjectPropertiesEncodingProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.XtextProjectConfig;

@SuppressWarnings("all")
public class DefaultGeneratorModule extends AbstractGenericModule {
  @Accessors
  private XtextProjectConfig project;
  
  @Accessors
  private CodeConfig code;
  
  public void configureXtextProjectConfig(final Binder binder) {
    if ((this.project == null)) {
      XtextProjectConfig _xtextProjectConfig = new XtextProjectConfig();
      this.project = _xtextProjectConfig;
    }
    AnnotatedBindingBuilder<IXtextProjectConfig> _bind = binder.<IXtextProjectConfig>bind(IXtextProjectConfig.class);
    _bind.toInstance(this.project);
  }
  
  public void configureCodeConfig(final Binder binder) {
    if ((this.code == null)) {
      CodeConfig _codeConfig = new CodeConfig();
      this.code = _codeConfig;
    }
    AnnotatedBindingBuilder<CodeConfig> _bind = binder.<CodeConfig>bind(CodeConfig.class);
    _bind.toInstance(this.code);
  }
  
  public void configureResourceSet(final Binder binder) {
    AnnotatedBindingBuilder<ResourceSet> _bind = binder.<ResourceSet>bind(ResourceSet.class);
    XtextResourceSet _xtextResourceSet = new XtextResourceSet();
    _bind.toInstance(_xtextResourceSet);
  }
  
  public Class<? extends IEncodingProvider> bindIEncodingProvider() {
    return EclipseProjectPropertiesEncodingProvider.class;
  }
  
  @Pure
  public XtextProjectConfig getProject() {
    return this.project;
  }
  
  public void setProject(final XtextProjectConfig project) {
    this.project = project;
  }
  
  @Pure
  public CodeConfig getCode() {
    return this.code;
  }
  
  public void setCode(final CodeConfig code) {
    this.code = code;
  }
}
