/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.config;

import com.google.inject.Inject;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import javax.inject.Provider;
import org.eclipse.xtend.core.idea.config.XtendSupportConfigurable;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSupportConfigurableTest extends LightXtendTest {
  @Inject
  private Provider<XtendSupportConfigurable> provider;
  
  public void testPlainJavaOutputConfiguration() {
    final XtendSupportConfigurable support = this.provider.get();
    final XbaseGeneratorConfigurationState state = new XbaseGeneratorConfigurationState();
    ModuleRootManager _instance = ModuleRootManager.getInstance(this.myModule);
    final ModifiableRootModel modifiableModel = _instance.getModifiableModel();
    support.createOutputFolders(state, modifiableModel);
    modifiableModel.commit();
  }
}
