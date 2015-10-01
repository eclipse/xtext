/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.web.server.DefaultWebModule;
import org.eclipse.xtext.xbase.ide.contentassist.ClasspathBasedIdeTypesProposalProvider;
import org.eclipse.xtext.xbase.ide.contentassist.IIdeTypesProposalProvider;
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeContentProposalPriorities;
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeContentProposalProvider;
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeCrossrefProposalProvider;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator;
import org.eclipse.xtext.xbase.ide.types.ClasspathScanner;
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker;
import org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider;

/**
 * Default Guice bindings for the web integration of Xbase languages.
 */
@SuppressWarnings("all")
public class DefaultXbaseWebModule extends DefaultWebModule {
  protected final static ClasspathScanner classpathScanner = new ClasspathScanner();
  
  public DefaultXbaseWebModule(final Provider<ExecutorService> executorServiceProvider) {
    super(executorServiceProvider);
  }
  
  public void configureClasspathScanner(final Binder binder) {
    AnnotatedBindingBuilder<ClasspathScanner> _bind = binder.<ClasspathScanner>bind(ClasspathScanner.class);
    _bind.toInstance(DefaultXbaseWebModule.classpathScanner);
  }
  
  public Class<? extends IFeatureScopeTracker.Provider> bindIFeatureScopeTrackerProvider() {
    return OptimizingFeatureScopeTrackerProvider.class;
  }
  
  public Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
    return XbaseIdeContentProposalProvider.class;
  }
  
  public Class<? extends IdeCrossrefProposalProvider> bindIdeCrossrefProposalProvider() {
    return XbaseIdeCrossrefProposalProvider.class;
  }
  
  public Class<? extends IIdeTypesProposalProvider> bindIIdeTypesProposalProvider() {
    return ClasspathBasedIdeTypesProposalProvider.class;
  }
  
  public Class<? extends IdeContentProposalPriorities> bindIdeContentProposalPriorities() {
    return XbaseIdeContentProposalPriorities.class;
  }
  
  public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
    return XbaseHighlightingCalculator.class;
  }
}
