/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.StandaloneBuilderModule;
import org.eclipse.xtext.builder.standalone.incremental.IClassFileBasedDependencyFinder;
import org.eclipse.xtext.idea.build.daemon.BuildDaemonClassFileBasedDependencyFinder;
import org.eclipse.xtext.idea.build.daemon.IdeaBuilderResourceDescriptionsProvider;
import org.eclipse.xtext.idea.build.daemon.IdeaIssueHandler;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuildDaemonModule extends StandaloneBuilderModule {
  @Override
  public Class<? extends IIssueHandler> bindIIssueHandler() {
    return IdeaIssueHandler.class;
  }
  
  @Override
  protected void configure() {
    super.configure();
    AnnotatedBindingBuilder<ResourceDescriptionsProvider> _bind = this.<ResourceDescriptionsProvider>bind(ResourceDescriptionsProvider.class);
    _bind.to(IdeaBuilderResourceDescriptionsProvider.class);
    AnnotatedBindingBuilder<IClassFileBasedDependencyFinder> _bind_1 = this.<IClassFileBasedDependencyFinder>bind(IClassFileBasedDependencyFinder.class);
    _bind_1.to(BuildDaemonClassFileBasedDependencyFinder.class);
  }
}
