/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.client;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import org.eclipse.xtext.idea.build.client.XtextIdeaBuilder;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextIdeaBuilderModule extends AbstractModule {
  @Override
  protected void configure() {
    AnnotatedBindingBuilder<ModuleLevelBuilder> _bind = this.<ModuleLevelBuilder>bind(ModuleLevelBuilder.class);
    ScopedBindingBuilder _to = _bind.to(XtextIdeaBuilder.class);
    _to.in(Scopes.SINGLETON);
  }
}
