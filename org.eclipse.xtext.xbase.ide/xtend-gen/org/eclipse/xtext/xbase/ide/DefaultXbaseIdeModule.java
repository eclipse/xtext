/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ide;

import com.google.inject.Binder;
import org.eclipse.xtext.ide.DefaultIdeModule;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
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
 * Default Guice bindings for the generic IDE contributions of the Xbase languages.
 */
@SuppressWarnings("all")
public class DefaultXbaseIdeModule extends DefaultIdeModule {
  protected static final ClasspathScanner classpathScanner = new ClasspathScanner();
  
  public void configureClasspathScanner(final Binder binder) {
    binder.<ClasspathScanner>bind(ClasspathScanner.class).toInstance(DefaultXbaseIdeModule.classpathScanner);
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
