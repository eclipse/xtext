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
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.StandardProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;

@SuppressWarnings("all")
public class DefaultGeneratorModule extends AbstractGenericModule {
  @Accessors
  private XtextProjectConfig project = new StandardProjectConfig();
  
  @Accessors
  private CodeConfig code = new CodeConfig();
  
  protected void checkConfiguration(final Issues issues) {
    this.project.checkConfiguration(issues);
  }
  
  public void configureXtextProjectConfig(final Binder binder) {
    AnnotatedBindingBuilder<IXtextProjectConfig> _bind = binder.<IXtextProjectConfig>bind(IXtextProjectConfig.class);
    _bind.toInstance(this.project);
  }
  
  public void configureCodeConfig(final Binder binder) {
    AnnotatedBindingBuilder<CodeConfig> _bind = binder.<CodeConfig>bind(CodeConfig.class);
    _bind.toInstance(this.code);
  }
  
  public void configureResourceSet(final Binder binder) {
    AnnotatedBindingBuilder<ResourceSet> _bind = binder.<ResourceSet>bind(ResourceSet.class);
    _bind.to(XtextResourceSet.class);
  }
  
  public void configureIEncodingProvider(final Binder binder) {
    AnnotatedBindingBuilder<IEncodingProvider> _bind = binder.<IEncodingProvider>bind(IEncodingProvider.class);
    IEncodingProvider.Runtime _runtime = new IEncodingProvider.Runtime();
    final Procedure1<IEncodingProvider.Runtime> _function = new Procedure1<IEncodingProvider.Runtime>() {
      @Override
      public void apply(final IEncodingProvider.Runtime it) {
        String _encoding = DefaultGeneratorModule.this.code.getEncoding();
        it.setDefaultEncoding(_encoding);
      }
    };
    IEncodingProvider.Runtime _doubleArrow = ObjectExtensions.<IEncodingProvider.Runtime>operator_doubleArrow(_runtime, _function);
    _bind.toInstance(_doubleArrow);
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
