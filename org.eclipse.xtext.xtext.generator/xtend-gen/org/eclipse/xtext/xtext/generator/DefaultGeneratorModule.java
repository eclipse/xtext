/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.XtextProjectConfig;

/**
 * An instance of this module is assigned to the {@code configuration} property of
 * {@link XtextGenerator}. It contains the {@link XtextProjectConfig project configuration}
 * and the {@link CodeConfig code configuration}. If you need to configure more aspects of
 * the generator, create a subclass and bind your custom configuration classes. For example,
 * in order to adapt the {@link XtextGeneratorNaming naming} of the generated code, use
 * the following:
 * <pre>
 * class MyGeneratorModule extends DefaultGeneratorModule {
 *     def Class&lt;? extends XtextGeneratorNaming&gt; bindXtextGeneratorNaming() {
 *         MyGeneratorNaming
 *     }
 * }
 * </pre>
 */
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
    binder.<IXtextProjectConfig>bind(IXtextProjectConfig.class).toInstance(this.project);
  }
  
  public void configureCodeConfig(final Binder binder) {
    binder.<CodeConfig>bind(CodeConfig.class).toInstance(this.code);
  }
  
  public void configureResourceSet(final Binder binder) {
    binder.<ResourceSet>bind(ResourceSet.class).to(XtextResourceSet.class);
  }
  
  public void configureLineSeparatorInformation(final Binder binder) {
    final ILineSeparatorInformation _function = () -> {
      return this.code.getLineDelimiter();
    };
    binder.<ILineSeparatorInformation>bind(ILineSeparatorInformation.class).toInstance(_function);
  }
  
  public void configureIEncodingProvider(final Binder binder) {
    AnnotatedBindingBuilder<IEncodingProvider> _bind = binder.<IEncodingProvider>bind(IEncodingProvider.class);
    IEncodingProvider.Runtime _runtime = new IEncodingProvider.Runtime();
    final Procedure1<IEncodingProvider.Runtime> _function = (IEncodingProvider.Runtime it) -> {
      it.setDefaultEncoding(this.code.getEncoding());
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
