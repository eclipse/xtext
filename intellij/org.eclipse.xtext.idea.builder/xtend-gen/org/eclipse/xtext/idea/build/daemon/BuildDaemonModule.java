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
import org.eclipse.xtext.builder.standalone.incremental.IncrementalStandaloneBuilder;
import org.eclipse.xtext.idea.build.daemon.IdeaIssueHandler;
import org.eclipse.xtext.idea.build.daemon.IdeaStandaloneBuilder;

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
    AnnotatedBindingBuilder<IncrementalStandaloneBuilder> _bind = this.<IncrementalStandaloneBuilder>bind(IncrementalStandaloneBuilder.class);
    _bind.to(IdeaStandaloneBuilder.class);
  }
}
