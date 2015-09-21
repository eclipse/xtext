/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.framework;

import com.google.inject.Inject;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.libraries.CustomLibraryDescription;
import javax.inject.Provider;
import javax.swing.JComponent;
import org.eclipse.xtend.core.idea.config.XtendLibraryConfigurator;
import org.eclipse.xtend.core.idea.config.XtendProjectConfigurator;
import org.eclipse.xtend.core.idea.facet.XtendFacetConfiguration;
import org.eclipse.xtend.core.idea.framework.XtendLibraryDescription;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSupportConfigurable extends FrameworkSupportInModuleConfigurable {
  @Inject
  private Provider<XtendLibraryDescription> libraryDescriptionProvider;
  
  @Inject
  private XtendLibraryConfigurator xtendLibManager;
  
  @Inject
  @Extension
  private XtendProjectConfigurator projectConfiguator;
  
  @Override
  public void addSupport(final Module module, final ModifiableRootModel rootModel, final ModifiableModelsProvider modifiableModelsProvider) {
    Module _module = rootModel.getModule();
    final XtendFacetConfiguration conf = this.projectConfiguator.createOrGetXtendFacetConf(_module);
    this.projectConfiguator.setupOutputConfiguration(rootModel, conf);
    XbaseGeneratorConfigurationState _state = conf.getState();
    this.projectConfiguator.createOutputFolders(rootModel, _state);
    this.xtendLibManager.ensureXtendLibAvailable(rootModel);
  }
  
  @Override
  public JComponent createComponent() {
    return null;
  }
  
  @Override
  public CustomLibraryDescription createLibraryDescription() {
    return this.libraryDescriptionProvider.get();
  }
}
