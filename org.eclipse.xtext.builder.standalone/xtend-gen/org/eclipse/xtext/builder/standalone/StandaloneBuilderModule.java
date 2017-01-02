/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone;

import com.google.inject.AbstractModule;
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
  @Override
  protected void configure() {
    this.<IResourceDescriptions>bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(ResourceSetBasedResourceDescriptions.class);
    this.<IResourceDescriptions>bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE)).to(ResourceSetBasedResourceDescriptions.class);
    this.<IResourceDescriptions>bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(ResourceSetBasedResourceDescriptions.class);
    this.<IResourceDescriptions>bind(IResourceDescriptions.class).to(ResourceSetBasedResourceDescriptions.class);
    this.<IIssueHandler>bind(IIssueHandler.class).to(this.bindIIssueHandler());
    this.<AbstractFileSystemAccess>bind(AbstractFileSystemAccess.class).to(this.bindJavaIoFileSystemAccess());
    this.<IJavaCompiler>bind(IJavaCompiler.class).to(this.bindIJavaCompiler());
    this.<IEncodingProvider>bind(IEncodingProvider.class).to(this.bindIEncodingProvider());
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
