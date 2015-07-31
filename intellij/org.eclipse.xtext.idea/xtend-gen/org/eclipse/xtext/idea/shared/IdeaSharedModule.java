/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.shared;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.generator.trace.ITraceForURIProvider;
import org.eclipse.xtext.idea.common.types.StubTypeProviderFactory;
import org.eclipse.xtext.idea.service.IdeaOperationCanceledManager;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.TraceForVirtualFileProvider;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.service.OperationCanceledManager;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaSharedModule extends AbstractGenericModule {
  public Class<? extends IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
    return StubTypeProviderFactory.class;
  }
  
  public IResourceServiceProvider.Registry getIResourceServiceProvider$Registry() {
    return IResourceServiceProvider.Registry.INSTANCE;
  }
  
  public Class<? extends IPsiModelAssociator> bindIPsiModelAssociator() {
    return PsiModelAssociations.class;
  }
  
  public Class<? extends ITraceForVirtualFileProvider> bindTraceInformation() {
    return TraceForVirtualFileProvider.class;
  }
  
  public Class<? extends ITraceForURIProvider> bindPlatformNeutralTraceInformation() {
    return ITraceForVirtualFileProvider.class;
  }
  
  public Class<? extends OperationCanceledManager> bindOperationCanceledManager() {
    return IdeaOperationCanceledManager.class;
  }
}
