/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider;
import org.eclipse.xtext.web.example.jetty.AbstractStatemachineWebModule;
import org.eclipse.xtext.web.example.jetty.resource.StatemachineContentTypeProvider;
import org.eclipse.xtext.web.example.jetty.resource.StatemachineResourceSetProvider;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineImageDescriptionProvider;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineSemanticHighlightingCalculator;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineWebContentProposalProvider;
import org.eclipse.xtext.web.server.generator.IContentTypeProvider;
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider;
import org.eclipse.xtext.web.server.persistence.FileResourceHandler;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;

/**
 * Use this class to register components to be used within the web application.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class StatemachineWebModule extends AbstractStatemachineWebModule {
  private final IResourceBaseProvider resourceBaseProvider;
  
  @Override
  public Class<? extends IContentTypeProvider> bindIContentTypeProvider() {
    return StatemachineContentTypeProvider.class;
  }
  
  public Class<? extends IWebResourceSetProvider> bindIWebResourceSetProvider() {
    return StatemachineResourceSetProvider.class;
  }
  
  public void configureResourceBaseProvider(final Binder binder) {
    if ((this.resourceBaseProvider != null)) {
      AnnotatedBindingBuilder<IResourceBaseProvider> _bind = binder.<IResourceBaseProvider>bind(IResourceBaseProvider.class);
      _bind.toInstance(this.resourceBaseProvider);
    }
  }
  
  public Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
    return FileResourceHandler.class;
  }
  
  public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
    return StatemachineWebContentProposalProvider.class;
  }
  
  public Class<? extends IImageDescriptionProvider> bindIImageDescriptionProvider() {
    return StatemachineImageDescriptionProvider.class;
  }
  
  public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
    return StatemachineSemanticHighlightingCalculator.class;
  }
  
  public StatemachineWebModule(final Provider<ExecutorService> executorServiceProvider, final IResourceBaseProvider resourceBaseProvider) {
    super(executorServiceProvider);
    this.resourceBaseProvider = resourceBaseProvider;
  }
}
