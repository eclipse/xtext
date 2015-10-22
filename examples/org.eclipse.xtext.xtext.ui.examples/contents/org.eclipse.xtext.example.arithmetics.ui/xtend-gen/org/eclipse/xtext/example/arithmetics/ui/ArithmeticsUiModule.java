/**
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui;

import com.google.inject.Provider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.example.arithmetics.ui.AbstractArithmeticsUiModule;
import org.eclipse.xtext.example.arithmetics.ui.autoedit.AutoEditStrategy;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.shared.Access;

/**
 * Use this class to register components to be used within the IDE.
 */
@SuppressWarnings("all")
public class ArithmeticsUiModule extends AbstractArithmeticsUiModule {
  public ArithmeticsUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Provider<IAllContainersState> provideIAllContainersState() {
    return Access.getWorkspaceProjectsState();
  }
  
  @Override
  public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
    return ResourceForIEditorInputFactory.class;
  }
  
  @Override
  public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
    return AutoEditStrategy.class;
  }
}
