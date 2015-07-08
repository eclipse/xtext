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
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.WizardConfig;
import org.eclipse.xtext.xtext.generator.XtextGenerator;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;

@SuppressWarnings("all")
public class DefaultGeneratorModule extends AbstractGenericModule {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private XtextProjectConfig project;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private CodeConfig code;
  
  public XtextProjectConfig getProject() {
    if ((this.project == null)) {
      WizardConfig _wizardConfig = new WizardConfig();
      this.project = _wizardConfig;
    }
    return this.project;
  }
  
  public CodeConfig getCode() {
    if ((this.code == null)) {
      CodeConfig _codeConfig = new CodeConfig();
      this.code = _codeConfig;
    }
    return this.code;
  }
  
  protected void checkConfiguration(final XtextGenerator generator, final Issues issues) {
    XtextProjectConfig _project = this.getProject();
    _project.checkConfiguration(generator, issues);
  }
  
  public void configureXtextProjectConfig(final Binder binder) {
    AnnotatedBindingBuilder<IXtextProjectConfig> _bind = binder.<IXtextProjectConfig>bind(IXtextProjectConfig.class);
    XtextProjectConfig _project = this.getProject();
    _bind.toInstance(_project);
  }
  
  public void configureCodeConfig(final Binder binder) {
    AnnotatedBindingBuilder<CodeConfig> _bind = binder.<CodeConfig>bind(CodeConfig.class);
    CodeConfig _code = this.getCode();
    _bind.toInstance(_code);
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
        CodeConfig _code = DefaultGeneratorModule.this.getCode();
        String _encoding = _code.getEncoding();
        it.setDefaultEncoding(_encoding);
      }
    };
    IEncodingProvider.Runtime _doubleArrow = ObjectExtensions.<IEncodingProvider.Runtime>operator_doubleArrow(_runtime, _function);
    _bind.toInstance(_doubleArrow);
  }
  
  public void setProject(final XtextProjectConfig project) {
    this.project = project;
  }
  
  public void setCode(final CodeConfig code) {
    this.code = code;
  }
}
