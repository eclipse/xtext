/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone;

import com.google.inject.AbstractModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.compiler.EclipseJavaCompiler;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class StandaloneBuilderModule extends AbstractModule {
  protected void configure() {
    AnnotatedBindingBuilder<IResourceDescriptions> _bind = this.<IResourceDescriptions>bind(IResourceDescriptions.class);
    Named _named = Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE);
    LinkedBindingBuilder<IResourceDescriptions> _annotatedWith = _bind.annotatedWith(_named);
    _annotatedWith.to(
      ResourceSetBasedResourceDescriptions.class);
    AnnotatedBindingBuilder<IResourceDescriptions> _bind_1 = this.<IResourceDescriptions>bind(IResourceDescriptions.class);
    Named _named_1 = Names.named(ResourceDescriptionsProvider.LIVE_SCOPE);
    LinkedBindingBuilder<IResourceDescriptions> _annotatedWith_1 = _bind_1.annotatedWith(_named_1);
    _annotatedWith_1.to(
      ResourceSetBasedResourceDescriptions.class);
    AnnotatedBindingBuilder<IResourceDescriptions> _bind_2 = this.<IResourceDescriptions>bind(IResourceDescriptions.class);
    _bind_2.to(ResourceSetBasedResourceDescriptions.class);
    AnnotatedBindingBuilder<IIssueHandler> _bind_3 = this.<IIssueHandler>bind(IIssueHandler.class);
    Class<? extends IIssueHandler> _bindIIssueHandler = this.bindIIssueHandler();
    _bind_3.to(_bindIIssueHandler);
    AnnotatedBindingBuilder<AbstractFileSystemAccess> _bind_4 = this.<AbstractFileSystemAccess>bind(AbstractFileSystemAccess.class);
    Class<JavaIoFileSystemAccess> _bindJavaIoFileSystemAccess = this.bindJavaIoFileSystemAccess();
    _bind_4.to(_bindJavaIoFileSystemAccess);
    AnnotatedBindingBuilder<IJavaCompiler> _bind_5 = this.<IJavaCompiler>bind(IJavaCompiler.class);
    Class<EclipseJavaCompiler> _bindIJavaCompiler = this.bindIJavaCompiler();
    _bind_5.to(_bindIJavaCompiler);
    AnnotatedBindingBuilder<IEncodingProvider> _bind_6 = this.<IEncodingProvider>bind(IEncodingProvider.class);
    Class<? extends IEncodingProvider> _bindIEncodingProvider = this.bindIEncodingProvider();
    _bind_6.to(_bindIEncodingProvider);
  }
  
  public Class<EclipseJavaCompiler> bindIJavaCompiler() {
    return EclipseJavaCompiler.class;
  }
  
  protected Class<? extends IIssueHandler> bindIIssueHandler() {
    return IIssueHandler.DefaultIssueHandler.class;
  }
  
  protected Class<JavaIoFileSystemAccess> bindJavaIoFileSystemAccess() {
    return JavaIoFileSystemAccess.class;
  }
  
  protected Class<? extends IEncodingProvider> bindIEncodingProvider() {
    return IEncodingProvider.Runtime.class;
  }
}
