/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.web.server.contentassist.CrossrefProposalProvider;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalPriorities;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalProvider;
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker;
import org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider;
import org.eclipse.xtext.xbase.web.contentassist.ClasspathBasedWebTypesProposalProvider;
import org.eclipse.xtext.xbase.web.contentassist.IWebTypesProposalProvider;
import org.eclipse.xtext.xbase.web.contentassist.XbaseCrossrefProposalProvider;
import org.eclipse.xtext.xbase.web.contentassist.XbaseWebContentProposalPriorities;
import org.eclipse.xtext.xbase.web.contentassist.XbaseWebContentProposalProvider;

@SuppressWarnings("all")
public class DefaultXbaseWebModule extends AbstractGenericModule {
  public Class<? extends IFeatureScopeTracker.Provider> bindIFeatureScopeTrackerProvider() {
    return OptimizingFeatureScopeTrackerProvider.class;
  }
  
  public Class<? extends WebContentProposalProvider> bindWebContentProposalProvider() {
    return XbaseWebContentProposalProvider.class;
  }
  
  public Class<? extends CrossrefProposalProvider> bindCrossrefProposalProvider() {
    return XbaseCrossrefProposalProvider.class;
  }
  
  public Class<? extends IWebTypesProposalProvider> bindIWebTypesProposalProvider() {
    return ClasspathBasedWebTypesProposalProvider.class;
  }
  
  public Class<? extends WebContentProposalPriorities> bindWebContentProposalPriorities() {
    return XbaseWebContentProposalPriorities.class;
  }
}
