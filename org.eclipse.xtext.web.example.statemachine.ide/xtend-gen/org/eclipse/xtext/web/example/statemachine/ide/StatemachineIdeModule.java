/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.ide;

import com.google.inject.Provider;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider;
import org.eclipse.xtext.web.example.statemachine.ide.AbstractStatemachineIdeModule;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineImageDescriptionProvider;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineSemanticHighlightingCalculator;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineWebContentProposalProvider;

/**
 * Use this class to register ide components.
 */
@SuppressWarnings("all")
public class StatemachineIdeModule extends AbstractStatemachineIdeModule {
  public StatemachineIdeModule() {
    super();
  }
  
  public StatemachineIdeModule(final Provider<ExecutorService> executorServiceProvider) {
    super(executorServiceProvider);
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
}
